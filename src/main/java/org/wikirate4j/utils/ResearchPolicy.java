package org.wikirate4j.utils;
/**
 * @author Vasiliki Gkatziaki
 */
public enum ResearchPolicy {

    COMMUNITY_ASSESSED("Community Assessed"),
    DESIGNER_ASSESSED("Designer_Assessed"),
    UNKNOWN("");

    private final String value;

    private ResearchPolicy(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static ResearchPolicy getResearchPolicy(String research_policy) {
        for (ResearchPolicy researchPolicy : values()) {
            if (researchPolicy.value().equals(research_policy)) {
                return researchPolicy;
            }
        }

        return UNKNOWN;
    }
}
