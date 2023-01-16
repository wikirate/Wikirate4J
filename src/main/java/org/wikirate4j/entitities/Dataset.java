package org.wikirate4j.entitities;

import java.util.List;
/**
 * @author Vasiliki Gkatziaki
 */
public interface Dataset extends Card {

    List<Answer> getAnswers();

    List<String> getMetrics();

    List<String> getCompanies();

    String getLicense();
}
