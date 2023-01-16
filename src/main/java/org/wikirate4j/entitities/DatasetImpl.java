package org.wikirate4j.entitities;

import org.json.JSONObject;

import java.util.List;
/**
 * @author Vasiliki Gkatziaki
 */
public class DatasetImpl extends CardImpl implements Dataset {

    List<Answer> answers;

    List<String> metrics;

    List<String> companies;

    String license;

    protected DatasetImpl(Builder builder) {
        super(builder);
        this.answers = builder.answers;
        this.companies = builder.companies;
        this.metrics = builder.metrics;
        this.license = builder.license;
    }

    @Override
    public List<Answer> getAnswers() {
        return this.answers;
    }

    @Override
    public List<String> getMetrics() {
        return this.metrics;
    }

    @Override
    public List<String> getCompanies() {
        return this.companies;
    }

    @Override
    public String getLicense() {
        return this.license;
    }

    public static class Builder extends CardImpl.Builder<Builder> {
        private List<Answer> answers;
        private List<String> metrics;
        private List<String> companies;
        private String license;

        public Builder() {
            super();
        }

        public Builder answers(List<Answer> answers) {
            this.answers = answers;
            return this;
        }

        public Builder metrics(List<String> metrics) {
            this.metrics = metrics;
            return this;
        }

        public Builder companies(List<String> companies) {
            this.companies = companies;
            return this;
        }

        public Builder license(String license) {
            this.license = license;
            return this;
        }

        public Dataset build() {
            return new DatasetImpl(this);
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
