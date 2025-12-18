package org.wikirate4j.utils;

public enum LicenseType {
    CREATIVE_COMMONS_ATTRIBUTION("CC BY 4.0"),
    CREATIVE_COMMONS_ATTRIBUTION_SHAREALIKE("CC BY-SA 4.0"),
    CREATIVE_COMMONS_ATTRIBUTION_NONCOMMERCIAL("CC BY-NC 4.0"),
    CREATIVE_COMMONS_ATTRIBUTION_NONCOMMERCIAL_SHAREALIKE("CC BY-NC-SA 4.0"),
    CREATIVE_COMMONS_ATTRIBUTION_NODERIVATIVES("CC BY-ND 4.0"),
    CREATIVE_COMMONS_ATTRIBUTION_NONCOMMERCIAL_NODERIVATIVES("CC BY-NC-ND 4.0"),
    UNKNOWN("");

    private final String value;

    private LicenseType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static LicenseType getLicenseType(String license_type) {
        for (LicenseType licenseType : values()) {
            if (licenseType.value().equals(license_type)) {
                return licenseType;
            }
        }

        return UNKNOWN;
    }
}
