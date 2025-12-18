package org.wikirate4j.utils;

/**
 * @author Vasiliki Gkatziaki
 */
public enum MetricType {

    RESEARCHED("Researched"),
    RELATION("Relation"),
    INVERSE_RELATION("Inverse Relation"),
    FORMULA("Formula"),
    RATING("Rating"),
    SCORE("Score"),
    DESCENDANT("Descendant"),
    UNKNOWN("");

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
