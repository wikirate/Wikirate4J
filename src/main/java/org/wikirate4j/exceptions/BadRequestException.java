package org.wikirate4j.exceptions;
/**
 * @author Vasiliki Gkatziaki
 */
public class BadRequestException extends HTTPException {

    public BadRequestException(String message) {
        super(message);
    }
}
