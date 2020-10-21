import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "countryID", "employer", "employmentType", "empOrderNum", "grossMonthlyIncome", "lenEmpMons", "lenEmpYears", "position", "retiredFlag", "selfEmpFlag", "state"})
public class Employment {
    @JsonProperty("CountryID")
    private int countryID;
    @JsonProperty("Employer")
    private String employer;
    @JsonProperty("EmploymentType")
    private int employmentType;
    @JsonProperty("EmpOrderNum")
    private int empOrderNum;
    @JsonProperty("GrossMonthlyIncome")
    private int grossMonthlyIncome;
    @JsonProperty("LenEmpMons")
    private int lenEmpMons;
    @JsonProperty("LenEmpYears")
    private int lenEmpYears;
    @JsonProperty("Position")
    private String position;
    @JsonProperty("RetiredFlag")
    private String retiredFlag;
    @JsonProperty("SelfEmpFlag")
    private String selfEmpFlag;
    @JsonProperty("State")
    private String state;

    public Employment() { }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public int getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(int employmentType) {
        this.employmentType = employmentType;
    }

    public int getEmpOrderNum() {
        return empOrderNum;
    }

    public void setEmpOrderNum(int empOrderNum) {
        this.empOrderNum = empOrderNum;
    }

    public int getGrossMonthlyIncome() {
        return grossMonthlyIncome;
    }

    public void setGrossMonthlyIncome(int grossMonthlyIncome) {
        this.grossMonthlyIncome = grossMonthlyIncome;
    }

    public int getLenEmpMons() {
        return lenEmpMons;
    }

    public void setLenEmpMons(int lenEmpMons) {
        this.lenEmpMons = lenEmpMons;
    }

    public int getLenEmpYears() {
        return lenEmpYears;
    }

    public void setLenEmpYears(int lenEmpYears) {
        this.lenEmpYears = lenEmpYears;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRetiredFlag() {
        return retiredFlag;
    }

    public void setRetiredFlag(String retiredFlag) {
        this.retiredFlag = retiredFlag;
    }

    public String getSelfEmpFlag() {
        return selfEmpFlag;
    }

    public void setSelfEmpFlag(String selfEmpFlag) {
        this.selfEmpFlag = selfEmpFlag;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
