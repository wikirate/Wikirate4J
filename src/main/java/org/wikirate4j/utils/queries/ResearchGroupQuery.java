package org.wikirate4j.utils.queries;

import org.apache.http.message.BasicNameValuePair;
import org.wikirate4j.utils.WikirateTopic;

/**
 * Class used to build a Research Group Query
 * @author Vasiliki Gkatziaki
 */
public class ResearchGroupQuery extends Query<ResearchGroupQuery> {

    public ResearchGroupQuery() {
        super();
    }


    public ResearchGroupQuery name(String name) {
        super.filters.add(new BasicNameValuePair("filter[name]", name));
        return this;
    }

    public ResearchGroupQuery topic(WikirateTopic topic) {
        super.filters.add(new BasicNameValuePair("filter[topic][]", topic.value()));
        return this;
    }

    public ResearchGroupQuery only_bookmarked(boolean only_bookmarked) {
        if (only_bookmarked)
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "bookmark"));
        else
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "nobookmark"));
        return this;
    }
}
