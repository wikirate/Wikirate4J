package org.wikirate4j.utils;

/**
 * @author Vasiliki Gkatziaki
 */
public enum VerificationStatus {
    FLAGGED("flagged"),
    UNVERIFIED("unverified"),
    VERIFIED_BY_COMMUNITY("community_verified"),
    VERIFIED_BY_STEWARD("steward_verified"),
    VERIFIED_BY_ME("current_user"),
    VERIFIED_BY_WIKIRATE_TEAM("wikirate_team");

    private final String value;

    private VerificationStatus(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
