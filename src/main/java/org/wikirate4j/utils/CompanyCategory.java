package org.wikirate4j.utils;
/**
 * @author Vasiliki Gkatziaki
 */
public enum CompanyCategory {
    FINANCIAL("F"),
    HEALTH_AND_EDUCATION("H"),
    INFRASTRUCTURE("I"),
    MANUFACTURING("M"),
    RAW_MATERIAL_PRODUCER("R"),
    SCIENCE_AND_TECHNOLOGY("S"),
    WHOLESALE_AND_RETAIL("W"),
    OTHER("O");

    private final String value;

    private CompanyCategory(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
