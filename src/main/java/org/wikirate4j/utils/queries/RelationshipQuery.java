package org.wikirate4j.utils.queries;

import org.apache.http.message.BasicNameValuePair;
import org.wikirate4j.utils.*;
/**
 * Class used to build a Relationship Answer Query
 * @author Vasiliki Gkatziaki
 */
public class RelationshipQuery extends Query<RelationshipQuery> {

    String metric_name;
    String metric_designer;
    Long metric_id;

    public RelationshipQuery() {
        super();
    }

    public RelationshipQuery(String metric_name, String metric_designer) {
        super();
        this.metric_name = metric_name;
        this.metric_designer = metric_designer;
    }

    public RelationshipQuery(long metric_id) {
        super();
        this.metric_id = metric_id;
    }

    public RelationshipQuery subject_company_name(String name) {
        super.filters.add(new BasicNameValuePair("filter[subject_company_name]", name));
        return this;
    }

    public RelationshipQuery object_company_name(String name) {
        super.filters.add(new BasicNameValuePair("filter[object_company_name]", name));
        return this;
    }

    public RelationshipQuery subject_company_id(long subject_company_id) {
        super.filters.add(new BasicNameValuePair("filter[subject_company_id]", String.valueOf(subject_company_id)));
        return this;
    }

    public RelationshipQuery object_company_id(long object_company_id) {
        super.filters.add(new BasicNameValuePair("filter[object_company_id]", String.valueOf(object_company_id)));
        return this;
    }

    public RelationshipQuery value(String value) {
        super.filters.add(new BasicNameValuePair("filter[value]", value));
        return this;
    }

    public RelationshipQuery dataset(String dataset) {
        super.filters.add(new BasicNameValuePair("filter[dataset][]", dataset));
        return this;
    }

    public RelationshipQuery verification_status(VerificationStatus verificationStatus) {
        super.filters.add(new BasicNameValuePair("filter[verification]", String.valueOf(verificationStatus.value())));
        return this;
    }

    public RelationshipQuery status(AnswerStatus status) {
        super.filters.add(new BasicNameValuePair("filter[status]", String.valueOf(status.value())));
        return this;
    }

    public RelationshipQuery updated(Updated updated) {
        super.filters.add(new BasicNameValuePair("filter[updated]", String.valueOf(updated.value())));
        return this;
    }

    public RelationshipQuery updater(Updater updater) {
        super.filters.add(new BasicNameValuePair("filter[updater]", String.valueOf(updater.value())));
        return this;
    }

    public RelationshipQuery source(String source) {
        super.filters.add(new BasicNameValuePair("filter[source]", String.valueOf(source)));
        return this;
    }

    public RelationshipQuery publication_status(PublicationStatus publicationStatus) {
        super.filters.add(new BasicNameValuePair("filter[published]", publicationStatus.value()));
        return this;
    }

    public RelationshipQuery year(int year) {
        super.filters.add(new BasicNameValuePair("filter[year][]", String.valueOf(year)));
        return this;
    }

    public RelationshipQuery year(String year) {
        super.filters.add(new BasicNameValuePair("filter[year]", year));
        return this;
    }

    public String getMetricName() {
        return this.metric_name;
    }

    public String getMetricDesigner() {
        return this.metric_designer;
    }

    public Long getMetricId() {
        return this.metric_id;
    }
}
