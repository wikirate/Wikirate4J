package org.wikirate4j.utils.queries;

import org.apache.http.message.BasicNameValuePair;

/**
 * Class used to build a Topic Query
 * @author Vasiliki Gkatziaki
 */
public class TopicQuery extends Query<TopicQuery> {

    public TopicQuery() {
        super();
    }

    public Query name(String name) {
        super.filters.add(new BasicNameValuePair("filter[name]", name));
        return this;
    }

    public Query only_bookmarked(boolean only_bookmarked) {
        if (only_bookmarked)
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "bookmark"));
        else
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "nobookmark"));
        return this;
    }
}
