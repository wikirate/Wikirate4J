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
    DESCENDANT("Descendant");

    private final String value;

    private MetricType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
