package org.wikirate4j.utils;

/**
 * @author Vasiliki Gkatziaki
 */
public enum MetricType {

    RESEARCHED("Researched"),
    RELATIONSHIP("Relationship"),
    INVERSE_RELATIONSHIP("Inverse Relationship"),
    FORMULA("Formula"),
    WIKIRATING("WikiRating"),
    SCORE("Score"),
    DESCENDANT("Descendant"),
    UNKNOWN("Unknown");

    private final String value;

    private MetricType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static MetricType getMetricType(String metric_type) {
        for (MetricType metricType : values()) {
            if (metricType.value().equals(metric_type)) {
                return metricType;
            }
        }

        return UNKNOWN;
    }
}
