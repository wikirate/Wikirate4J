package org.wikirate4j.entitities;

import java.util.List;

/**
 * In WikiRate, a Company represents any formal reporting organization,
 * including corporations, NGOs, universities, and similar entities.
 * The {@link Company} entity extends the notion of a {@link Card}
 * by providing additional company-specific information and functionality.
 *
 * @author Vasiliki Gkatziaki
 */
public interface Company extends Card {

    /**
     * Returns the Wikipedia page name of the company, if available.
     *
     * @return the Wikipedia page name, or {@code null} if not available
     */
    String getWikipedia();

    /**
     * Returns the Legal Entity Identifier (LEI) of the company, if available.
     *
     * @return the Legal Entity Identifier
     */
    String getLegalEntityIdentifier();

    /**
     * Returns the UK Company Number, if available.
     *
     * @return the UK Company Number
     */
    String getUKCompanyNumber();

    /**
     * Returns the Australian Business Number (ABN), if available.
     *
     * @return the Australian Business Number
     */
    String getAustralianBusinessNumber();

    /**
     * Returns the Australian Company Number (ACN), if available.
     *
     * @return the Australian Company Number
     */
    String getAustralianCompanyNumber();

    /**
     * Returns the list of International Securities Identification Numbers (ISINs)
     * associated with the company.
     *
     * @return a list of ISINs, or an empty list if none exist
     */
    List<String> getISINs();

    /**
     * Returns the Wikidata identifier of the company, if available.
     *
     * @return the Wikidata identifier
     */
    String getWikidataID();

    /**
     * Returns the identifier of the company on OpenCorporates (opencorporates.com), if available.
     *
     * @return the OpenCorporates identifier
     */
    String getOpenCorporatesID();

    /**
     * Returns a list of alternative names (aliases) used by the company.
     *
     * @return a list of aliases, or an empty list if none exist
     */
    List<String> getAliases();

    /**
     * Returns the location of the company's headquarters, if available.
     *
     * @return the headquarters location
     */
    String getHeadquarters();

    /**
     * Returns the Open Supply Hub identifier of the company, if available.
     * See: https://opensupplyhub.org/
     *
     * @return the Open Supply Hub identifier
     */
    String getOpenSupplyHubId();

    /**
     * Returns the Central Index Key (CIK) of the company, as maintained by sec.gov, if available.
     *
     * @return the Central Index Key
     */
    String getCentralIndexKey();

    /**
     * Returns the URL for retrieving all answers associated with this company.
     *
     * @return the answers URL
     */
    String getAnswersUrl();
}
