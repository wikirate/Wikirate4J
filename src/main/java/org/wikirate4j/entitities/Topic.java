package org.wikirate4j.entitities;

/**
 * Topics are used in Wikirate as a way to organize Metrics and other content into thematic groups. The Topic entity
 * extends the notion of a {@link Card} to provide additional information and functionality.
 *
 * @author Vasiliki Gkatziaki
 */
public interface Topic extends Card {

    /**
     * Number of users they have been bookmark the topic
     *
     * @return number of bookmarkers
     */
    Integer getBookmarkers();

    /**
     * Number of metrics linked to the Topic
     *
     * @return number of metrics
     */
    Integer getMetrics();

    /**
     * Number of datasets linked to the Topic
     *
     * @return number of datasets
     */
    Integer getDatasets();
}
