package org.wikirate4j.entitities;

import java.util.List;
/**
 * @author Vasiliki Gkatziaki
 */
public interface Source extends Card{

    String getTitle();

    String getFile();

    String getLink();

    List<String> getReportTypes();

    List<Integer> getYears();

    String getDescription();

    List<String> getCompanies();

    List<String> getMetrics();

    List<String> getAnswers();
}
