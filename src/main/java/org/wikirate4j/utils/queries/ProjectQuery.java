package org.wikirate4j.utils.queries;

import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.wikirate4j.utils.ProjectStatus;

/**
 * Class used to build a Project Query
 * @author Vasiliki Gkatziaki
 */
public class ProjectQuery extends Query<ProjectQuery> {


    public ProjectQuery() {
        super();
    }

    public ProjectQuery name(String name) {
        this.filters.add(new BasicNameValuePair("filter[name]", name));
        return this;
    }

    public ProjectQuery status(ProjectStatus project_status) {
        this.filters.add(new BasicNameValuePair("filter[wikirate_status]", project_status.value()));
        return this;
    }
}
