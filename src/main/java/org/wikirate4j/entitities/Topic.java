package org.wikirate4j.entitities;

import org.wikirate4j.utils.TopicFramework;

import java.util.List;

/**
 * Topics are used in Wikirate as a way to organize Metrics and other content into thematic groups. The Topic entity
 * extends the notion of a {@link Card} to provide additional information and functionality.
 *
 * @author Vasiliki Gkatziaki
 */
public interface Topic extends Card {

    /**
     * Returns the display title of the topic.
     *
     * @return the topic title
     */
    String getTitle();

    /**
     * Returns the framework to which this topic belongs
     * (e.g. WikiRate ESG Topics, GRI Standards).
     *
     * @return the topic framework
     */
    TopicFramework getFramework();

    /**
     * Returns the topic family.
     *
     * @return the topic family
     */
    String getFamily();

    /**
     * Returns the child topics of this topic.
     *
     * @return a list of child topic names, or an empty list if none exist
     */
    List<String> getChildren();

    /**
     * Returns the parent topic, if any.
     *
     * @return the parent topic name, or {@code null} if none exists
     */
    String getParent();

    /**
     * Returns the URL for retrieving metrics associated with this topic.
     *
     * @return the metrics URL
     */
    String getMetrics();

    /**
     * Returns the URL for retrieving datasets associated with this topic.
     *
     * @return the datasets URL
     */
    String getDatasets();
}
