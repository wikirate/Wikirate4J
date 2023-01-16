package org.wikirate4j.utils;
/**
 * @author Vasiliki Gkatziaki
 */
public enum ProjectStatus {

    ACTIVE("Active"),
    INACTIVE("Inactive");

    private final String value;

    private ProjectStatus(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
