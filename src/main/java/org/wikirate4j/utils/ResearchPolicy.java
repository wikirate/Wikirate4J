package org.wikirate4j.utils;
/**
 * @author Vasiliki Gkatziaki
 */
public enum ResearchPolicy {

    COMMUNITY_ASSESSED("Community Assessed"),
    DESIGNER_ASSESSED("Designer_Assessed");

    private final String value;

    private ResearchPolicy(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
