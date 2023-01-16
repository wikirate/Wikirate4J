package org.wikirate4j.utils.queries;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.wikirate4j.utils.ReportType;

import java.util.List;
/**
 * Class used to build a Source Query
 * @author Vasiliki Gkatziaki
 */
public class SourceQuery extends Query<SourceQuery> {


    private List<NameValuePair> filters;

    public SourceQuery() {
        super();
    }

    public SourceQuery title(String title) {
        super.filters.add(new BasicNameValuePair("filter[wikirate_title]", title));
        return this;
    }

    public SourceQuery topic(String topic) {
        super.filters.add(new BasicNameValuePair("filter[wikirate_topic][]", topic));
        return this;
    }

    public SourceQuery report_type(ReportType reportType) {
        super.filters.add(new BasicNameValuePair("filter[report_type]", reportType.value()));
        return this;
    }

    public SourceQuery link(String link) {
        super.filters.add(new BasicNameValuePair("filter[wikirate_link]", link));
        return this;
    }

    public SourceQuery year(int year) {
        super.filters.add(new BasicNameValuePair("filter[year][]", String.valueOf(year)));
        return this;
    }

    public SourceQuery year(String year) {
        super.filters.add(new BasicNameValuePair("filter[year]", year));
        return this;
    }

    public SourceQuery company_name(String company_name) {
        super.filters.add(new BasicNameValuePair("filter[company_name]", company_name));
        return this;
    }

}
