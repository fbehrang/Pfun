import com.fasterxml.jackson.databind.*;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if(args == null || args.length < 1) {
            throw new IllegalArgumentException("The path to the directory to watch is required!");
        }

        String directoryToWatch = args[0];
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directoryToWatch))) {
            for (Path file: stream) {
                if (!file.toString().endsWith(".json"))    continue;

                //read json file data to String
                byte[] jsonData = Files.readAllBytes(file);
                String jsonDataString = new String(jsonData, StandardCharsets.UTF_8);

                jsonDataString = checkAndFixXMLPrologTag(jsonDataString);

                // Create ObjectMapper and register module
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

                // Create a list of random addresses
                List<String> addresses = Files.readAllLines(Paths.get("replacement_data/addresses.txt"), Charset.defaultCharset());
                // Create a list of random first_names
                List<String> first_names = Files.readAllLines(Paths.get("replacement_data/first_names.txt"), Charset.defaultCharset());
                // Create a list of random last_names
                List<String> last_names = Files.readAllLines(Paths.get("replacement_data/last_names.txt"), Charset.defaultCharset());

                // connect to the database
                Connection connection = null;
                try {
                    connection = new DB().getConnection();
                } catch (SQLException e) {
                    throw new IllegalStateException("Cannot connect to the database!", e);
                }
                // create tables if they don't exist
                createTablesIfNotExist(connection);

                //read JSON like DOM Parser
                JsonNode rootNode = objectMapper.readTree(jsonDataString);
                JsonNode rowsNode = rootNode.path("rows");
                Iterator<JsonNode> rows = rowsNode.elements();
                while (rows.hasNext()) {
                    JsonNode rowNode = rows.next();
                    JsonNode sourcesNode = rowNode.path("sources");
                    Iterator<JsonNode> sources = sourcesNode.elements();

                    String member_id = null;
                    while (sources.hasNext()) {
                        AppData appData = null;
                        Employment employmentData = null;

                        JsonNode sourceNode = sources.next();
                        JsonNode formatNode = sourceNode.path("format");
                        JsonNode nameNode = sourceNode.path("name");
                        String content = sourceNode.path("values").asText();
                        if (formatNode.toString().equals("\"json\"")) {
                            // convert json string to object
                            ObjectNode values = (ObjectNode) sourceNode.path("values");
                            if (nameNode.toString().equals("\"app_data\"")) {
                                appData = getJsonAppData(objectMapper, appData, values);
                            } else if (nameNode.toString().equals("\"employment\"")) {
                                employmentData = objectMapper.readValue(values.toPrettyString(), Employment.class);
                            }
                        } else if (formatNode.toString().equals("\"csv\"")) {
                            // convert csv string to object
                            CsvMapper mapper = new CsvMapper();
                            CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(',').withoutQuoteChar();
                            if (nameNode.toString().equals("\"app_data\"")) {
                                MappingIterator<AppData> it = mapper.readerFor(AppData.class).with(schema).readValues(content);
                                if (it.hasNext()) {
                                    appData = it.next();
                                }
                            } else if (nameNode.toString().equals("\"employment\"")) {
                                MappingIterator<Employment> it = mapper.readerFor(Employment.class).with(schema).readValues(content);
                                if (it.hasNext()) employmentData = it.next();
                            }
                        } else if (formatNode.toString().equals("\"xml\"") && content != null) {
                            // convert xml string to object
                            XmlMapper xmlMapper = new XmlMapper();
                            if (nameNode.toString().equals("\"app_data\"")) {
                                appData = xmlMapper.readValue(content, AppData.class);
                            } else if (nameNode.toString().equals("\"employment\"")) {
                                employmentData = xmlMapper.readValue(content, Employment.class);
                            }
                        }

                        // anonymize the app data
                        member_id = anonymizeAppData(addresses, first_names, last_names, connection, member_id, appData, sourceNode, formatNode, content);

                        if (employmentData != null) {
                            DB.createEmploymentTable(connection);
                            DB.insertIntoEmploymentTable(connection, employmentData, member_id);
                        }

                        // write anonymized data back to the file
                        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(directoryToWatch + "/anon_data/" + file.getFileName()), rootNode);
                    }
                }
            }
        } catch (IOException | DirectoryIteratorException e) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            throw new IllegalStateException("Cannot read the JSON file!", e);
        }

    }

    private static String anonymizeAppData(List<String> addresses, List<String> first_names, List<String> last_names, Connection connection, String member_id, AppData appData, JsonNode sourceNode, JsonNode formatNode, String content) {
        if (appData != null) {
            String anonymized_first_name = first_names.get(new Random().nextInt(first_names.size()));
            String anonymized_last_name = last_names.get(new Random().nextInt(last_names.size()));
            String anonymized_address = addresses.get(new Random().nextInt(addresses.size()));
            String anonymized_phone = generateRandomPhoneNumber();
            String anonymized_dob = generateRandomDateOfBirth();

            if (formatNode.toString().equals("\"csv\"")) {
                content = content.replace(appData.getFirst_name(), anonymized_first_name)
                        .replace(appData.getLast_name(), anonymized_last_name).replace(appData.getAddress(), anonymized_address)
                        .replace(appData.getPhone(), anonymized_phone).replace(appData.getDob(), anonymized_dob);
                ((ObjectNode) sourceNode).put("values", content);
            } else {
                ObjectNode values = (ObjectNode) sourceNode.path("values");
                values.put("first_name", anonymized_first_name);
                values.put("last_name", anonymized_last_name);
                values.put("address", anonymized_address);
                values.put("phone", anonymized_phone);
                values.put("dob", anonymized_dob);
            }

            appData.setFirst_name(anonymized_first_name);
            appData.setLast_name(anonymized_last_name);
            appData.setAddress(anonymized_address);
            appData.setPhone(anonymized_phone);
            appData.setDob(anonymized_dob);
            member_id = appData.getMember_id();

            // insert data into tables
            insertIntoTables(connection, appData);
        }
        return member_id;
    }

    private static void insertIntoTables(Connection connection, AppData appData) {
        DB.insertIntoLoanTable(connection, appData);
        DB.insertIntoApplicantTable(connection, appData);
        DB.insertIntoAddressTable(connection, appData);
        DB.insertIntoFinancialHistoryTable(connection, appData);
        DB.insertIntoSecondaryApplicantTable(connection, appData);
        DB.insertIntoPaymentHistoryTable(connection, appData);
        DB.insertIntoHardshipTable(connection, appData);
        DB.insertIntoSettlementTable(connection, appData);
    }

    private static void createTablesIfNotExist(Connection connection) {
        DB.createLoanTable(connection);
        DB.createApplicantTable(connection);
        DB.createAddressTable(connection);
        DB.createFinancialHistoryTable(connection);
        DB.createSecondaryApplicantTable(connection);
        DB.createPaymentHistoryTable(connection);
        DB.createHardshipTable(connection);
        DB.createSettlementTable(connection);
    }

    private static String checkAndFixXMLPrologTag(String jsonDataString) {
        if (jsonDataString.contains("<?xml")) {
            String requiredString = jsonDataString.substring(jsonDataString.indexOf("<?xml") + 5, jsonDataString.indexOf("?>"));
            if (!requiredString.equals(" version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"")) {
                jsonDataString = jsonDataString.replace(requiredString, " version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"");
            }
        }
        return jsonDataString;
    }

    private static AppData getJsonAppData(ObjectMapper objectMapper, AppData appData, ObjectNode values) throws com.fasterxml.jackson.core.JsonProcessingException {
        try {
            appData = objectMapper.readValue(values.toPrettyString(), AppData.class);
        } catch (InvalidFormatException e) {
            String message = e.getMessage();
            String type = message.split("`")[1];
            String value = message.split("\"")[1];
            for (Field field : AppData.class.getDeclaredFields()) {
                if (field.getType().getName().equals(type)) {
                    if (values.get(field.getName()).toString().replace("\"", "").equals(value)) {
                        values.put(field.getName(), (JsonNode) null);
                    }
                }
            }
            appData = getJsonAppData(objectMapper, appData, values);
        }
        return appData;
    }

    private static String generateRandomPhoneNumber() {
        int num1, num2, num3; //3 numbers in area code
        int set2, set3; //sequence 2 and 3 of the phone number

        Random generator = new Random();

        //Area code number; Will not print 8 or 9
        num1 = generator.nextInt(7) + 1; //add 1 so there is no 0 to begin
        num2 = generator.nextInt(8); //randomize to 8 becuase 0 counts as a number in the generator
        num3 = generator.nextInt(8);

        // Sequence two of phone number
        // the plus 100 is so there will always be a 3 digit number
        // randomize to 643 because 0 starts the first placement so if i randomized up to 642 it would only go up yo 641 plus 100
        // and i used 643 so when it adds 100 it will not succeed 742
        set2 = generator.nextInt(643) + 100;

        //Sequence 3 of numebr
        // add 1000 so there will always be 4 numbers
        //8999 so it wont succed 9999 when the 1000 is added
        set3 = generator.nextInt(8999) + 1000;

        return Integer.toString(num1) + Integer.toString(num2) + Integer.toString(num3) + Integer.toString(set2) + Integer.toString(set3);
    }

    private static String generateRandomDateOfBirth() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        int min = 1920, max = 2020;

        int year = min + new Random().nextInt(max - min + 1);
        calendar.set(Calendar.YEAR, year);

        int day = 1 + new Random().nextInt(calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        calendar.set(Calendar.DAY_OF_YEAR, day);

        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }
}
