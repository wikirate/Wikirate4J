package org.wikirate4j.entitities;

import java.util.List;
/**
 * @author Vasiliki Gkatziaki
 */
public interface RelationshipAnswer extends Card {

    Long getMetricId();

    Long getInverseMetricId();

    Long getSubjectCompanyId();

    Long getObjectCompanyId();

    String getSubjectCompany();

    String getObjectCompany();


    Integer getYear();

    <T> T getValue(Class<T> classType);

    String getValue();

    String getRecordURL();

    List<Source> getSources();

    CheckedBy getCheckedBy();

    String getComments();
}
