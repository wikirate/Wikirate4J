package org.wikirate4j.utils.queries;

import org.apache.http.message.BasicNameValuePair;
/**
 * Class used to build a Company Group Query
 * @author Vasiliki Gkatziaki
 */
public class CompanyGroupQuery extends Query<CompanyGroupQuery> {
    private CompanyGroupQuery() {
        super();
    }


    public CompanyGroupQuery name(String name) {
        super.filters.add(new BasicNameValuePair("filter[name]", name));
        return this;
    }

    public CompanyGroupQuery topic(String topic) {
        super.filters.add(new BasicNameValuePair("filter[wikirate_topic][]", topic));
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
