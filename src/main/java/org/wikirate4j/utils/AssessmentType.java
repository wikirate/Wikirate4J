package org.wikirate4j.utils;
/**
 * @author Vasiliki Gkatziaki
 */
public enum AssessmentType {

    COMMUNITY_ASSESSED("Community Assessed"),
    STEWARD_ASSESSED("Steward Assessed"),
    UNKNOWN("");

    private final String value;

    private AssessmentType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static AssessmentType getAssessmentType(String assessment_type) {
        for (AssessmentType assessmentType : values()) {
            if (assessmentType.value().equals(assessment_type)) {
                return assessmentType;
            }
        }

        return UNKNOWN;
    }
}
