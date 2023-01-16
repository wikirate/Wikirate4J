package org.wikirate4j.exceptions;
/**
 * @author Vasiliki Gkatziaki
 */
public class UnauthorizedException extends HTTPException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
