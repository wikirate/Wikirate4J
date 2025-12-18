package org.wikirate4j.utils.queries;

import org.apache.http.message.BasicNameValuePair;
import org.wikirate4j.utils.WikirateTopic;

/**
 * Class used to build a Company Group Query
 * @author Vasiliki Gkatziaki
 */
public class CompanyGroupQuery extends Query<CompanyGroupQuery> {
    public CompanyGroupQuery() {
        super();
    }


    public CompanyGroupQuery name(String name) {
        super.filters.add(new BasicNameValuePair("filter[name]", name));
        return this;
    }

    public CompanyGroupQuery topic(WikirateTopic topic) {
        super.filters.add(new BasicNameValuePair("filter[topic][]", topic.value()));
        return this;
    }

    public CompanyGroupQuery only_bookmarked(boolean only_bookmarked) {
        if (only_bookmarked)
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "bookmark"));
        else
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "nobookmark"));
        return this;
    }
}
