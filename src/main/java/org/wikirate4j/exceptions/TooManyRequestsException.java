package org.wikirate4j.exceptions;
/**
 * @author Vasiliki Gkatziaki
 */
public class TooManyRequestsException extends HTTPException {
    public TooManyRequestsException(String message) {
        super(message);
    }
}
