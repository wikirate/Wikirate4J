package org.wikirate4j.utils.queries;

import org.apache.http.message.BasicNameValuePair;
/**
 * Class used to build a Dataset Query
 * @author Vasiliki Gkatziaki
 */
public class DatasetQuery extends Query<DatasetQuery> {

    public DatasetQuery() {
        super();
    }


    public DatasetQuery name(String name) {
        super.filters.add(new BasicNameValuePair("filter[name]", name));
        return this;
    }

    public DatasetQuery topic(String topic) {
        super.filters.add(new BasicNameValuePair("filter[wikirate_topic][]", topic));
        return this;
    }

    public DatasetQuery only_bookmarked(boolean only_bookmarked) {
        if (only_bookmarked)
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "bookmark"));
        else
            super.filters.add(new BasicNameValuePair("filter[bookmark]", "nobookmark"));
        return this;
    }

}
