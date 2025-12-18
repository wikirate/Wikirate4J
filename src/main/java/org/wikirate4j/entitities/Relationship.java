package org.wikirate4j.entitities;

import java.util.List;

/**
 * Relation Metrics are a special type of metrics that produce special type of Relationship. They have been
 * created to demonstrate the relationship between two companies. Thus, the Relationship Object represent the
 * answer on a question ({@link Metric}) on a relationship between two companies on a specific year. The
 * Relationship entity extends the notion of a {@link Card} to provide additional information and functionality.
 *
 * @author Vasiliki Gkatziaki
 */
public interface Relationship extends Card {

    /**
     * The metric identifier the answer refers to
     *
     * @return the metric identifier
     */
    Long getMetricId();

    /**
     * Each Relationship Metric has an inverse Relationship Metric. This method returns the identifier of the inverse
     * relationship metric of the relationship metric the answer is referring to.
     *
     * @return the inverse metric identifier
     */
    Long getInverseMetricId();

    /**
     * Relationships have the form of &lt;subject company&gt;&lt;relationship&gt;&lt;object company&gt; e.g. &lt;Nike Inc&gt;&lt;is a competitor of&gt;&lt;Adidas AG&gt;
     * This method returns the identifier of the subject company of the relationship
     *
     * @return the identifier of the subject company
     */
    Long getSubjectCompanyId();

    /**
     * Relationships have the form of &lt;subject company&gt;&lt;relationship&gt;&lt;object company&gt; e.g. &lt;Nike Inc&gt;&lt;is a competitor of&gt;&lt;Adidas AG&gt;
     * This method returns the identifier of the object company of the relationship
     *
     * @return the identifier of the object company
     */
    Long getObjectCompanyId();

    /**
     * Relationships have the form of &lt;subject company&gt;&lt;relationship&gt;&lt;object company&gt; e.g. &lt;Nike Inc&gt;&lt;is a competitor of&gt;&lt;Adidas AG&gt;
     * This method returns the name of the subject company of the relationship
     *
     * @return the name of the subject company
     */
    String getSubjectCompany();

    /**
     * Relationships have the form of &lt;subject company&gt;&lt;relationship&gt;&lt;object company&gt; e.g. &lt;Nike Inc&gt;&lt;is a competitor of&gt;&lt;Adidas AG&gt;
     * This method returns the name of the object company of the relationship
     *
     * @return the name of the object company
     */
    String getObjectCompany();

    /**
     * Each relationship answer is referred to a specific year
     *
     * @return the year the relationship answer is referring to
     */
    Integer getYear();

    /**
     * Each Answer on a question (metric) has a value and the same applies on the relationship answers. This method
     * returns the value given the class type of the value by the user.
     *
     * @param classType
     * @param <T>
     * @return the value transformed in the given classType
     */
    <T> T getValue(Class<T> classType);

    /**
     * Each Answer on a question (metric) has a value and the same applies on the relationship answers.
     * This method returns the answer value as a string.
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
    List<Source> getSources();

    /**
     * Users are able to flag a answer to request a check in case the have doubts that the answer is correct.
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
