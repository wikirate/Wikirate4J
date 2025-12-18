package org.wikirate4j.entitities;

import org.json.JSONObject;

import java.util.List;

/**
 * @author Vasiliki Gkatziaki
 */
public class CompanyImpl extends CardImpl implements Company {

    String wikipedia;

    String open_corporates_id;

    String os_id;

    String sec_cik;

    String uk_company_number;

    String ABN;

    String ACN;

    List<String> ISINs;

    String LEI;

    String wikidata_id;

    String headquarters;

    List<String> aliases;

    String answers_url;

    private CompanyImpl(Builder builder) {
        super(builder);
        this.headquarters = builder.headquarters;
        this.aliases = builder.aliases;
        this.wikipedia = builder.wikipedia;
        this.open_corporates_id = builder.open_corporates_id;
        this.os_id = builder.os_id;
        this.sec_cik = builder.sec_cik;
        this.uk_company_number = builder.uk_company_number;
        this.ABN = builder.ABN;
        this.ACN = builder.ACN;
        this.LEI = builder.LEI;
        this.wikidata_id = builder.wikidata_id;
        this.ISINs = builder.ISINs;
        this.answers_url = builder.answers_url;
    }

    @Override
    public String getWikipedia() {
        return this.wikipedia;
    }

    @Override
    public String getLegalEntityIdentifier() {
        return this.LEI;
    }

    @Override
    public String getUKCompanyNumber() {
        return this.uk_company_number;
    }

    @Override
    public String getAustralianBusinessNumber() {
        return this.ABN;
    }

    @Override
    public String getAustralianCompanyNumber() {
        return this.ACN;
    }

    @Override
    public List<String> getISINs() {
        return this.ISINs;
    }

    @Override
    public String getWikidataID() {
        return this.wikidata_id;
    }

    @Override
    public String getOpenCorporatesID() {
        return this.open_corporates_id;
    }

    @Override
    public List<String> getAliases() {
        return this.aliases;
    }

    @Override
    public String getHeadquarters() {
        return this.headquarters;
    }

    @Override
    public String getOpenSupplyHubId() {
        return this.os_id;
    }

    @Override
    public String getCentralIndexKey() {
        return this.sec_cik;
    }

    @Override
    public String getAnswersUrl() {
        return answers_url;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject(this);
        json.remove("rawJson");
        return json;
    }

    public static class Builder extends CardImpl.Builder<Builder> {

        private String wikipedia;
        private String open_corporates_id;
        private String os_id;
        private String sec_cik;
        private String uk_company_number;
        private String ABN;
        private String ACN;
        private List<String> ISINs;
        private String LEI;
        private String wikidata_id;
        private String headquarters;
        private List<String> aliases;
        private String answers_url;

        public Builder() {
            super();
        }

        public Builder headquarters(String headquarters) {
            this.headquarters = headquarters;
            return this;
        }

        public Builder os_id(String os_id) {
            this.os_id = os_id;
            return this;
        }

        public Builder open_corporates_id(String open_corporates) {
            this.open_corporates_id = open_corporates;
            return this;
        }

        public Builder uk_company_number(String uk_company_number) {
            this.uk_company_number = uk_company_number;
            return this;
        }

        public Builder australian_business_number(String australian_business_number) {
            this.ABN = australian_business_number;
            return this;
        }

        public Builder australian_company_number(String australian_company_number) {
            this.ACN = australian_company_number;
            return this;
        }

        public Builder isin(List<String> isin) {
            this.ISINs = isin;
            return this;
        }

        public Builder lei(String lei) {
            this.LEI = lei;
            return this;
        }

        public Builder wikidata_id(String wikidata_id) {
            this.wikidata_id = wikidata_id;
            return this;
        }

        public Builder wikipedia(String wikipedia) {
            this.wikipedia = wikipedia;
            return this;
        }

        public Builder sec_cik(String cik) {
            this.sec_cik = cik;
            return this;
        }

        public Builder aliases(List<String> aliases) {
            this.aliases = aliases;
            return this;
        }

        public Builder answers_url(String answers_url) {
            this.answers_url = answers_url;
            return this;
        }

        public Company build() {
            return new CompanyImpl(this);
        }
    }

    @Override
    public String toString() {
        return toJson().toString(4);
    }
}
