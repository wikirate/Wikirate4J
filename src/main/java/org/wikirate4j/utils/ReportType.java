package org.wikirate4j.utils;
/**
 * @author Vasiliki Gkatziaki
 */
public enum ReportType {
    AGGREGATE_DATA_REPORT("Aggregate Data Report"),
    ANNUAL_REPORT("Annual Report"),
    BUSINESS_RESPONSIBILITY_REPORT("Business Responsibility Report"),
    CODE_OF_CONDUCT("Code of Conduct"),
    COMMUNICATION_ON_PROGRESS("Communication on Progress"),
    COMPANY_WEBSITE("Company Website"),
    CONFLICT_MINERALS_REPORT("Conflict Minerals Report"),
    CORPORATE_ACCOUNTABILITY_INDEX("Corporate Accountability Index"),
    CORPORATE_SOCIAL_RESPONSIBILITY_REPORT("Corporate Social Responsibility Report"),
    DATA_BREACH_REPORT("Data Breach Report"),
    GENDER_PAY_GAP_REPORT("Gender Pay Gap Report"),
    HUMAN_RIGHTS_POLICY_DOCUMENT("Human Rights Policy Document"),
    INTEGRATED_REPORT("Integrated Report"),
    MEMBER_LIST("Member List"),
    MODERN_SLAVERY_REGISTRY_SUBMISSION("Modern Slavery Registry Submission"),
    MODERN_SLAVERY_STATEMENT("Modern Slavery Statement"),
    PRIVACY_POLICY_DOCUMENT("Privacy Policy Document"),
    RESEARCH_DOCUMENT("Research Document"),
    RESPONSIBLE_INVESTMENT_TRANSPARENCY_REPORT("Responsible Investment Transparency Report"),
    SIGNATORY_LIST("Signatory List"),
    STANDARD("Standard"),
    SUPPLIER_LIST("Supplier List"),
    SUPPLY_CHAIN_POLICY_DOCUMENT("Supply Chain Policy document"),
    SUSTAINABILITY_REPORT("Sustainability Report"),
    TERMS_OF_SERVICE("Terms of Service");

    private final String value;

    private ReportType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
