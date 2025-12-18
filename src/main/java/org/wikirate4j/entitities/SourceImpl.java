package org.wikirate4j.entitities;

import org.json.JSONObject;
import org.wikirate4j.utils.ReportType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasiliki Gkatziaki
 */
public class SourceImpl extends CardImpl implements Source {

    String title;

    String file;

    String link;

    List<ReportType> reportTypes;

    List<Integer> years;

    String description;

    List<String> companies;

    List<String> metrics;

    List<String> answers;

    protected SourceImpl(Builder builder) {
        super(builder);
        this.title = builder.title;
        this.file = builder.file;
        this.link = builder.link;
        this.years = builder.years;
        this.reportTypes = builder.reportTypes;
        this.companies = builder.companies;
        this.description = builder.description;
        this.metrics = builder.metrics;
        this.answers = builder.answers;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getFile() {
        return this.file;
    }

    @Override
    public String getLink() {
        return this.link;
    }

    @Override
    public List<ReportType> getReportTypes() {
        return this.reportTypes;
    }

    @Override
    public List<Integer> getYears() {
        return this.years;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public List<String> getCompanies() {
        return this.companies;
    }

    @Override
    public List<String> getMetrics() {
        return this.metrics;
    }

    @Override
    public List<String> getAnswers() {
        return this.answers;
    }

    @Override
    public String asReference() { return this.name; }


    public static final class Builder extends CardImpl.Builder<Builder> {
        private String title;
        private String file;
        private String link;
        private List<ReportType> reportTypes;
        private List<Integer> years;
        private String description;
        private List<String> companies;
        private List<String> metrics;
        private List<String> answers;

        public Builder() {
            super();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder file(String file) {
            this.file = file;
            return this;
        }

        public Builder link(String link) {
            this.link = link;
            return this;
        }

        public Builder reportTypes(List<String> reportTypes) {
            if (reportTypes == null) return this;
            this.reportTypes = new ArrayList<>();
            for (String reportType : reportTypes) {
                this.reportTypes.add(ReportType.getReportType(reportType));
            }
            return this;
        }

        public Builder years(List<Integer> years) {
            this.years = years;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder companies(List<String> companies) {
            this.companies = companies;
            return this;
        }

        public Builder metrics(List<String> metrics) {
            this.metrics = metrics;
            return this;
        }

        public Builder answers(List<String> answers) {
            this.answers = answers;
            return this;
        }

        public Source build() {
            return new SourceImpl(this);
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
