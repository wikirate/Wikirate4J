package org.wikirate4j.entitities;
/**
 * @author Vasiliki Gkatziaki
 */
public interface CheckedBy<T> extends Card<T> {

    Integer getChecks();
}
