package org.wikirate4j.utils;
/**
 * @author Vasiliki Gkatziaki
 */
public enum Updater {

    ME("current_user"),
    WIKIRATE_TEAM("wikirate_team");

    private final String value;

    private Updater(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
