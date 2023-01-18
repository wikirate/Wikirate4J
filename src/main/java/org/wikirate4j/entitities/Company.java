package org.wikirate4j.entitities;

import java.util.List;

/**
 * As Company, Wikirate, considers any formal reporting organization (including corporations, NGOs, Universities etc.).
 * The Company entity extends the notion of a {@link Card} to provide additional information and functionality..
 *
 * @author Vasiliki Gkatziaki
 */
public interface Company extends Card {

    /**
     * Returns the wikipedia name if exists
     *
     * @return wikipedia name of the entity
     */
    String getWikipedia();

    /**
     * Returns the identifier the company has on opencorporates.com
     *
     * @return
     */
    String getOpenCorporates();

    /**
     * Returns a list of aliases the company has
     *
     * @return a list of aliases
     */
    List<String> getAliases();

    /**
     * Returns the location the headquarters of the company are
     *
     * @return the headquarters
     */
    String getHeadquarters();

    /**
     * Returns the open supply hub identifier of the company, if exists (https://opensupplyhub.org/)
     *
     * @return the open supply hub identifier
     */
    String getOpenSupplyHubId();

    /**
     * Returns the Central Index Key of the company, if exists as it is stored by sec.gov
     *
     * @return the CIK identifier
     */
    String getCIK();

    /**
     * The URL of all the answers the specific company has.
     *
     * @return the answers url
     */
    String getAnswersUrl();

}
