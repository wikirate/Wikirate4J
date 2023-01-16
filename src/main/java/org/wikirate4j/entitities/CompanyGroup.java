package org.wikirate4j.entitities;

import java.util.List;
/**
 * @author Vasiliki Gkatziaki
 */
public interface CompanyGroup extends Card{

    List<String> getCompanies();

    List<String> getLinksOfCompanies();

    String getSpecification();
}
