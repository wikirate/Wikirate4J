package org.wikirate4j.utils.queries;

import org.apache.hc.core5.http.NameValuePair;
import org.wikirate4j.utils.SortBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class used to build a basic Query over the Wikirate API
 *
 * @author Vasiliki Gkatziaki
 */
public class Query<T extends Query> {
    protected HashMap<String, String> queryParams;

    protected List<NameValuePair> filters;

    public Query() {
        this.queryParams = new HashMap<>();
        this.filters = new ArrayList<>();
    }

    /**
     * Returns the Query Params
     * @return a HashMap containing the query parameters of the queru
     */
    public HashMap<String, String> getQueryParams() {
        return queryParams;
    }

    /**
     * Returns the Query Filters
     * @return a list containing the filters of the query
     */
    public List<NameValuePair> getFilters() {
        return filters;
    }

    public T offset(long offset) {
        this.queryParams.put("offset", String.valueOf(offset));
        return (T) this;
    }

    public T limit(int limit) {
        if (limit > 100)
            this.queryParams.put("limit", String.valueOf(100));
        else
            this.queryParams.put("limit", String.valueOf(limit));
        return (T) this;
    }

    public T sort_by(SortBy sort_by) {
        this.queryParams.put("sort_by", sort_by.value());
        return (T) this;
    }


}
