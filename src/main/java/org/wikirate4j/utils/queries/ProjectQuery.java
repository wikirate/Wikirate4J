package org.wikirate4j.utils.queries;

import org.apache.http.message.BasicNameValuePair;

/**
 * Class used to build a Project Query
 * @author Vasiliki Gkatziaki
 */
public class ProjectQuery extends Query<ProjectQuery> {


    private ProjectQuery() {
        super();
    }

    public ProjectQuery name(String name) {
        this.filters.add(new BasicNameValuePair("filter[name]", name));
        return this;
    }

    public ProjectQuery status(boolean only_bookmarked) {
        if (only_bookmarked)
            this.filters.add(new BasicNameValuePair("filter[bookmark]", "bookmark"));
        else
            this.filters.add(new BasicNameValuePair("filter[bookmark]", "nobookmark"));
        return this;
    }
}
