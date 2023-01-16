package org.wikirate4j.utils;
/**
 * @author Vasiliki Gkatziaki
 */
public enum PublicationStatus {

    PUBLISHED("true"),
    UNPUBLISHED("false"),
    EITHER("all");

    private final String value;

    private PublicationStatus(String value) {
        this.value = value;
    }

    public String value(){
        return this.value;
    }
}
