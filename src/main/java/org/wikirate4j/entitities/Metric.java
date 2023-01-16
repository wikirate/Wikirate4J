package org.wikirate4j.entitities;

import java.util.List;
/**
 * @author Vasiliki Gkatziaki
 */
public interface Metric extends Card{

    String getMetricDesigner();

    String getMetricName();

    String getMetricType();

    String getQuestion();

    String getAbout();

    String getMethodology();

    String getValueType();

    List<String> getValueOptions();

    String getReportType();

    String getResearchPolicy();

    String getUnit();

    String getRange();

    List<String> getTopics();

    String getFormula();

    List<String> getVariables();

    Integer getNumberOfAnswers();

    Integer getNumberOfBookmarkers();

    Integer getNumberOfDatasets();

    Integer getNumberOfCompanies();

    List<String> getCalculations();

    String getAnswersURL();

}


