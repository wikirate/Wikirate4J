package org.wikirate4j.exceptions;
/**
 * @author Vasiliki Gkatziaki
 */
public class WikiRateServerErrorException extends HTTPException {
    public WikiRateServerErrorException(String message) {
        super(message);
    }
}
