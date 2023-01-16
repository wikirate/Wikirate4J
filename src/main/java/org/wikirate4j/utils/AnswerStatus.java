package org.wikirate4j.utils;
/**
 * @author Vasiliki Gkatziaki
 */
public enum AnswerStatus {

    ALL("exists"),
    KLOWN("known"),
    UNKNOWN("unknown");

    private final String value;

    private AnswerStatus(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
