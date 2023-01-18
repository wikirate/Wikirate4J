package org.wikirate4j.entitities;

import java.util.List;

/**
 * Company Groups are company groupings based on user defined preferences. The CompanyGroup entity extends the notion
 * of a {@link Card} to provide additional information and functionality.
 *
 * @author Vasiliki Gkatziaki
 */
public interface CompanyGroup extends Card {

    /**
     * The list of companies, the company group contains
     *
     * @return
     */
    List<String> getCompanies();

    /**
     * The list of links to wikirate companies, the company group contains.
     *
     * @return
     */
    List<String> getLinksOfCompanies();

    /**
     * A specification is used when the company group created implicitly by using a filter on a metric.
     *
     * @return the specification used for the creation of the company group
     */
    String getSpecification();
}
