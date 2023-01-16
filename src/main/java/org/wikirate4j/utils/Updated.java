package org.wikirate4j.utils;
/**
 * @author Vasiliki Gkatziaki
 */
public enum Updated {

    TODAY("today"),
    THIS_WEEK("week"),
    THIS_MONTH("month");

    private final String value;

    private Updated(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
