package org.wikirate4j.entitities;

import org.json.JSONObject;

import java.util.List;
/**
 * @author Vasiliki Gkatziaki
 */
public class CompanyGroupImpl extends CardImpl implements CompanyGroup {

    List<String> companies;

    List<String> linksOfCompanies;

    String specification;

    protected CompanyGroupImpl(Builder builder) {
        super(builder);
        this.companies = builder.companies;
        this.linksOfCompanies = builder.linksOfCompanies;
        this.specification = builder.specification;
    }

    @Override
    public List<String> getCompanies() {
        return this.companies;
    }

    @Override
    public List<String> getLinksOfCompanies() {
        return this.linksOfCompanies;
    }

    @Override
    public String getSpecification() {
        return this.specification;
    }


    public static final class Builder extends CardImpl.Builder<Builder> {
        private List<String> companies;
        private List<String> linksOfCompanies;
        private String specification;

        public Builder() {
        }

        public Builder companies(List<String> companies) {
            this.companies = companies;
            return this;
        }

        public Builder links(List<String> linksOfCompanies) {
            this.linksOfCompanies = linksOfCompanies;
            return this;
        }

        public Builder specification(String specification) {
            this.specification = specification;
            return this;
        }

        public CompanyGroup build() {
            return new CompanyGroupImpl(this);
        }
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject(this);
        json.remove("rawJson");
        return json;
    }

    @Override
    public String toString() {
        return toJson().toString(4);
    }
}
