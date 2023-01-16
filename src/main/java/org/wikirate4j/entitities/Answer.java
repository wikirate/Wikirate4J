package org.wikirate4j.entitities;

import java.util.List;
/**
 * Answer
 * @author Vasiliki Gkatziaki
 */
public interface Answer extends Card {

    String getMetricName();

    String getMetricDesigner();

    String getCompany();

    Integer getYear();

    <T> T getValue(Class<T> classType);

    String getValue();

    String getRecordURL();

    List<Source> getSources();

    CheckedBy getCheckedBy();

    String getComments();
}
