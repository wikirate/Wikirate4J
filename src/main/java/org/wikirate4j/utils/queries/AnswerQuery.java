package org.wikirate4j.utils.queries;

import org.apache.http.message.BasicNameValuePair;
import org.wikirate4j.utils.*;

/**
 * Class used to build an Answer Query
 *
 * @author Vasiliki Gkatziaki
 */
public class AnswerQuery extends Query<AnswerQuery> {

    public AnswerQuery() {
        super();
    }

    public AnswerQuery company(String name) {
        super.filters.add(new BasicNameValuePair("filter[company]", name));
        return this;
    }

    public AnswerQuery company(long id) {
        super.filters.add(new BasicNameValuePair("filter[company][]", "~"+String.valueOf(id)));
        return this;
    }

    public AnswerQuery company_category(CompanyCategory companyCategory) {
        super.filters.add(new BasicNameValuePair("filter[company_category][]", companyCategory.value()));
        return this;
    }

    public AnswerQuery company_group(String company_group) {
        super.filters.add(new BasicNameValuePair("filter[company_group][]", company_group));
        return this;
    }

    public AnswerQuery country(Country country) {
        super.filters.add(new BasicNameValuePair("filter[country][]", country.value()));
        return this;
    }

    public AnswerQuery metric_keyword(String name) {
        super.filters.add(new BasicNameValuePair("filter[metric_keyword]", name));
        return this;
    }

    public AnswerQuery metric(long id) {
        super.filters.add(new BasicNameValuePair("filter[metric][]", "~"+String.valueOf(id)));
        return this;
    }

    public AnswerQuery benchmark(boolean isBenchmark){
        if (isBenchmark)
            super.filters.add(new BasicNameValuePair("filter[benchmark]", "1"));
        else
            super.filters.add(new BasicNameValuePair("filter[benchmark]", "0"));
        return this;
    }

    public AnswerQuery only_bookmarked(boolean only_bookmarked) {
        if (only_bookmarked)
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "bookmark"));
        else
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "nobookmark"));
        return this;
    }

    public AnswerQuery topic(WikirateTopic topic) {
        super.filters.add(new BasicNameValuePair("filter[topic][]", topic.value()));
        return this;
    }

    public AnswerQuery topic_framework(TopicFramework topic_framework) {
        super.filters.add(new BasicNameValuePair("filter[topic_framework][]", topic_framework.value()));
        return this;
    }

    public AnswerQuery designer(String designer) {
        super.filters.add(new BasicNameValuePair("filter[designer][]", designer));
        return this;
    }

    public AnswerQuery metric_type(MetricType metric_type) {
        super.filters.add(new BasicNameValuePair("filter[metric_type][]", metric_type.value()));
        return this;
    }

    public AnswerQuery value_type(ValueType value_type) {
        super.filters.add(new BasicNameValuePair("filter[value_type][]", value_type.value()));
        return this;
    }

    public AnswerQuery assessment_type(AssessmentType assessment_type) {
        super.filters.add(new BasicNameValuePair("filter[assessment]", assessment_type.value()));
        return this;
    }

    public AnswerQuery dataset(String dataset) {
        super.filters.add(new BasicNameValuePair("filter[dataset][]", dataset));
        return this;
    }

    public AnswerQuery value(String value) {
        super.filters.add(new BasicNameValuePair("filter[value][]", value));
        return this;
    }

    public AnswerQuery value(int value) {
        super.filters.add(new BasicNameValuePair("filter[value][]", String.valueOf(value)));
        return this;
    }

    public AnswerQuery value(double value) {
        super.filters.add(new BasicNameValuePair("filter[value][]", String.valueOf(value)));
        return this;
    }

    public AnswerQuery value_from(Number from) {
        super.filters.add(new BasicNameValuePair("filter[value][from]", String.valueOf(from)));
        return this;
    }

    public AnswerQuery value_to(Number to) {
        super.filters.add(new BasicNameValuePair("filter[value][to]", String.valueOf(to)));
        return this;
    }

    public AnswerQuery verification_status(VerificationStatus verificationStatus) {
        super.filters.add(new BasicNameValuePair("filter[verification]", String.valueOf(verificationStatus.value())));
        return this;
    }

    public AnswerQuery calculated(boolean isCalculated) {
        if (isCalculated)
            super.filters.add(new BasicNameValuePair("filter[calculated]", "calculated"));
        else
            super.filters.add(new BasicNameValuePair("filter[calculated]", "not_calculated"));
        return this;
    }

    public AnswerQuery license(LicenseType license) {
        super.filters.add(new BasicNameValuePair("filter[license][]", license.value()));
        return this;
    }

    public AnswerQuery status(AnswerStatus status) {
        super.filters.add(new BasicNameValuePair("filter[status]", String.valueOf(status.value())));
        return this;
    }

    public AnswerQuery updated(Updated updated) {
        super.filters.add(new BasicNameValuePair("filter[updated]", String.valueOf(updated.value())));
        return this;
    }

    public AnswerQuery updater(Updater updater) {
        super.filters.add(new BasicNameValuePair("filter[updater]", String.valueOf(updater.value())));
        return this;
    }

    public AnswerQuery source(String source) {
        super.filters.add(new BasicNameValuePair("filter[source][]", String.valueOf(source)));
        return this;
    }

    public AnswerQuery publication_status(PublicationStatus publicationStatus) {
        super.filters.add(new BasicNameValuePair("filter[published]", publicationStatus.value()));
        return this;
    }

    public AnswerQuery year(int year) {
        super.filters.add(new BasicNameValuePair("filter[year][]", String.valueOf(year)));
        return this;
    }

    public AnswerQuery year(String year) {
        super.filters.add(new BasicNameValuePair("filter[year]", year));
        return this;
    }
}
