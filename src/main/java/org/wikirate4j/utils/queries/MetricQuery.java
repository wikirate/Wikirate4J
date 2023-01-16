package org.wikirate4j.utils.queries;

import org.apache.http.message.BasicNameValuePair;
import org.wikirate4j.utils.MetricType;
import org.wikirate4j.utils.ResearchPolicy;
import org.wikirate4j.utils.ValueType;

/**
 * Class used to build a Metric Query
 * @author Vasiliki Gkatziaki
 */
public class MetricQuery extends Query<MetricQuery> {

    public MetricQuery() {
        super();
    }

    public MetricQuery name(String name) {
        super.filters.add(new BasicNameValuePair("filter[name]", name));
        return this;
    }

    public MetricQuery only_bookmarked(boolean only_bookmarked) {
        if (only_bookmarked)
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "bookmark"));
        else
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "nobookmark"));
        return this;
    }

    public MetricQuery topic(String topic) {
        super.filters.add(new BasicNameValuePair("filter[wikirate_topic][]", topic));
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

    public MetricQuery research_policy(ResearchPolicy research_policy) {
        super.filters.add(new BasicNameValuePair("filter[research_policy]", research_policy.value()));
        return this;
    }

    public MetricQuery dataset(String dataset) {
        super.filters.add(new BasicNameValuePair("filter[dataset][]", dataset));
        return this;
    }
}
