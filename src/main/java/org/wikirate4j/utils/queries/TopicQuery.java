package org.wikirate4j.utils.queries;

import org.apache.http.message.BasicNameValuePair;
import org.wikirate4j.utils.TopicFramework;

/**
 * Class used to build a Topic Query
 * @author Vasiliki Gkatziaki
 */
public class TopicQuery extends Query<TopicQuery> {

    public TopicQuery() {
        super();
    }

    public TopicQuery name(String name) {
        super.filters.add(new BasicNameValuePair("filter[name]", name));
        return this;
    }

    public TopicQuery topic_framework(TopicFramework topicFramework) {
        super.filters.add(new BasicNameValuePair("filter[topic_framework][]", topicFramework.value()));
        return this;
    }

    public TopicQuery only_bookmarked(boolean only_bookmarked) {
        if (only_bookmarked)
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "bookmark"));
        else
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "nobookmark"));
        return this;
    }
}
