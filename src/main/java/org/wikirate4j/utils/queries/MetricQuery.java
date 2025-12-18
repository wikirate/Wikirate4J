package org.wikirate4j.utils.queries;

import org.apache.http.message.BasicNameValuePair;
import org.wikirate4j.utils.*;

/**
 * Class used to build a Metric Query
 * @author Vasiliki Gkatziaki
 */
public class MetricQuery extends Query<MetricQuery> {

    public MetricQuery() {
        super();
    }

    public MetricQuery metric_keyword(String name) {
        super.filters.add(new BasicNameValuePair("filter[metric_keyword]", name));
        return this;
    }

    public MetricQuery metric(long id) {
        super.filters.add(new BasicNameValuePair("filter[metric][]", "~"+String.valueOf(id)));
        return this;
    }

    public MetricQuery benchmark(boolean isBenchmark){
        if (isBenchmark)
            super.filters.add(new BasicNameValuePair("filter[benchmark]", "1"));
        else
            super.filters.add(new BasicNameValuePair("filter[benchmark]", "0"));
        return this;
    }

    public MetricQuery only_bookmarked(boolean only_bookmarked) {
        if (only_bookmarked)
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "bookmark"));
        else
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "nobookmark"));
        return this;
    }

    public MetricQuery topic(WikirateTopic topic) {
        super.filters.add(new BasicNameValuePair("filter[topic][]", topic.value()));
        return this;
    }

    public MetricQuery topic_framework(TopicFramework topic_framework) {
        super.filters.add(new BasicNameValuePair("filter[topic_framework][]", topic_framework.value()));
        return this;
    }

    public MetricQuery topic_framework(String topic_framework) {
        super.filters.add(new BasicNameValuePair("filter[topic_framework][]", topic_framework));
        return this;
    }

    public MetricQuery designer(String designer) {
        super.filters.add(new BasicNameValuePair("filter[designer][]", designer));
        return this;
    }

    public MetricQuery metric_type(MetricType metric_type) {
        super.filters.add(new BasicNameValuePair("filter[metric_type][]", metric_type.value()));
        return this;
    }

    public MetricQuery value_type(ValueType value_type) {
        super.filters.add(new BasicNameValuePair("filter[value_type][]", value_type.value()));
        return this;
    }

    public MetricQuery assessment_type(AssessmentType assessment_type) {
        super.filters.add(new BasicNameValuePair("filter[assessment]", assessment_type.value()));
        return this;
    }

    public MetricQuery license(LicenseType license) {
        super.filters.add(new BasicNameValuePair("filter[license][]", license.value()));
        return this;
    }

    public MetricQuery dataset(String dataset) {
        super.filters.add(new BasicNameValuePair("filter[dataset][]", dataset));
        return this;
    }
}
