package org.wikirate4j.utils;
/**
 * @author Vasiliki Gkatziaki
 */
public enum SortBy {

    NAME("name"),

    MOST_ANSWERS("answer"),

    MOST_BOOKMARKED("bookmarkers"),

    RECENTLY_ADDED("create"),

    METRIC_TITLE("metric_title"),

    METRIC_DESIGNER("metric_designer"),

    MOST_COMPANIES("company"),

    BOOKMARKERS("bookmarkers"),

    MOST_DATA_SUBSETS("data_subsets"),

    MOST_METRICS("metric"),

    MOST_PROJECT("project"),

    MOST_RESEARCHERS("researcher"),

    COMPANY_NAME("company_name"),

    VALUE("value"),

    YEAR("year");


    private final String value;

    private SortBy(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
