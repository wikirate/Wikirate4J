package org.wikirate4j.utils;
/**
 * @author Vasiliki Gkatziaki
 */
public enum ValueType {

    NUMBER("Number"),
    MONEY("Money"),
    CATEGORY("Category"),
    MULTI_CATEGORY("Multi-Category"),
    FREE_TEXT("Free Text");

    private final String value;

    private ValueType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
