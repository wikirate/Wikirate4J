package org.wikirate4j.utils.queries;

import org.apache.http.message.BasicNameValuePair;
import org.wikirate4j.utils.CompanyCategory;
import org.wikirate4j.utils.Country;
/**
 * Class used to build a Company Query
 * @author Vasiliki Gkatziaki
 */
public class CompanyQuery extends Query<CompanyQuery> {

    public CompanyQuery() {
        super();
    }


    public CompanyQuery name(String name) {
        super.filters.add(new BasicNameValuePair("filter[name]", name));
        return this;
    }

    public CompanyQuery company_category(CompanyCategory companyCategory) {
        super.filters.add(new BasicNameValuePair("filter[company_category][]", companyCategory.value()));
        return this;
    }

    public CompanyQuery company_group(String company_group) {
        super.filters.add(new BasicNameValuePair("filter[company_group][]", company_group));
        return this;
    }

    public CompanyQuery country(Country country) {
        super.filters.add(new BasicNameValuePair("filter[country][]", country.value()));
        return this;
    }
}
