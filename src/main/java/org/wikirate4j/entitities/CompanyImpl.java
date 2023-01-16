package org.wikirate4j.entitities;

import org.json.JSONObject;

import java.util.List;
/**
 * @author Vasiliki Gkatziaki
 */
public class CompanyImpl extends CardImpl implements Company {

    String wikipedia;

    String open_corporates;

    String os_id;

    String cik;

    String headquarters;

    List<String> aliases;

    String answers_url;

    private CompanyImpl(Builder builder) {
        super(builder);
        this.headquarters = builder.headquarters;
        this.aliases = builder.aliases;
        this.wikipedia = builder.wikipedia;
        this.open_corporates = builder.open_corporates;
        this.os_id = builder.os_id;
        this.cik = builder.cik;
        this.answers_url = builder.answers_url;
    }

    @Override
    public String getWikipedia() {
        return this.wikipedia;
    }

    @Override
    public String getOpenCorporates() {
        return this.open_corporates;
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
    public String getCIK() {
        return this.cik;
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

        String wikipedia;

        String open_corporates;

        String os_id;
        String cik;

        String headquarters;

        List<String> aliases;

        String answers_url;

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

        public Builder open_corporates(String open_corporates) {
            this.open_corporates = open_corporates;
            return this;
        }

        public Builder wikipedia(String wikipedia) {
            this.wikipedia = wikipedia;
            return this;
        }

        public Builder cik(String cik) {
            this.cik = cik;
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
