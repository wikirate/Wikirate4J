package org.wikirate4j.entitities;

/**
 * The Region entity extends the notion of a {@link Card} to provide additional information and functionality.
 *
 * @author Vasiliki Gkatziaki
 */
public interface Region extends Card {

    /**
     * Each Region is described by a jurisdiction key
     *
     * @return the jurisdiction code
     */
    String getJurisdictionKey();

    /**
     * Each Region is described by the ILO Region is located
     *
     * @return the ILO region
     */
    String getILORegion();

    /**
     * Each Region is described by the country is located
     *
     * @return the country
     */
    String getCountry();

}
