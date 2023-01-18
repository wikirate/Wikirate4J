package org.wikirate4j.entitities;

import org.wikirate4j.utils.MetricType;
import org.wikirate4j.utils.ReportType;
import org.wikirate4j.utils.ResearchPolicy;
import org.wikirate4j.utils.ValueType;

import java.util.List;

/**
 * A Wikirate {@link Metric} is used to measure company performance. It is a way of asking the same question on many
 * companies. The Metric entity extends the notion of a {@link Card} to provide additional information and functionality.
 *
 * @author Vasiliki Gkatziaki
 */
public interface Metric extends Card {

    /**
     * Each metric has a designer, individuals or organizations are the most common designers of metrics on Wikirate
     *
     * @return the name of the metric designer
     */
    String getMetricDesigner();

    /**
     * Each metric has a name which represents a shorter version of the questioned asked.
     *
     * @return the name of the metric
     */
    String getMetricName();

    /**
     * There are different metric types. All the different options of a metric type can be found in enum
     * class {@link MetricType}
     *
     * @return the metric type of the metric
     */
    MetricType getMetricType();

    /**
     * Returns the question linked to the metric
     *
     * @return the question
     */
    String getQuestion();

    /**
     * Returns some more details about the metric (why this metric is important and how it is/can be used)
     *
     * @return a string
     */
    String getAbout();

    /**
     * Description about how to research the answer
     *
     * @return a string
     */
    String getMethodology();

    /**
     * There are different value types allowed on metrics. All the different options of a value type can be found in
     * the enum class {@link ValueType}
     *
     * @return {@link ValueType}
     */
    ValueType getValueType();

    /**
     * In case of a category on a multicategory value type, a list of value options is also defined.
     *
     * @return a list of the value options
     */
    List<String> getValueOptions();

    /**
     * Report Type where the answers of the metric can be found in.
     *
     * @return {@link ReportType}
     */
    ReportType getReportType();

    /**
     * Research Policy applied on researched metrics, the research can either Community Assessed (anyone can research
     * answers) or Designer Assessed (only the designer can research answers)
     *
     * @return {@link ResearchPolicy}
     */
    ResearchPolicy getResearchPolicy();

    /**
     * In case of Number value type a unit might also be defined.
     *
     * @return the unit of the value
     */
    String getUnit();

    /**
     * In case of Number value type a range of values might also be defined (e.g. 0-100)
     *
     * @return
     */
    String getRange();

    /**
     * A list of topics related to the metric
     *
     * @return list of topic names
     */
    List<String> getTopics();

    /**
     * In case of a Formula metric type a formula is also defined in coffescript
     *
     * @return the formula in coffescript
     */
    String getFormula();

    /**
     * In case of a Formula metric type a number of variables are defined and used in the coffescript formula.
     *
     * @return a list of variables used on the formula
     */
    List<String> getVariables();

    /**
     * Number of answers this metric has.
     *
     * @return the number of answers
     */
    Integer getNumberOfAnswers();

    /**
     * Number of users that bookmarked the metric
     *
     * @return the number of bookmarkers
     */
    Integer getNumberOfBookmarkers();

    /**
     * Number of datasets the metric is included in
     *
     * @return number of datasets
     */
    Integer getNumberOfDatasets();

    /**
     * Number of companies answer the question (metric)
     *
     * @return number of companies
     */
    Integer getNumberOfCompanies();

    /**
     * List of metric names the metric is used for additional calculations
     *
     * @return list of metric names
     */
    List<String> getCalculations();

    /**
     * The URL the user can find the answers of the metric
     *
     * @return the answers url
     */
    String getAnswersURL();

}


