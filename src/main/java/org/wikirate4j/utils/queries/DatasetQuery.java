package org.wikirate4j.utils.queries;

import org.apache.http.message.BasicNameValuePair;
import org.wikirate4j.utils.LicenseType;
import org.wikirate4j.utils.WikirateTopic;

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

    public DatasetQuery topic(WikirateTopic topic) {
        super.filters.add(new BasicNameValuePair("filter[topic][]", topic.value()));
        return this;
    }

    public DatasetQuery license(LicenseType license) {
        super.filters.add(new BasicNameValuePair("filter[license][]", license.value()));
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
