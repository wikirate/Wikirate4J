package org.wikirate4j.exceptions;
/**
 * @author Vasiliki Gkatziaki
 */
public class ForbiddenException extends HTTPException {
    public ForbiddenException(String message) {
        super(message);
    }
}
