package org.wikirate4j.entitities;

import java.util.List;

/**
 * The Answer Object represent the answer on a question ({@link Metric}) on a specific company on a specific year.
 * The Answer entity extends the notion of a {@link Card} to provide additional information and functionality.
 *
 * @author Vasiliki Gkatziaki
 */
public interface Answer extends Card {

    /**
     * Each Answer is linked to a specific metric. The metric names consists of the metric name and the metric designer.
     *
     * @return the name of the metric the answer is linked to
     */
    String getMetricName();

    /**
     * Each Answer is linked to a specific metric. The metric names consists of the metric name and the metric designer.
     *
     * @return the name of the metric designer
     */
    String getMetricDesigner();

    /**
     * Each answer is referred to a specific company
     *
     * @return the company name
     */
    String getCompany();

    /**
     * Each answer is referred to a specific year
     *
     * @return the year the answer is referring to
     */
    Integer getYear();

    /**
     * Each Answer on a question (metric) has a value. This method returns the value given the class type of the value
     * by the user
     *
     * @param classType
     * @param <T>
     * @return the value transformed in the given classType
     */
    <T> T getValue(Class<T> classType);

    /**
     * Each Answer on a question (metric) has a value. This method returns the answer value as a string.
     *
     * @return the answer value
     */
    String getValue();

    /**
     * Each Answer also provides the record url which the user can call to get all the answers of the company
     * on the question (metric) the answer is referring to
     *
     * @return the url of the answers record
     */
    String getRecordURL();

    /**
     * Each Answer <b>must</b> cite one or more sources. The sources can link to a website or document that the answer
     * came from.
     *
     * @return a list of sources
     */
    List<SourceReference> getSources();

    /**
     * Users are able to flag an answer to request a check in case the have doubts that the answer is correct.
     *
     * @return {@link CheckedBy} information about the checks done on the answer, if any.
     */
    CheckedBy getCheckedBy();

    /**
     * Comments left on the answer
     *
     * @return the comments as a string
     */
    String getComments();
}
