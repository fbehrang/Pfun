import java.sql.*;
import java.text.SimpleDateFormat;

class DB {
    private Connection connection = null;

    DB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Pfun?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
        String username = "java";
        String password = "password";
        connection = DriverManager.getConnection(url, username, password);
    }

    Connection getConnection() {
        return connection;
    }

    static void createApplicantTable(Connection connection) {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "Applicant"
                + "  (member_id                                         VARCHAR(20),"
                + "   id                                                INT,"
                + "   first_name                                        VARCHAR(20),"
                + "   last_name                                         VARCHAR(20),"
                + "   dob                                               VARCHAR(20),"
                + "   phone                                             VARCHAR(20),"
                + "   home_ownership                                    VARCHAR(20),"
                + "   annual_inc                                        VARCHAR(20),"
                + "   PRIMARY KEY (member_id),"
                + "   FOREIGN KEY (id) REFERENCES Loan(id)"
                + ");";

        executeStatement(connection, sqlCreate, "Cannot create the Applicant table!");
    }

    static void createLoanTable(Connection connection) {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "Loan"
                + "   (id                                                INT,"
                + "   term                                              VARCHAR(20),"
                + "   int_rate                                          VARCHAR(20),"
                + "   installment                                       NUMERIC(10,5),"
                + "   grade                                             VARCHAR(20),"
                + "   sub_grade                                         VARCHAR(20),"
                + "   `desc`                                            LONGTEXT,"
                + "   purpose                                           VARCHAR(20),"
                + "   initial_list_status                               VARCHAR(20),"
                + "   deferral_term                                     VARCHAR(20),"
                + "   orig_projected_additional_accrued_interest        NUMERIC(10,5),"
                + "   disbursement_method                               VARCHAR(20),"
                + "   loan_amnt                                         NUMERIC(10,5),"
                + "   funded_amnt                                       NUMERIC(10,5),"
                + "   funded_amnt_inv                                   NUMERIC(10,5),"
                + "   verification_status                               VARCHAR(20),"
                + "   issue_d                                           VARCHAR(20),"
                + "   url                                               VARCHAR(50),"
                + "   title                                             VARCHAR(20),"
                + "   application_type                                  VARCHAR(20),"
                + "   verification_status_joint                         NUMERIC(10,5),"
                + "   policy_code                                       NUMERIC(10,5),"
                + "   tax_liens                                         NUMERIC(10,5),"
                + "   PRIMARY KEY (id)"
                + ");";

        executeStatement(connection, sqlCreate, "Cannot create the Loan table!");
    }

    static void createAddressTable(Connection connection) {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "Address"
                + "  (member_id                                         VARCHAR(20),"
                + "   address                                           LONGTEXT,"
                + "   zip_code                                          VARCHAR(20),"
                + "   addr_state                                        VARCHAR(20),"
                + "   PRIMARY KEY (member_id),"
                + "   FOREIGN KEY (member_id) REFERENCES Applicant(member_id)"
                + ");";

        executeStatement(connection, sqlCreate, "Cannot create the Address table!");
    }

    static void createFinancialHistoryTable(Connection connection) {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "FinancialHistory"
                + "   (member_id                                        VARCHAR(20),"
                + "   open_acc                                          NUMERIC(10,5),"
                + "   bc_open_to_buy                                    VARCHAR(20),"
                + "   bc_util                                           VARCHAR(20),"
                + "   earliest_cr_line                                  VARCHAR(20),"
                + "   last_credit_pull_d                                VARCHAR(20),"
                + "   tot_hi_cred_lim                                   NUMERIC(10,5),"
                + "   total_il_high_credit_limit                        NUMERIC(10,5),"
                + "   il_util                                           NUMERIC(10,5),"
                + "   num_accts_ever_120_pd                             NUMERIC(10,5),"
                + "   total_acc                                         NUMERIC(10,5),"
                + "   total_bal_ex_mort                                 NUMERIC(10,5),"
                + "   total_bc_limit                                    NUMERIC(10,5),"
                + "   revol_bal                                         NUMERIC(10,5),"
                + "   revol_util                                        VARCHAR(20),"
                + "   dti_joint                                         VARCHAR(20),"
                + "   num_actv_bc_tl                                    NUMERIC(10,5),"
                + "   num_actv_rev_tl                                   NUMERIC(10,5),"
                + "   num_bc_sats                                       NUMERIC(10,5),"
                + "   num_bc_tl                                         NUMERIC(10,5),"
                + "   num_op_rev_tl                                     NUMERIC(10,5),"
                + "   num_rev_accts                                     NUMERIC(10,5),"
                + "   num_rev_tl_bal_gt_0                               NUMERIC(10,5),"
                + "   num_sats                                          NUMERIC(10,5),"
                + "   mths_since_recent_bc                              NUMERIC(10,5),"
                + "   mths_since_recent_bc_dlq                          NUMERIC(10,5),"
                + "   mths_since_recent_inq                             NUMERIC(10,5),"
                + "   mths_since_recent_revol_delinq                    NUMERIC(10,5),"
                + "   num_tl_120dpd_2m                                  NUMERIC(10,5),"
                + "   num_tl_30dpd                                      NUMERIC(10,5),"
                + "   num_tl_90g_dpd_24m                                NUMERIC(10,5),"
                + "   num_tl_op_past_12m                                NUMERIC(10,5),"
                + "   mo_sin_old_rev_tl_op                              NUMERIC(10,5),"
                + "   mo_sin_rcnt_rev_tl_op                             NUMERIC(10,5),"
                + "   mo_sin_rcnt_tl                                    VARCHAR(20),"
                + "   max_bal_bc                                        NUMERIC(10,5),"
                + "   total_rev_hi_lim                                  VARCHAR(20),"
                + "   inq_fi                                            VARCHAR(20),"
                + "   inq_last_12m                                      VARCHAR(20),"
                + "   acc_open_past_24mths                              VARCHAR(20),"
                + "   avg_cur_bal                                       VARCHAR(20),"
                + "   inq_last_6mths                                    NUMERIC(10,5),"
                + "   delinq_2yrs                                       NUMERIC(10,5),"
                + "   dti                                               NUMERIC(10,5),"
                + "   acc_now_delinq                                    NUMERIC(10,5),"
                + "   tot_coll_amt                                      NUMERIC(10,5),"
                + "   tot_cur_bal                                       NUMERIC(10,5),"
                + "   revol_bal_joint                                   NUMERIC(10,5),"
                + "   percent_bc_gt_75                                  NUMERIC(10,5),"
                + "   delinq_amnt                                       NUMERIC(10,5),"
                + "   chargeoff_within_12_mths                          NUMERIC(10,5),"
                + "   pub_rec                                           NUMERIC(10,5),"
                + "   mths_since_last_delinq                            NUMERIC(10,5),"
                + "   mths_since_last_record                            NUMERIC(10,5),"
                + "   pub_rec_bankruptcies                              NUMERIC(10,5),"
                + "   collections_12_mths_ex_med                        NUMERIC(10,5),"
                + "   mths_since_last_major_derog                       NUMERIC(10,5),"
                + "   all_util                                          VARCHAR(20),"
                + "   open_rv_12m                                       VARCHAR(20),"
                + "   open_rv_24m                                       VARCHAR(20),"
                + "   total_cu_tl                                       VARCHAR(20),"
                + "   open_acc_6m                                       VARCHAR(20),"
                + "   pct_tl_nvr_dlq                                    NUMERIC(10,5),"
                + "   num_il_tl                                         NUMERIC(10,5),"
                + "   open_act_il                                       VARCHAR(20),"
                + "   open_il_12m                                       VARCHAR(20),"
                + "   open_il_24m                                       VARCHAR(20),"
                + "   mths_since_rcnt_il                                NUMERIC(10,5),"
                + "   total_bal_il                                      NUMERIC(10,5),"
                + "   mo_sin_old_il_acct                                NUMERIC(10,5),"
                + "   mort_acc                                          VARCHAR(20),"
                + "   PRIMARY KEY (member_id),"
                + "   FOREIGN KEY (member_id) REFERENCES Applicant(member_id)"
                + ");";

        executeStatement(connection, sqlCreate, "Cannot create the FinancialHistory table!");
    }

    static void createSecondaryApplicantTable(Connection connection) {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "SecondaryApplicant"
                + "   (id                                               INT AUTO_INCREMENT,"
                + "   loan_id                                           INT,"
                + "   sec_app_earliest_cr_line                          NUMERIC(10,5),"
                + "   sec_app_inq_last_6mths                            NUMERIC(10,5),"
                + "   sec_app_mort_acc                                  NUMERIC(10,5),"
                + "   sec_app_open_acc                                  NUMERIC(10,5),"
                + "   sec_app_revol_util                                NUMERIC(10,5),"
                + "   sec_app_open_act_il                               NUMERIC(10,5),"
                + "   sec_app_num_rev_accts                             NUMERIC(10,5),"
                + "   sec_app_chargeoff_within_12_mths                  NUMERIC(10,5),"
                + "   sec_app_collections_12_mths_ex_med                NUMERIC(10,5),"
                + "   sec_app_mths_since_last_major_derog               NUMERIC(10,5),"
                + "   annual_inc_joint                                  NUMERIC(10,5),"
                + "   PRIMARY KEY (id),"
                + "   FOREIGN KEY (loan_id) REFERENCES Loan(id)"
                + ");";

        executeStatement(connection, sqlCreate, "Cannot create the SecondaryApplicant table!");
    }

    static void createPaymentHistoryTable(Connection connection) {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "PaymentHistory"
                + "   (id                                               INT AUTO_INCREMENT,"
                + "   loan_id                                           INT,"
                + "   pymnt_plan                                        VARCHAR(20),"
                + "   payment_plan_start_date                           date,"
                + "   total_pymnt                                       NUMERIC(10,5),"
                + "   total_pymnt_inv                                   NUMERIC(10,5),"
                + "   last_pymnt_d                                      VARCHAR(20),"
                + "   last_pymnt_amnt                                   NUMERIC(10,5),"
                + "   next_pymnt_d                                      VARCHAR(20),"
                + "   out_prncp                                         NUMERIC(10,5),"
                + "   out_prncp_inv                                     NUMERIC(10,5),"
                + "   total_rec_prncp                                   NUMERIC(10,5),"
                + "   total_rec_int                                     NUMERIC(10,5),"
                + "   total_rec_late_fee                                NUMERIC(10,5),"
                + "   recoveries                                        NUMERIC(10,5),"
                + "   collection_recovery_fee                           NUMERIC(10,5),"
                + "   PRIMARY KEY (id),"
                + "   FOREIGN KEY (loan_id) REFERENCES Loan(id)"
                + ");";

        executeStatement(connection, sqlCreate, "Cannot create the PaymentHistory table!");
    }

    static void createHardshipTable(Connection connection) {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "Hardship"
                + "   (id                                               INT AUTO_INCREMENT,"
                + "   loan_id                                          INT,"
                + "   hardship_status                                   VARCHAR(20),"
                + "   hardship_flag                                     VARCHAR(20),"
                + "   hardship_type                                     VARCHAR(20),"
                + "   hardship_reason                                   VARCHAR(20),"
                + "   hardship_amount                                   NUMERIC(10,5),"
                + "   hardship_start_date                               date,"
                + "   hardship_end_date                                 date,"
                + "   hardship_length                                   NUMERIC(10,5),"
                + "   hardship_dpd                                      VARCHAR(20),"
                + "   hardship_loan_status                              VARCHAR(20),"
                + "   hardship_payoff_balance_amount                    NUMERIC(10,5),"
                + "   hardship_last_payment_amount                      NUMERIC(10,5),"
                + "   PRIMARY KEY (id),"
                + "   FOREIGN KEY (loan_id) REFERENCES Loan(id)"
                + ");";

        executeStatement(connection, sqlCreate, "Cannot create the Hardship table!");
    }

    static void createSettlementTable(Connection connection) {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "Settlement"
                + "   (id                                               INT AUTO_INCREMENT,"
                + "   loan_id                                          INT,"
                + "   debt_settlement_flag                              VARCHAR(20),"
                + "   debt_settlement_flag_date                         VARCHAR(20),"
                + "   settlement_status                                 VARCHAR(20),"
                + "   settlement_date                                   VARCHAR(20),"
                + "   settlement_amount                                 NUMERIC(10,5),"
                + "   settlement_percentage                             NUMERIC(10,5),"
                + "   settlement_term                                   VARCHAR(20),"
                + "   PRIMARY KEY (id),"
                + "   FOREIGN KEY (loan_id) REFERENCES Loan(id)"
                + ");";

        executeStatement(connection, sqlCreate, "Cannot create the Settlement table!");
    }

    static void createEmploymentTable(Connection connection) {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "Employment"
                + "   (member_id                                        VARCHAR(20),"
                + "   CountryID                                         INT,"
                + "   Employer                                          VARCHAR(20),"
                + "   EmploymentType                                    NUMERIC(10,5),"
                + "   EmpOrderNum                                       NUMERIC(10,5),"
                + "   GrossMonthlyIncome                                NUMERIC(10,5),"
                + "   LenEmpMons                                        NUMERIC(10,5),"
                + "   LenEmpYears                                       NUMERIC(10,5),"
                + "   Position                                          VARCHAR(20),"
                + "   RetiredFlag                                       VARCHAR(20),"
                + "   SelfEmpFlag                                       VARCHAR(20),"
                + "   State                                             VARCHAR(20),"
                + "   PRIMARY KEY (member_id),"
                + "   FOREIGN KEY (member_id) REFERENCES Applicant(member_id)"
                + ");";

        executeStatement(connection, sqlCreate, "Cannot create the Employment table!");
    }

    static void insertIntoApplicantTable(Connection connection, AppData appData) {
        String sqlInsert = "INSERT INTO " + "Applicant"
                + "(member_id, id, first_name, last_name, dob, phone, home_ownership, annual_inc)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, appData.getMember_id());
            statement.setInt(2, appData.getId());
            statement.setString(3, appData.getFirst_name());
            statement.setString(4, appData.getLast_name());
            statement.setString(5, appData.getDob());
            statement.setString(6, appData.getPhone());
            statement.setString(7, appData.getHome_ownership());
            statement.setDouble(8, appData.getAnnual_inc());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot insert into the Applicant table!", e);
        }
    }

    static void insertIntoLoanTable(Connection connection, AppData appData) {
        String sqlInsert = "INSERT INTO " + "Loan"
                + "(id, term, int_rate, installment, grade, sub_grade, `desc`, purpose, initial_list_status"
                + ", deferral_term, orig_projected_additional_accrued_interest, disbursement_method, loan_amnt, funded_amnt"
                + ", funded_amnt_inv, verification_status, issue_d, url, title, application_type, verification_status_joint"
                + ", policy_code, tax_liens) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
                + " ON DUPLICATE KEY UPDATE id = VALUES(id), term = VALUES(term), int_rate= VALUES(int_rate),"
                + " installment = VALUES(installment), grade = VALUES(grade), sub_grade = VALUES(sub_grade), `desc` = VALUES(`desc`), purpose = VALUES(purpose), "
                + " initial_list_status = VALUES(initial_list_status), deferral_term = VALUES(deferral_term), orig_projected_additional_accrued_interest = VALUES(orig_projected_additional_accrued_interest), "
                + " disbursement_method = VALUES(disbursement_method), loan_amnt = VALUES(loan_amnt), funded_amnt= VALUES(funded_amnt), funded_amnt_inv = VALUES(funded_amnt_inv), "
                + " verification_status = VALUES(verification_status), issue_d = VALUES(issue_d), url = VALUES(url), title= VALUES(title), application_type = VALUES(application_type), "
                + " verification_status_joint = VALUES(verification_status_joint), policy_code = VALUES(policy_code), tax_liens = VALUES(tax_liens)";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setInt(1, appData.getId());
            statement.setString(2, appData.getTerm());
            statement.setString(3, appData.getInt_rate());
            statement.setDouble(4, appData.getInstallment());
            statement.setString(5, appData.getGrade());
            statement.setString(6, appData.getSub_grade());
            statement.setString(7, appData.getDesc());
            statement.setString(8, appData.getPurpose());
            statement.setString(9, appData.getInitial_list_status());
            statement.setString(10, appData.getDeferral_term());
            statement.setObject(11, appData.getOrig_projected_additional_accrued_interest(), Types.INTEGER);
            statement.setString(12, appData.getDisbursement_method());
            statement.setDouble(13, appData.getLoan_amnt());
            statement.setDouble(14, appData.getFunded_amnt());
            statement.setDouble(15, appData.getFunded_amnt_inv());
            statement.setString(16, appData.getVerification_status());
            statement.setString(17, appData.getIssue_d());
            statement.setString(18, appData.getUrl());
            statement.setString(19, appData.getTitle());
            statement.setString(20, appData.getApplication_type());
            statement.setObject(21, appData.getVerification_status_joint(), Types.INTEGER);
            statement.setInt(22, appData.getPolicy_code());
            statement.setDouble(23, appData.getTax_liens());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot insert into the Loan table!", e);
        }
    }

    static void insertIntoAddressTable(Connection connection, AppData appData) {
        String sqlInsert = "INSERT INTO " + "Address"
                + "(member_id, address, zip_code, addr_state)"
                + "VALUES(?, ?, ?, ?);";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, appData.getMember_id());
            statement.setString(2, appData.getAddress());
            statement.setString(3, appData.getZip_code());
            statement.setString(4, appData.getAddr_state());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot insert into the Applicant table!", e);
        }
    }

    static void insertIntoFinancialHistoryTable(Connection connection, AppData appData) {
        String sqlInsert = "INSERT INTO " + "FinancialHistory"
                + "(member_id, open_acc, bc_open_to_buy, bc_util, earliest_cr_line, last_credit_pull_d, tot_hi_cred_lim"
                + ", total_il_high_credit_limit, il_util, num_accts_ever_120_pd, total_acc, total_bal_ex_mort"
                + ", total_bc_limit, revol_bal, revol_util, dti_joint, num_actv_bc_tl, num_actv_rev_tl, num_bc_sats, num_bc_tl"
                + ", num_op_rev_tl, num_rev_accts, num_rev_tl_bal_gt_0, num_sats, mths_since_recent_bc, mths_since_recent_bc_dlq"
                + ", mths_since_recent_inq, mths_since_recent_revol_delinq, num_tl_120dpd_2m, num_tl_30dpd, num_tl_90g_dpd_24m"
                + ", num_tl_op_past_12m, mo_sin_old_rev_tl_op, mo_sin_rcnt_rev_tl_op, mo_sin_rcnt_tl, max_bal_bc, total_rev_hi_lim"
                + ", inq_fi, inq_last_12m, acc_open_past_24mths, avg_cur_bal, inq_last_6mths, delinq_2yrs, dti, acc_now_delinq"
                + ", tot_coll_amt, tot_cur_bal, revol_bal_joint, percent_bc_gt_75, delinq_amnt, chargeoff_within_12_mths"
                + ", pub_rec, mths_since_last_delinq, mths_since_last_record, pub_rec_bankruptcies, collections_12_mths_ex_med"
                + ", mths_since_last_major_derog, all_util, open_rv_12m, open_rv_24m, total_cu_tl, open_acc_6m, pct_tl_nvr_dlq"
                + ", num_il_tl, open_act_il, open_il_12m, open_il_24m, mths_since_rcnt_il, total_bal_il, mo_sin_old_il_acct"
                + ", mort_acc)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, appData.getMember_id());
            statement.setInt(2, appData.getOpen_acc());
            statement.setString(3, appData.getBc_open_to_buy());
            statement.setString(4, appData.getBc_util());
            statement.setString(5, appData.getEarliest_cr_line());
            statement.setString(6, appData.getLast_credit_pull_d());
            statement.setObject(7, appData.getTot_hi_cred_lim(), Types.DOUBLE);
            statement.setObject(8, appData.getTotal_il_high_credit_limit(), Types.DOUBLE);
            statement.setObject(9, appData.getIl_util(), Types.INTEGER);
            statement.setObject(10, appData.getNum_accts_ever_120_pd(), Types.INTEGER);
            statement.setObject(11, appData.getTotal_acc(), Types.INTEGER);
            statement.setObject(12, appData.getTotal_bal_ex_mort(), Types.DOUBLE);
            statement.setObject(13, appData.getTotal_bc_limit(), Types.DOUBLE);
            statement.setObject(14, appData.getRevol_bal(), Types.INTEGER);
            statement.setString(15, appData.getRevol_util());
            statement.setString(16, appData.getDti_joint());
            statement.setObject(17, appData.getNum_actv_bc_tl(), Types.INTEGER);
            statement.setObject(18, appData.getNum_actv_rev_tl(), Types.INTEGER);
            statement.setObject(19, appData.getNum_bc_sats(), Types.INTEGER);
            statement.setObject(20, appData.getNum_bc_tl(), Types.INTEGER);
            statement.setObject(21, appData.getNum_op_rev_tl(), Types.INTEGER);
            statement.setObject(22, appData.getNum_rev_accts(), Types.INTEGER);
            statement.setObject(23, appData.getNum_rev_tl_bal_gt_0(), Types.INTEGER);
            statement.setObject(24, appData.getNum_sats(), Types.INTEGER);
            statement.setObject(25, appData.getMths_since_recent_bc(), Types.INTEGER);
            statement.setObject(26, appData.getMths_since_recent_bc_dlq(), Types.INTEGER);
            statement.setObject(27, appData.getMths_since_recent_inq(), Types.INTEGER);
            statement.setObject(28, appData.getMths_since_recent_revol_delinq(), Types.INTEGER);
            statement.setObject(29, appData.getNum_tl_120dpd_2m(), Types.INTEGER);
            statement.setObject(30, appData.getNum_tl_30dpd(), Types.INTEGER);
            statement.setObject(31, appData.getNum_tl_90g_dpd_24m(), Types.INTEGER);
            statement.setObject(32, appData.getNum_tl_op_past_12m(), Types.INTEGER);
            statement.setObject(33, appData.getMo_sin_old_rev_tl_op(), Types.INTEGER);
            statement.setObject(34, appData.getMo_sin_rcnt_rev_tl_op(), Types.INTEGER);
            statement.setString(35, appData.getMo_sin_rcnt_tl());
            statement.setObject(36, appData.getMax_bal_bc(), Types.INTEGER);
            statement.setString(37, appData.getTotal_rev_hi_lim());
            statement.setString(38, appData.getInq_fi());
            statement.setString(39, appData.getInq_last_12m());
            statement.setString(40, appData.getAcc_open_past_24mths());
            statement.setString(41, appData.getAvg_cur_bal());
            statement.setObject(42, appData.getInq_last_6mths(), Types.INTEGER);
            statement.setObject(43, appData.getDelinq_2yrs(), Types.DOUBLE);
            statement.setObject(44, appData.getDti(), Types.DOUBLE);
            statement.setObject(45, appData.getAcc_now_delinq(), Types.INTEGER);
            statement.setObject(46, appData.getTot_coll_amt(), Types.INTEGER);
            statement.setObject(47, appData.getTot_cur_bal(), Types.INTEGER);
            statement.setObject(48, appData.getRevol_bal_joint(), Types.DOUBLE);
            statement.setObject(49, appData.getPercent_bc_gt_75(), Types.INTEGER);
            statement.setObject(50, appData.getDelinq_amnt(), Types.DOUBLE);
            statement.setObject(51, appData.getChargeoff_within_12_mths(), Types.DOUBLE);
            statement.setObject(52, appData.getPub_rec(), Types.INTEGER);
            statement.setObject(53, appData.getMths_since_last_delinq(), Types.INTEGER);
            statement.setObject(54, appData.getMths_since_last_record(), Types.INTEGER);
            statement.setObject(55, appData.getPub_rec_bankruptcies(), Types.DOUBLE);
            statement.setObject(56, appData.getCollections_12_mths_ex_med(), Types.DOUBLE);
            statement.setObject(57, appData.getMths_since_last_major_derog(), Types.INTEGER);
            statement.setString(58, appData.getAll_util());
            statement.setString(59, appData.getOpen_rv_12m());
            statement.setString(60, appData.getOpen_rv_24m());
            statement.setString(61, appData.getTotal_cu_tl());
            statement.setString(62, appData.getOpen_acc_6m());
            statement.setObject(63, appData.getPct_tl_nvr_dlq(), Types.INTEGER);
            statement.setObject(64, appData.getNum_il_tl(), Types.INTEGER);
            statement.setString(65, appData.getOpen_act_il());
            statement.setString(66, appData.getOpen_il_12m());
            statement.setString(67, appData.getOpen_il_24m());
            statement.setObject(68, appData.getMths_since_rcnt_il(), Types.INTEGER);
            statement.setObject(69, appData.getTotal_bal_il(), Types.INTEGER);
            statement.setObject(70, appData.getMo_sin_old_il_acct(), Types.INTEGER);
            statement.setString(71, appData.getMort_acc());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot insert into the FinancialHistory table!", e);
        }
    }

    static void insertIntoSecondaryApplicantTable(Connection connection, AppData appData) {
        String sqlInsert = "INSERT INTO " + "SecondaryApplicant"
                + "(loan_id, sec_app_earliest_cr_line, sec_app_inq_last_6mths, sec_app_mort_acc, sec_app_open_acc, sec_app_revol_util"
                + ", sec_app_open_act_il, sec_app_num_rev_accts, sec_app_chargeoff_within_12_mths, sec_app_collections_12_mths_ex_med"
                + ", sec_app_mths_since_last_major_derog, annual_inc_joint)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setInt(1, appData.id);
            statement.setObject(2, appData.getSec_app_earliest_cr_line(), Types.INTEGER);
            statement.setObject(3, appData.getSec_app_inq_last_6mths(), Types.INTEGER);
            statement.setObject(4, appData.getSec_app_mort_acc(), Types.INTEGER);
            statement.setObject(5, appData.getSec_app_open_acc(), Types.DOUBLE);
            statement.setObject(6, appData.getSec_app_revol_util(), Types.INTEGER);
            statement.setObject(7, appData.getSec_app_open_act_il(), Types.INTEGER);
            statement.setObject(8, appData.getSec_app_num_rev_accts(), Types.INTEGER);
            statement.setObject(9, appData.getSec_app_chargeoff_within_12_mths(), Types.INTEGER);
            statement.setObject(10, appData.getSec_app_collections_12_mths_ex_med(), Types.INTEGER);
            statement.setObject(11, appData.getSec_app_mths_since_last_major_derog(), Types.INTEGER);
            statement.setObject(12, appData.getAnnual_inc_joint(), Types.INTEGER);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot insert into the SecondaryApplicant table!", e);
        }
    }

    static void insertIntoPaymentHistoryTable(Connection connection, AppData appData) {
        String sqlInsert = "INSERT INTO " + "PaymentHistory"
                + "(loan_id, pymnt_plan, payment_plan_start_date, total_pymnt, total_pymnt_inv, last_pymnt_d, last_pymnt_amnt"
                + ", next_pymnt_d, out_prncp, out_prncp_inv, total_rec_prncp, total_rec_int, total_rec_late_fee, recoveries"
                + ", collection_recovery_fee)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setInt(1, appData.getId());
            statement.setString(2, appData.getPymnt_plan());
            statement.setDate(3, appData.getPayment_plan_start_date());
            statement.setDouble(4, appData.getTotal_pymnt());
            statement.setDouble(5, appData.getTotal_pymnt_inv());
            statement.setString(6, appData.getLast_pymnt_d());
            statement.setDouble(7, appData.getLast_pymnt_amnt());
            statement.setString(8, appData.getNext_pymnt_d());
            statement.setInt(9, appData.getOut_prncp());
            statement.setInt(10, appData.getOut_prncp_inv());
            statement.setDouble(11, appData.getTotal_rec_prncp());
            statement.setDouble(12, appData.getTotal_rec_int());
            statement.setDouble(13, appData.getTotal_rec_late_fee());
            statement.setDouble(14, appData.getRecoveries());
            statement.setDouble(15, appData.getCollection_recovery_fee());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot insert into the PaymentHistory table!", e);
        }
    }

    static void insertIntoHardshipTable(Connection connection, AppData appData) {
        String sqlInsert = "INSERT INTO " + "Hardship"
                + "(loan_id, hardship_status, hardship_flag, hardship_type, hardship_reason, hardship_amount, hardship_start_date"
                + ", hardship_end_date, hardship_length, hardship_dpd, hardship_loan_status, hardship_payoff_balance_amount"
                + ", hardship_last_payment_amount)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setObject(1, appData.getId(), Types.INTEGER);
            statement.setString(2, appData.getHardship_status());
            statement.setString(3, appData.getHardship_flag());
            statement.setString(4, appData.getHardship_type());
            statement.setString(5, appData.getHardship_reason());
            statement.setObject(6, appData.getHardship_amount(), Types.DOUBLE);
            statement.setDate(7, appData.getHardship_start_date());
            statement.setDate(8, appData.getHardship_end_date());
            statement.setObject(9, appData.getHardship_length(), Types.INTEGER);
            statement.setString(10, appData.getHardship_dpd());
            statement.setString(11, appData.getHardship_loan_status());
            statement.setObject(12, appData.getHardship_payoff_balance_amount(), Types.DOUBLE);
            statement.setObject(13, appData.getHardship_last_payment_amount(), Types.DOUBLE);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot insert into the Hardship table!", e);
        }
    }

    static void insertIntoSettlementTable(Connection connection, AppData appData) {
        String sqlInsert = "INSERT INTO " + "Settlement"
                + "(loan_id, debt_settlement_flag, debt_settlement_flag_date, settlement_status, settlement_date"
                + ", settlement_amount , settlement_percentage, settlement_term)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setInt(1, appData.getId());
            statement.setString(2, appData.getDebt_settlement_flag());
            statement.setString(3, appData.getDebt_settlement_flag_date());
            statement.setString(4, appData.getSettlement_status());
            statement.setString(5, appData.getSettlement_date());
            statement.setObject(6, appData.getSettlement_amount(), Types.DOUBLE);
            statement.setObject(7, appData.getSettlement_percentage(), Types.DOUBLE);
            statement.setString(8, appData.getSettlement_term());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot insert into the Settlement table!", e);
        }
    }

    static void insertIntoEmploymentTable(Connection connection, Employment employment, String member_id) {
        String sqlInsert = "INSERT INTO " + "Employment"
                + "(member_id, CountryID, Employer, EmploymentType, EmpOrderNum, GrossMonthlyIncome, LenEmpMons, LenEmpYears"
                + ", Position , RetiredFlag, SelfEmpFlag, State)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, member_id);
            statement.setInt(2, employment.getCountryID());
            statement.setString(3, employment.getEmployer());
            statement.setInt(4, employment.getEmploymentType());
            statement.setInt(5, employment.getEmpOrderNum());
            statement.setDouble(6, employment.getGrossMonthlyIncome());
            statement.setDouble(7, employment.getLenEmpMons());
            statement.setInt(8, employment.getLenEmpYears());
            statement.setString(9, employment.getPosition());
            statement.setString(10, employment.getRetiredFlag());
            statement.setString(11, employment.getSelfEmpFlag());
            statement.setString(12, employment.getState());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot insert into the Employment table!", e);
        }
    }

    private static void executeStatement(Connection connection, String sqlCreate, String message) {
        Statement stmt;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            throw new IllegalStateException(message, e);
        }
    }

    static void query(Connection connection, String query) {
        ResultSet results;
        try {
            Statement stmt = connection.createStatement();
            results = stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot execute the following query:" + query, e);
        }

        DBTablePrinter.printResultSet(results);
    }
}
