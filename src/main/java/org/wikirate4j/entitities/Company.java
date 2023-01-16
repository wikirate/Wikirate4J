package org.wikirate4j.entitities;

import java.util.List;
/**
 * @author Vasiliki Gkatziaki
 */
public interface Company extends Card {

    String getWikipedia();

    String getOpenCorporates();

    List<String> getAliases();

    String getHeadquarters();

    String getOpenSupplyHubId();

    String getCIK();

    String getAnswersUrl();

}
