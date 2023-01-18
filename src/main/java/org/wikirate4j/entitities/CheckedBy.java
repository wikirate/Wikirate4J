package org.wikirate4j.entitities;

/**
 * Users are able to flag an answer to request a check in case they have doubts that the answer is correct.
 * The CheckedBy entity extends the notion of a {@link Card} to provide additional information and functionality.
 *
 * @author Vasiliki Gkatziaki
 */
public interface CheckedBy<T> extends Card<T> {

    /**
     * Returns the number of checks, they have been performed on the mentioned answer
     *
     * @return the nuber of checks
     */
    Integer getChecks();
}
