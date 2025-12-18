package org.wikirate4j.utils;

/**
 * @author Vasiliki Gkatziaki
 */
public enum TopicFramework {

    WIKIRATE_ESG_TOPICS("Wikirate ESG Topics"),
    GRI_STANDARDS("GRI Standards"),
    ESRS_STANDARDS("ESRS Standards"),
    UN_SDGs("UN SDGs"),
    UNKNOWN("");

    private final String value;

    private TopicFramework(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static TopicFramework getTopicFramework(String topic_framework) {
        for (TopicFramework topicFramework : values()) {
            if (topicFramework.value().equals(topic_framework)) {
                return topicFramework;
            }
        }

        return UNKNOWN;
    }
}
