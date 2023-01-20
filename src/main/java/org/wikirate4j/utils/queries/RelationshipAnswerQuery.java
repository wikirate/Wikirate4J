package org.wikirate4j.utils.queries;

import org.apache.http.message.BasicNameValuePair;
import org.wikirate4j.utils.*;
/**
 * Class used to build a Relationship Answer Query
 * @author Vasiliki Gkatziaki
 */
public class RelationshipAnswerQuery extends Query<RelationshipAnswerQuery> {

    String metric_name;
    String metric_designer;
    Long metric_id;

    public RelationshipAnswerQuery(String metric_name, String metric_designer) {
        super();
        this.metric_name = metric_name;
        this.metric_designer = metric_designer;
    }

    public RelationshipAnswerQuery(long metric_id) {
        super();
        this.metric_id = metric_id;
    }

    public RelationshipAnswerQuery subject_company(String name) {
        super.filters.add(new BasicNameValuePair("filter[name]", name));
        return this;
    }

    public RelationshipAnswerQuery company_category(CompanyCategory companyCategory) {
        super.filters.add(new BasicNameValuePair("filter[company_category][]", companyCategory.value()));
        return this;
    }

    public RelationshipAnswerQuery company_group(String company_group) {
        super.filters.add(new BasicNameValuePair("filter[company_group][]", company_group));
        return this;
    }

    public RelationshipAnswerQuery dataset(String dataset) {
        super.filters.add(new BasicNameValuePair("filter[dataset][]", dataset));
        return this;
    }

    public RelationshipAnswerQuery verification_status(VerificationStatus verificationStatus) {
        super.filters.add(new BasicNameValuePair("filter[verification]", String.valueOf(verificationStatus.value())));
        return this;
    }

    public RelationshipAnswerQuery status(AnswerStatus status) {
        super.filters.add(new BasicNameValuePair("filter[status]", String.valueOf(status.value())));
        return this;
    }

    public RelationshipAnswerQuery updated(Updated updated) {
        super.filters.add(new BasicNameValuePair("filter[updated]", String.valueOf(updated.value())));
        return this;
    }

    public RelationshipAnswerQuery updater(Updater updater) {
        super.filters.add(new BasicNameValuePair("filter[updater]", String.valueOf(updater.value())));
        return this;
    }

    public RelationshipAnswerQuery source(String source) {
        super.filters.add(new BasicNameValuePair("filter[source]", String.valueOf(source)));
        return this;
    }

    public RelationshipAnswerQuery publication_status(PublicationStatus publicationStatus) {
        super.filters.add(new BasicNameValuePair("filter[published]", publicationStatus.value()));
        return this;
    }

    public RelationshipAnswerQuery year(int year) {
        super.filters.add(new BasicNameValuePair("filter[year][]", String.valueOf(year)));
        return this;
    }

    public RelationshipAnswerQuery year(String year) {
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
