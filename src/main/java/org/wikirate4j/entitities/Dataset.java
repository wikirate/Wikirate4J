package org.wikirate4j.entitities;

import java.util.List;

/**
 * Datasets are helping Users to structure information on WikiRate by combining Companies and Metrics associated with a
 * particular theme or research. The Dataset entity extends the notion of a {@link Card} to provide additional
 * information and functionality.
 *
 * @author Vasiliki Gkatziaki
 */
public interface Dataset extends Card {

    /**
     * Returns all the {@link Answer}s linked to the Dataset
     *
     * @return a List of Answers
     */
    List<Answer> getAnswers();

    /**
     * Returns all the {@link Metric}s of the Dataset
     *
     * @return a list of Metrics
     */
    List<String> getMetrics();

    /**
     * Returns all the Companies of the Datset
     *
     * @return a list of Companies
     */
    List<String> getCompanies();

    /**
     * Returns the license of the dataset
     *
     * @return the license a string
     */
    String getLicense();
}
