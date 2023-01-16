package org.wikirate4j.exceptions;
/**
 * @author Vasiliki Gkatziaki
 */
public class NotFoundException extends HTTPException {
    public NotFoundException(String message) {
        super(message);
    }
}
