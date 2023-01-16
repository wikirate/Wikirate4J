package org.wikirate4j.entitities;

import org.json.JSONObject;

import java.util.Date;

/**
 * Cards are the building blocks of all decko sites. WikiRate is an extension project of decko and every element is a card.
 * Entities like Companies, Metrics, Answers, Company Groups etc. are essentially cards with additional features.
 * Every card consists of a unique identifier and a unique name, a code name, and it can or cannot have content.
 * The content of a certain card can be a specific type.
 *
 * @author Vasiliki Gkatziaki
 */
public interface Card<K> {

    /**
     *
     * @return the card's unique identifier
     */
    Long getId();

    /**
     *
     * @return the card's unique name
     */
    String getName();

    /**
     *
     * @param classType
     * @return the card's content given the type as input
     */
    Object getContent(Class<?> classType);

    /**
     *
     * @return the card's content
     */
    K getContent();

    /**
     *
     * @return the card's URL
     */
    String getURL();

    /**
     *
     * @return the card's html url
     */
    String getHtmlURL();

    /**
     *
     * @return the card's codename
     */
    String getCodename();

    /**
     *
     * @return the creation date of the card
     */
    Date getCreatedAt();

    /**
     *
     * @return the date the card was last updated
     */
    Date getUpdatedAt();

    /**
     *
     * @return the request date
     */
    Date getRequestedAt();

    /**
     *
     * @return the raw json of the card as returned by the request (if it was retrieved by a request, otherwise it is null)
     * Note: the raw_json is usually more verbose
     */
    JSONObject raw_json();

    /**
     *
     * @return the object as json
     */
    JSONObject toJson();
}
