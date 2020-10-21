import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.sql.Date;

@JsonPropertyOrder({ "id", "member_id", "first_name", "last_name", "address", "dob", "phone", "loan_amnt", "funded_amnt", "funded_amnt_inv", "term", "int_rate", "installment", "grade", "sub_grade", "home_ownership", "annual_inc", "verification_status", "issue_d", "pymnt_plan", "url", "desc", "purpose", "title", "zip_code", "addr_state", "dti", "delinq_2yrs", "earliest_cr_line", "inq_last_6mths", "mths_since_last_delinq", "mths_since_last_record", "open_acc", "pub_rec", "revol_bal", "revol_util", "total_acc", "initial_list_status", "out_prncp", "out_prncp_inv", "total_pymnt", "total_pymnt_inv", "total_rec_prncp", "total_rec_int", "total_rec_late_fee", "recoveries", "collection_recovery_fee", "last_pymnt_d", "last_pymnt_amnt", "next_pymnt_d", "last_credit_pull_d", "collections_12_mths_ex_med", "mths_since_last_major_derog", "policy_code", "application_type", "annual_inc_joint", "dti_joint", "verification_status_joint", "acc_now_delinq", "tot_coll_amt", "tot_cur_bal", "open_acc_6m", "open_act_il", "open_il_12m", "open_il_24m", "mths_since_rcnt_il", "total_bal_il", "il_util", "open_rv_12m", "open_rv_24m", "max_bal_bc", "all_util", "total_rev_hi_lim", "inq_fi", "total_cu_tl", "inq_last_12m", "acc_open_past_24mths", "avg_cur_bal", "bc_open_to_buy", "bc_util", "chargeoff_within_12_mths", "delinq_amnt", "mo_sin_old_il_acct", "mo_sin_old_rev_tl_op", "mo_sin_rcnt_rev_tl_op", "mo_sin_rcnt_tl", "mort_acc", "mths_since_recent_bc", "mths_since_recent_bc_dlq", "mths_since_recent_inq", "mths_since_recent_revol_delinq", "num_accts_ever_120_pd", "num_actv_bc_tl", "num_actv_rev_tl", "num_bc_sats", "num_bc_tl", "num_il_tl", "num_op_rev_tl", "num_rev_accts", "num_rev_tl_bal_gt_0", "num_sats", "num_tl_120dpd_2m", "num_tl_30dpd", "num_tl_90g_dpd_24m", "num_tl_op_past_12m", "pct_tl_nvr_dlq", "percent_bc_gt_75", "pub_rec_bankruptcies", "tax_liens", "tot_hi_cred_lim", "total_bal_ex_mort", "total_bc_limit", "total_il_high_credit_limit", "revol_bal_joint", "sec_app_earliest_cr_line", "sec_app_inq_last_6mths", "sec_app_mort_acc", "sec_app_open_acc", "sec_app_revol_util", "sec_app_open_act_il", "sec_app_num_rev_accts", "sec_app_chargeoff_within_12_mths", "sec_app_collections_12_mths_ex_med", "sec_app_mths_since_last_major_derog", "hardship_flag", "hardship_type", "hardship_reason", "hardship_status", "deferral_term", "hardship_amount", "hardship_start_date", "hardship_end_date", "payment_plan_start_date", "hardship_length", "hardship_dpd", "hardship_loan_status", "orig_projected_additional_accrued_interest", "hardship_payoff_balance_amount", "hardship_last_payment_amount", "disbursement_method", "debt_settlement_flag", "debt_settlement_flag_date", "settlement_status", "settlement_date", "settlement_amount", "settlement_percentage", "settlement_term"})
public class AppData {
    Integer id;
    private String member_id;
    private String first_name;
    private String last_name;
    private String address;
    private String dob;
    private String phone;
    private Double loan_amnt;
    private Double funded_amnt;
    private Double funded_amnt_inv;
    private String term;
    private String int_rate;
    private Double installment;
    private String grade;
    private String sub_grade;
    private String home_ownership;
    private Double annual_inc;
    private String verification_status;
    private String issue_d;
    private String pymnt_plan;
    private String url;
    private String desc;
    private String purpose;
    private String title;
    private String zip_code;
    private String addr_state;
    private Double dti;
    private Double delinq_2yrs;
    private String earliest_cr_line;
    private Integer inq_last_6mths;
    private Integer mths_since_last_delinq;
    private Integer mths_since_last_record;
    private Integer open_acc;
    private Integer pub_rec;
    private Integer revol_bal;
    private String revol_util;
    private Integer total_acc;
    private String initial_list_status;
    private Integer out_prncp;
    private Integer out_prncp_inv;
    private Double total_pymnt;
    private Double total_pymnt_inv;
    private Double total_rec_prncp;
    private Double total_rec_int;
    private Double total_rec_late_fee;
    private Double recoveries;
    private Double collection_recovery_fee;
    private String last_pymnt_d;
    private Double last_pymnt_amnt;
    private String next_pymnt_d;
    private String last_credit_pull_d;
    private Double collections_12_mths_ex_med;
    private Integer mths_since_last_major_derog;
    private Integer policy_code;
    private String application_type;
    private Integer annual_inc_joint;
    private String dti_joint;
    private Integer verification_status_joint;
    private Integer acc_now_delinq;
    private Integer tot_coll_amt;
    private Integer tot_cur_bal;
    private String open_acc_6m;
    private String open_act_il;
    private String open_il_12m;
    private String open_il_24m;
    private Integer mths_since_rcnt_il;
    private Integer total_bal_il;
    private Integer il_util;
    private String open_rv_12m;
    private String open_rv_24m;
    private Integer max_bal_bc;
    private String all_util;
    private String total_rev_hi_lim;
    private String inq_fi;
    private String total_cu_tl;
    private String inq_last_12m;
    private String acc_open_past_24mths;
    private String avg_cur_bal;
    private String bc_open_to_buy;
    private String bc_util;
    private Double chargeoff_within_12_mths;
    private Double delinq_amnt;
    private Integer mo_sin_old_il_acct;
    private Integer mo_sin_old_rev_tl_op;
    private Integer mo_sin_rcnt_rev_tl_op;
    private String mo_sin_rcnt_tl;
    private String mort_acc;
    private Integer mths_since_recent_bc;
    private Integer mths_since_recent_bc_dlq;
    private Integer mths_since_recent_inq;
    private Integer mths_since_recent_revol_delinq;
    private Integer num_accts_ever_120_pd;
    private Integer num_actv_bc_tl;
    private Integer num_actv_rev_tl;
    private Integer num_bc_sats;
    private Integer num_bc_tl;
    private Integer num_il_tl;
    private Integer num_op_rev_tl;
    private Integer num_rev_accts;
    private Integer num_rev_tl_bal_gt_0;
    private Integer num_sats;
    private Integer num_tl_120dpd_2m;
    private Integer num_tl_30dpd;
    private Integer num_tl_90g_dpd_24m;
    private Integer num_tl_op_past_12m;
    private Integer pct_tl_nvr_dlq;
    private Integer percent_bc_gt_75;
    private Double pub_rec_bankruptcies;
    private Double tax_liens;
    private Double tot_hi_cred_lim;
    private Double total_bal_ex_mort;
    private Double total_bc_limit;
    private Double total_il_high_credit_limit;
    private Double revol_bal_joint;
    private Integer sec_app_earliest_cr_line;
    private Integer sec_app_inq_last_6mths;
    private Integer sec_app_mort_acc;
    private Integer sec_app_open_acc;
    private Integer sec_app_revol_util;
    private Integer sec_app_open_act_il;
    private Integer sec_app_num_rev_accts;
    private Integer sec_app_chargeoff_within_12_mths;
    private Integer sec_app_collections_12_mths_ex_med;
    private Integer sec_app_mths_since_last_major_derog;
    private String hardship_flag;
    private String hardship_type;
    private String hardship_reason;
    private String hardship_status;
    private String deferral_term;
    private Double hardship_amount;
    private Date hardship_start_date;
    private Date hardship_end_date;
    private Date payment_plan_start_date;
    private Integer hardship_length;
    private String hardship_dpd;
    private String hardship_loan_status;
    private Integer orig_projected_additional_accrued_interest;
    private Double hardship_payoff_balance_amount;
    private Double hardship_last_payment_amount;
    private String disbursement_method;
    private String debt_settlement_flag;
    private String debt_settlement_flag_date;
    private String settlement_status;
    private String settlement_date;
    private Double settlement_amount;
    private Double settlement_percentage;
    private String settlement_term;

    public AppData () {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getLoan_amnt() {
        return loan_amnt;
    }

    public void setLoan_amnt(Double loan_amnt) {
        this.loan_amnt = loan_amnt;
    }

    public Double getFunded_amnt() {
        return funded_amnt;
    }

    public void setFunded_amnt(Double funded_amnt) {
        this.funded_amnt = funded_amnt;
    }

    public Double getFunded_amnt_inv() {
        return funded_amnt_inv;
    }

    public void setFunded_amnt_inv(Double funded_amnt_inv) {
        this.funded_amnt_inv = funded_amnt_inv;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getInt_rate() {
        return int_rate;
    }

    public void setInt_rate(String int_rate) {
        this.int_rate = int_rate;
    }

    public Double getInstallment() {
        return installment;
    }

    public void setInstallment(Double installment) {
        this.installment = installment;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSub_grade() {
        return sub_grade;
    }

    public void setSub_grade(String sub_grade) {
        this.sub_grade = sub_grade;
    }

    public String getHome_ownership() {
        return home_ownership;
    }

    public void setHome_ownership(String home_ownership) {
        this.home_ownership = home_ownership;
    }

    public double getAnnual_inc() {
        return annual_inc;
    }

    public void setAnnual_inc(double annual_inc) {
        this.annual_inc = annual_inc;
    }

    public String getVerification_status() {
        return verification_status;
    }

    public void setVerification_status(String verification_status) {
        this.verification_status = verification_status;
    }

    public String getIssue_d() {
        return issue_d;
    }

    public void setIssue_d(String issue_d) {
        this.issue_d = issue_d;
    }

    public String getPymnt_plan() {
        return pymnt_plan;
    }

    public void setPymnt_plan(String pymnt_plan) {
        this.pymnt_plan = pymnt_plan;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getAddr_state() {
        return addr_state;
    }

    public void setAddr_state(String addr_state) {
        this.addr_state = addr_state;
    }

    public Double getDti() {
        return dti;
    }

    public void setDti(Double dti) {
        this.dti = dti;
    }

    public Double getDelinq_2yrs() {
        return delinq_2yrs;
    }

    public void setDelinq_2yrs(Double delinq_2yrs) {
        this.delinq_2yrs = delinq_2yrs;
    }

    public String getEarliest_cr_line() {
        return earliest_cr_line;
    }

    public void setEarliest_cr_line(String earliest_cr_line) {
        this.earliest_cr_line = earliest_cr_line;
    }

    public Integer getInq_last_6mths() {
        return inq_last_6mths;
    }

    public void setInq_last_6mths(Integer inq_last_6mths) {
        this.inq_last_6mths = inq_last_6mths;
    }

    public Integer getMths_since_last_delinq() {
        return mths_since_last_delinq;
    }

    public void setMths_since_last_delinq(Integer mths_since_last_delinq) {
        this.mths_since_last_delinq = mths_since_last_delinq;
    }

    public Integer getMths_since_last_record() {
        return mths_since_last_record;
    }

    public void setMths_since_last_record(Integer mths_since_last_record) {
        this.mths_since_last_record = mths_since_last_record;
    }

    public Integer getOpen_acc() {
        return open_acc;
    }

    public void setOpen_acc(Integer open_acc) {
        this.open_acc = open_acc;
    }

    public Integer getPub_rec() {
        return pub_rec;
    }

    public void setPub_rec(Integer pub_rec) {
        this.pub_rec = pub_rec;
    }

    public Integer getRevol_bal() {
        return revol_bal;
    }

    public void setRevol_bal(Integer revol_bal) {
        this.revol_bal = revol_bal;
    }

    public String getRevol_util() {
        return revol_util;
    }

    public void setRevol_util(String revol_util) {
        this.revol_util = revol_util;
    }

    public Integer getTotal_acc() {
        return total_acc;
    }

    public void setTotal_acc(Integer total_acc) {
        this.total_acc = total_acc;
    }

    public String getInitial_list_status() {
        return initial_list_status;
    }

    public void setInitial_list_status(String initial_list_status) {
        this.initial_list_status = initial_list_status;
    }

    public Integer getOut_prncp() {
        return out_prncp;
    }

    public void setOut_prncp(Integer out_prncp) {
        this.out_prncp = out_prncp;
    }

    public Integer getOut_prncp_inv() {
        return out_prncp_inv;
    }

    public void setOut_prncp_inv(Integer out_prncp_inv) {
        this.out_prncp_inv = out_prncp_inv;
    }

    public Double getTotal_pymnt() {
        return total_pymnt;
    }

    public void setTotal_pymnt(Double total_pymnt) {
        this.total_pymnt = total_pymnt;
    }

    public Double getTotal_pymnt_inv() {
        return total_pymnt_inv;
    }

    public void setTotal_pymnt_inv(Double total_pymnt_inv) {
        this.total_pymnt_inv = total_pymnt_inv;
    }

    public Double getTotal_rec_prncp() {
        return total_rec_prncp;
    }

    public void setTotal_rec_prncp(Double total_rec_prncp) {
        this.total_rec_prncp = total_rec_prncp;
    }

    public Double getTotal_rec_int() {
        return total_rec_int;
    }

    public void setTotal_rec_int(Double total_rec_int) {
        this.total_rec_int = total_rec_int;
    }

    public Double getTotal_rec_late_fee() {
        return total_rec_late_fee;
    }

    public void setTotal_rec_late_fee(Double total_rec_late_fee) {
        this.total_rec_late_fee = total_rec_late_fee;
    }

    public Double getRecoveries() {
        return recoveries;
    }

    public void setRecoveries(Double recoveries) {
        this.recoveries = recoveries;
    }

    public Double getCollection_recovery_fee() {
        return collection_recovery_fee;
    }

    public void setCollection_recovery_fee(Double collection_recovery_fee) {
        this.collection_recovery_fee = collection_recovery_fee;
    }

    public String getLast_pymnt_d() {
        return last_pymnt_d;
    }

    public void setLast_pymnt_d(String last_pymnt_d) {
        this.last_pymnt_d = last_pymnt_d;
    }

    public Double getLast_pymnt_amnt() {
        return last_pymnt_amnt;
    }

    public void setLast_pymnt_amnt(Double last_pymnt_amnt) {
        this.last_pymnt_amnt = last_pymnt_amnt;
    }

    public String getNext_pymnt_d() {
        return next_pymnt_d;
    }

    public void setNext_pymnt_d(String next_pymnt_d) {
        this.next_pymnt_d = next_pymnt_d;
    }

    public String getLast_credit_pull_d() {
        return last_credit_pull_d;
    }

    public void setLast_credit_pull_d(String last_credit_pull_d) {
        this.last_credit_pull_d = last_credit_pull_d;
    }

    public Double getCollections_12_mths_ex_med() {
        return collections_12_mths_ex_med;
    }

    public void setCollections_12_mths_ex_med(Double collections_12_mths_ex_med) {
        this.collections_12_mths_ex_med = collections_12_mths_ex_med;
    }

    public Integer getMths_since_last_major_derog() {
        return mths_since_last_major_derog;
    }

    public void setMths_since_last_major_derog(Integer mths_since_last_major_derog) {
        this.mths_since_last_major_derog = mths_since_last_major_derog;
    }

    public Integer getPolicy_code() {
        return policy_code;
    }

    public void setPolicy_code(Integer policy_code) {
        this.policy_code = policy_code;
    }

    public String getApplication_type() {
        return application_type;
    }

    public void setApplication_type(String application_type) {
        this.application_type = application_type;
    }

    public Integer getAnnual_inc_joint() {
        return annual_inc_joint;
    }

    public void setAnnual_inc_joint(Integer annual_inc_joint) {
        this.annual_inc_joint = annual_inc_joint;
    }

    public String getDti_joint() {
        return dti_joint;
    }

    public void setDti_joint(String dti_joint) {
        this.dti_joint = dti_joint;
    }

    public Integer getVerification_status_joint() {
        return verification_status_joint;
    }

    public void setVerification_status_joint(Integer verification_status_joint) {
        this.verification_status_joint = verification_status_joint;
    }

    public Integer getAcc_now_delinq() {
        return acc_now_delinq;
    }

    public void setAcc_now_delinq(Integer acc_now_delinq) {
        this.acc_now_delinq = acc_now_delinq;
    }

    public Integer getTot_coll_amt() {
        return tot_coll_amt;
    }

    public void setTot_coll_amt(Integer tot_coll_amt) {
        this.tot_coll_amt = tot_coll_amt;
    }

    public Integer getTot_cur_bal() {
        return tot_cur_bal;
    }

    public void setTot_cur_bal(Integer tot_cur_bal) {
        this.tot_cur_bal = tot_cur_bal;
    }

    public String getOpen_acc_6m() {
        return open_acc_6m;
    }

    public void setOpen_acc_6m(String open_acc_6m) {
        this.open_acc_6m = open_acc_6m;
    }

    public String getOpen_act_il() {
        return open_act_il;
    }

    public void setOpen_act_il(String open_act_il) {
        this.open_act_il = open_act_il;
    }

    public String getOpen_il_12m() {
        return open_il_12m;
    }

    public void setOpen_il_12m(String open_il_12m) {
        this.open_il_12m = open_il_12m;
    }

    public String getOpen_il_24m() {
        return open_il_24m;
    }

    public void setOpen_il_24m(String open_il_24m) {
        this.open_il_24m = open_il_24m;
    }

    public Integer getMths_since_rcnt_il() {
        return mths_since_rcnt_il;
    }

    public void setMths_since_rcnt_il(Integer mths_since_rcnt_il) {
        this.mths_since_rcnt_il = mths_since_rcnt_il;
    }

    public Integer getTotal_bal_il() {
        return total_bal_il;
    }

    public void setTotal_bal_il(Integer total_bal_il) {
        this.total_bal_il = total_bal_il;
    }

    public Integer getIl_util() {
        return il_util;
    }

    public void setIl_util(Integer il_util) {
        this.il_util = il_util;
    }

    public String getOpen_rv_12m() {
        return open_rv_12m;
    }

    public void setOpen_rv_12m(String open_rv_12m) {
        this.open_rv_12m = open_rv_12m;
    }

    public String getOpen_rv_24m() {
        return open_rv_24m;
    }

    public void setOpen_rv_24m(String open_rv_24m) {
        this.open_rv_24m = open_rv_24m;
    }

    public Integer getMax_bal_bc() {
        return max_bal_bc;
    }

    public void setMax_bal_bc(Integer max_bal_bc) {
        this.max_bal_bc = max_bal_bc;
    }

    public String getAll_util() {
        return all_util;
    }

    public void setAll_util(String all_util) {
        this.all_util = all_util;
    }

    public String getTotal_rev_hi_lim() {
        return total_rev_hi_lim;
    }

    public void setTotal_rev_hi_lim(String total_rev_hi_lim) {
        this.total_rev_hi_lim = total_rev_hi_lim;
    }

    public String getInq_fi() {
        return inq_fi;
    }

    public void setInq_fi(String inq_fi) {
        this.inq_fi = inq_fi;
    }

    public String getTotal_cu_tl() {
        return total_cu_tl;
    }

    public void setTotal_cu_tl(String total_cu_tl) {
        this.total_cu_tl = total_cu_tl;
    }

    public String getInq_last_12m() {
        return inq_last_12m;
    }

    public void setInq_last_12m(String inq_last_12m) {
        this.inq_last_12m = inq_last_12m;
    }

    public String getAcc_open_past_24mths() {
        return acc_open_past_24mths;
    }

    public void setAcc_open_past_24mths(String acc_open_past_24mths) {
        this.acc_open_past_24mths = acc_open_past_24mths;
    }

    public String getAvg_cur_bal() {
        return avg_cur_bal;
    }

    public void setAvg_cur_bal(String avg_cur_bal) {
        this.avg_cur_bal = avg_cur_bal;
    }

    public String getBc_open_to_buy() {
        return bc_open_to_buy;
    }

    public void setBc_open_to_buy(String bc_open_to_buy) {
        this.bc_open_to_buy = bc_open_to_buy;
    }

    public String getBc_util() {
        return bc_util;
    }

    public void setBc_util(String bc_util) {
        this.bc_util = bc_util;
    }

    public Double getChargeoff_within_12_mths() {
        return chargeoff_within_12_mths;
    }

    public void setChargeoff_within_12_mths(Double chargeoff_within_12_mths) {
        this.chargeoff_within_12_mths = chargeoff_within_12_mths;
    }

    public Double getDelinq_amnt() {
        return delinq_amnt;
    }

    public void setDelinq_amnt(Double delinq_amnt) {
        this.delinq_amnt = delinq_amnt;
    }

    public Integer getMo_sin_old_il_acct() {
        return mo_sin_old_il_acct;
    }

    public void setMo_sin_old_il_acct(Integer mo_sin_old_il_acct) {
        this.mo_sin_old_il_acct = mo_sin_old_il_acct;
    }

    public Integer getMo_sin_old_rev_tl_op() {
        return mo_sin_old_rev_tl_op;
    }

    public void setMo_sin_old_rev_tl_op(Integer mo_sin_old_rev_tl_op) {
        this.mo_sin_old_rev_tl_op = mo_sin_old_rev_tl_op;
    }

    public Integer getMo_sin_rcnt_rev_tl_op() {
        return mo_sin_rcnt_rev_tl_op;
    }

    public void setMo_sin_rcnt_rev_tl_op(Integer mo_sin_rcnt_rev_tl_op) {
        this.mo_sin_rcnt_rev_tl_op = mo_sin_rcnt_rev_tl_op;
    }

    public String getMo_sin_rcnt_tl() {
        return mo_sin_rcnt_tl;
    }

    public void setMo_sin_rcnt_tl(String mo_sin_rcnt_tl) {
        this.mo_sin_rcnt_tl = mo_sin_rcnt_tl;
    }

    public String getMort_acc() {
        return mort_acc;
    }

    public void setMort_acc(String mort_acc) {
        this.mort_acc = mort_acc;
    }

    public Integer getMths_since_recent_bc() {
        return mths_since_recent_bc;
    }

    public void setMths_since_recent_bc(Integer mths_since_recent_bc) {
        this.mths_since_recent_bc = mths_since_recent_bc;
    }

    public Integer getMths_since_recent_bc_dlq() {
        return mths_since_recent_bc_dlq;
    }

    public void setMths_since_recent_bc_dlq(Integer mths_since_recent_bc_dlq) {
        this.mths_since_recent_bc_dlq = mths_since_recent_bc_dlq;
    }

    public Integer getMths_since_recent_inq() {
        return mths_since_recent_inq;
    }

    public void setMths_since_recent_inq(Integer mths_since_recent_inq) {
        this.mths_since_recent_inq = mths_since_recent_inq;
    }

    public Integer getMths_since_recent_revol_delinq() {
        return mths_since_recent_revol_delinq;
    }

    public void setMths_since_recent_revol_delinq(Integer mths_since_recent_revol_delinq) {
        this.mths_since_recent_revol_delinq = mths_since_recent_revol_delinq;
    }

    public Integer getNum_accts_ever_120_pd() {
        return num_accts_ever_120_pd;
    }

    public void setNum_accts_ever_120_pd(Integer num_accts_ever_120_pd) {
        this.num_accts_ever_120_pd = num_accts_ever_120_pd;
    }

    public Integer getNum_actv_bc_tl() {
        return num_actv_bc_tl;
    }

    public void setNum_actv_bc_tl(Integer num_actv_bc_tl) {
        this.num_actv_bc_tl = num_actv_bc_tl;
    }

    public Integer getNum_actv_rev_tl() {
        return num_actv_rev_tl;
    }

    public void setNum_actv_rev_tl(Integer num_actv_rev_tl) {
        this.num_actv_rev_tl = num_actv_rev_tl;
    }

    public Integer getNum_bc_sats() {
        return num_bc_sats;
    }

    public void setNum_bc_sats(Integer num_bc_sats) {
        this.num_bc_sats = num_bc_sats;
    }

    public Integer getNum_bc_tl() {
        return num_bc_tl;
    }

    public void setNum_bc_tl(Integer num_bc_tl) {
        this.num_bc_tl = num_bc_tl;
    }

    public Integer getNum_il_tl() {
        return num_il_tl;
    }

    public void setNum_il_tl(Integer num_il_tl) {
        this.num_il_tl = num_il_tl;
    }

    public Integer getNum_op_rev_tl() {
        return num_op_rev_tl;
    }

    public void setNum_op_rev_tl(Integer num_op_rev_tl) {
        this.num_op_rev_tl = num_op_rev_tl;
    }

    public Integer getNum_rev_accts() {
        return num_rev_accts;
    }

    public void setNum_rev_accts(Integer num_rev_accts) {
        this.num_rev_accts = num_rev_accts;
    }

    public Integer getNum_rev_tl_bal_gt_0() {
        return num_rev_tl_bal_gt_0;
    }

    public void setNum_rev_tl_bal_gt_0(Integer num_rev_tl_bal_gt_0) {
        this.num_rev_tl_bal_gt_0 = num_rev_tl_bal_gt_0;
    }

    public Integer getNum_sats() {
        return num_sats;
    }

    public void setNum_sats(Integer num_sats) {
        this.num_sats = num_sats;
    }

    public Integer getNum_tl_120dpd_2m() {
        return num_tl_120dpd_2m;
    }

    public void setNum_tl_120dpd_2m(Integer num_tl_120dpd_2m) {
        this.num_tl_120dpd_2m = num_tl_120dpd_2m;
    }

    public Integer getNum_tl_30dpd() {
        return num_tl_30dpd;
    }

    public void setNum_tl_30dpd(Integer num_tl_30dpd) {
        this.num_tl_30dpd = num_tl_30dpd;
    }

    public Integer getNum_tl_90g_dpd_24m() {
        return num_tl_90g_dpd_24m;
    }

    public void setNum_tl_90g_dpd_24m(Integer num_tl_90g_dpd_24m) {
        this.num_tl_90g_dpd_24m = num_tl_90g_dpd_24m;
    }

    public Integer getNum_tl_op_past_12m() {
        return num_tl_op_past_12m;
    }

    public void setNum_tl_op_past_12m(Integer num_tl_op_past_12m) {
        this.num_tl_op_past_12m = num_tl_op_past_12m;
    }

    public Integer getPct_tl_nvr_dlq() {
        return pct_tl_nvr_dlq;
    }

    public void setPct_tl_nvr_dlq(Integer pct_tl_nvr_dlq) {
        this.pct_tl_nvr_dlq = pct_tl_nvr_dlq;
    }

    public Integer getPercent_bc_gt_75() {
        return percent_bc_gt_75;
    }

    public void setPercent_bc_gt_75(Integer percent_bc_gt_75) {
        this.percent_bc_gt_75 = percent_bc_gt_75;
    }

    public Double getPub_rec_bankruptcies() {
        return pub_rec_bankruptcies;
    }

    public void setPub_rec_bankruptcies(Double pub_rec_bankruptcies) {
        this.pub_rec_bankruptcies = pub_rec_bankruptcies;
    }

    public Double getTax_liens() {
        return tax_liens;
    }

    public void setTax_liens(Double tax_liens) {
        this.tax_liens = tax_liens;
    }

    public Double getTot_hi_cred_lim() {
        return tot_hi_cred_lim;
    }

    public void setTot_hi_cred_lim(Double tot_hi_cred_lim) {
        this.tot_hi_cred_lim = tot_hi_cred_lim;
    }

    public Double getTotal_bal_ex_mort() {
        return total_bal_ex_mort;
    }

    public void setTotal_bal_ex_mort(Double total_bal_ex_mort) {
        this.total_bal_ex_mort = total_bal_ex_mort;
    }

    public Double getTotal_bc_limit() {
        return total_bc_limit;
    }

    public void setTotal_bc_limit(Double total_bc_limit) {
        this.total_bc_limit = total_bc_limit;
    }

    public Double getTotal_il_high_credit_limit() {
        return total_il_high_credit_limit;
    }

    public void setTotal_il_high_credit_limit(Double total_il_high_credit_limit) {
        this.total_il_high_credit_limit = total_il_high_credit_limit;
    }

    public Double getRevol_bal_joint() {
        return revol_bal_joint;
    }

    public void setRevol_bal_joint(Double revol_bal_joint) {
        this.revol_bal_joint = revol_bal_joint;
    }

    public Integer getSec_app_earliest_cr_line() {
        return sec_app_earliest_cr_line;
    }

    public void setSec_app_earliest_cr_line(Integer sec_app_earliest_cr_line) {
        this.sec_app_earliest_cr_line = sec_app_earliest_cr_line;
    }

    public Integer getSec_app_inq_last_6mths() {
        return sec_app_inq_last_6mths;
    }

    public void setSec_app_inq_last_6mths(Integer sec_app_inq_last_6mths) {
        this.sec_app_inq_last_6mths = sec_app_inq_last_6mths;
    }

    public Integer getSec_app_mort_acc() {
        return sec_app_mort_acc;
    }

    public void setSec_app_mort_acc(Integer sec_app_mort_acc) {
        this.sec_app_mort_acc = sec_app_mort_acc;
    }

    public Integer getSec_app_open_acc() {
        return sec_app_open_acc;
    }

    public void setSec_app_open_acc(Integer sec_app_open_acc) {
        this.sec_app_open_acc = sec_app_open_acc;
    }

    public Integer getSec_app_revol_util() {
        return sec_app_revol_util;
    }

    public void setSec_app_revol_util(Integer sec_app_revol_util) {
        this.sec_app_revol_util = sec_app_revol_util;
    }

    public Integer getSec_app_open_act_il() {
        return sec_app_open_act_il;
    }

    public void setSec_app_open_act_il(Integer sec_app_open_act_il) {
        this.sec_app_open_act_il = sec_app_open_act_il;
    }

    public Integer getSec_app_num_rev_accts() {
        return sec_app_num_rev_accts;
    }

    public void setSec_app_num_rev_accts(Integer sec_app_num_rev_accts) {
        this.sec_app_num_rev_accts = sec_app_num_rev_accts;
    }

    public Integer getSec_app_chargeoff_within_12_mths() {
        return sec_app_chargeoff_within_12_mths;
    }

    public void setSec_app_chargeoff_within_12_mths(Integer sec_app_chargeoff_within_12_mths) {
        this.sec_app_chargeoff_within_12_mths = sec_app_chargeoff_within_12_mths;
    }

    public Integer getSec_app_collections_12_mths_ex_med() {
        return sec_app_collections_12_mths_ex_med;
    }

    public void setSec_app_collections_12_mths_ex_med(Integer sec_app_collections_12_mths_ex_med) {
        this.sec_app_collections_12_mths_ex_med = sec_app_collections_12_mths_ex_med;
    }

    public Integer getSec_app_mths_since_last_major_derog() {
        return sec_app_mths_since_last_major_derog;
    }

    public void setSec_app_mths_since_last_major_derog(Integer sec_app_mths_since_last_major_derog) {
        this.sec_app_mths_since_last_major_derog = sec_app_mths_since_last_major_derog;
    }

    public String getHardship_flag() {
        return hardship_flag;
    }

    public void setHardship_flag(String hardship_flag) {
        this.hardship_flag = hardship_flag;
    }

    public String getHardship_type() {
        return hardship_type;
    }

    public void setHardship_type(String hardship_type) {
        this.hardship_type = hardship_type;
    }

    public String getHardship_reason() {
        return hardship_reason;
    }

    public void setHardship_reason(String hardship_reason) {
        this.hardship_reason = hardship_reason;
    }

    public String getHardship_status() {
        return hardship_status;
    }

    public void setHardship_status(String hardship_status) {
        this.hardship_status = hardship_status;
    }

    public String getDeferral_term() {
        return deferral_term;
    }

    public void setDeferral_term(String deferral_term) {
        this.deferral_term = deferral_term;
    }

    public Double getHardship_amount() {
        return hardship_amount;
    }

    public void setHardship_amount(Double hardship_amount) {
        this.hardship_amount = hardship_amount;
    }

    public Date getHardship_start_date() {
        return hardship_start_date;
    }

    public void setHardship_start_date(Date hardship_start_date) {
        this.hardship_start_date = hardship_start_date;
    }

    public Date getHardship_end_date() {
        return hardship_end_date;
    }

    public void setHardship_end_date(Date hardship_end_date) {
        this.hardship_end_date = hardship_end_date;
    }

    public Date getPayment_plan_start_date() {
        return payment_plan_start_date;
    }

    public void setPayment_plan_start_date(Date payment_plan_start_date) {
        this.payment_plan_start_date = payment_plan_start_date;
    }

    public Integer getHardship_length() {
        return hardship_length;
    }

    public void setHardship_length(Integer hardship_length) {
        this.hardship_length = hardship_length;
    }

    public String getHardship_dpd() {
        return hardship_dpd;
    }

    public void setHardship_dpd(String hardship_dpd) {
        this.hardship_dpd = hardship_dpd;
    }

    public String getHardship_loan_status() {
        return hardship_loan_status;
    }

    public void setHardship_loan_status(String hardship_loan_status) {
        this.hardship_loan_status = hardship_loan_status;
    }

    public Integer getOrig_projected_additional_accrued_interest() {
        return orig_projected_additional_accrued_interest;
    }

    public void setOrig_projected_additional_accrued_interest(Integer orig_projected_additional_accrued_interest) {
        this.orig_projected_additional_accrued_interest = orig_projected_additional_accrued_interest;
    }

    public Double getHardship_payoff_balance_amount() {
        return hardship_payoff_balance_amount;
    }

    public void setHardship_payoff_balance_amount(Double hardship_payoff_balance_amount) {
        this.hardship_payoff_balance_amount = hardship_payoff_balance_amount;
    }

    public Double getHardship_last_payment_amount() {
        return hardship_last_payment_amount;
    }

    public void setHardship_last_payment_amount(Double hardship_last_payment_amount) {
        this.hardship_last_payment_amount = hardship_last_payment_amount;
    }

    public String getDisbursement_method() {
        return disbursement_method;
    }

    public void setDisbursement_method(String disbursement_method) {
        this.disbursement_method = disbursement_method;
    }

    public String getDebt_settlement_flag() {
        return debt_settlement_flag;
    }

    public void setDebt_settlement_flag(String debt_settlement_flag) {
        this.debt_settlement_flag = debt_settlement_flag;
    }

    public String getDebt_settlement_flag_date() {
        return debt_settlement_flag_date;
    }

    public void setDebt_settlement_flag_date(String debt_settlement_flag_date) {
        this.debt_settlement_flag_date = debt_settlement_flag_date;
    }

    public String getSettlement_status() {
        return settlement_status;
    }

    public void setSettlement_status(String settlement_status) {
        this.settlement_status = settlement_status;
    }

    public String getSettlement_date() {
        return settlement_date;
    }

    public void setSettlement_date(String settlement_date) {
        this.settlement_date = settlement_date;
    }

    public Double getSettlement_amount() {
        return settlement_amount;
    }

    public void setSettlement_amount(Double settlement_amount) {
        this.settlement_amount = settlement_amount;
    }

    public Double getSettlement_percentage() {
        return settlement_percentage;
    }

    public void setSettlement_percentage(Double settlement_percentage) {
        this.settlement_percentage = settlement_percentage;
    }

    public String getSettlement_term() {
        return settlement_term;
    }

    public void setSettlement_term(String settlement_term) {
        this.settlement_term = settlement_term;
    }
}
