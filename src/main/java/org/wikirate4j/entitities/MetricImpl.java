package org.wikirate4j.entitities;

import org.json.JSONObject;
import org.wikirate4j.utils.*;
import org.wikirate4j.utils.AssessmentType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasiliki Gkatziaki
 */
public class MetricImpl extends CardImpl implements Metric {

    String metricName;

    String metricDesigner;

    String question;

    MetricType metricType;

    String about;

    String methodology;

    ValueType valueType;

    List<String> valueOptions;

    ReportType reportType;

    AssessmentType assessmentType;

    String unit;

    String range;

    List<WikirateTopic> topics;

    List<String> topic_frameworks;

    List<String> variables;

    String formula;

    Integer numberOfAnswers;

    Integer numberOfCompanies;

    Integer numberOfDatasets;

    Integer numberOfBookmarkers;

    List<String> calculations;

    String codename;

    String answersURL;

    private MetricImpl(Builder builder) {
        super(builder);
        this.calculations = builder.calculations;
        this.answersURL = builder.answersURL;
        this.metricName = builder.metricName;
        this.valueType = builder.valueType;
        this.range = builder.range;
        this.variables = builder.variables;
        this.numberOfDatasets = builder.numberOfDatasets;
        this.valueOptions = builder.valueOptions;
        this.numberOfBookmarkers = builder.numberOfBookmarkers;
        this.numberOfAnswers = builder.numberOfAnswers;
        this.reportType = builder.reportType;
        this.unit = builder.unit;
        this.numberOfCompanies = builder.numberOfCompanies;
        this.topics = builder.topics;
        this.topic_frameworks = builder.topicFrameworks;
        this.about = builder.about;
        this.formula = builder.formula;
        this.methodology = builder.methodology;
        this.metricDesigner = builder.metricDesigner;
        this.assessmentType = builder.assessmentType;
        this.metricType = builder.metricType;
        this.question = builder.question;
    }

    @Override
    public JSONObject raw_json() {
        return this.rawJson;
    }

    @Override
    public String getMetricDesigner() {
        return this.metricDesigner;
    }

    @Override
    public String getMetricName() {
        return this.metricName;
    }

    @Override
    public MetricType getMetricType() {
        return this.metricType;
    }

    @Override
    public String getQuestion() {
        return this.question;
    }

    @Override
    public String getAbout() {
        return this.about;
    }

    @Override
    public String getMethodology() {
        return this.methodology;
    }

    @Override
    public ValueType getValueType() {
        return this.valueType;
    }

    @Override
    public List<String> getValueOptions() {
        return this.valueOptions;
    }

    @Override
    public ReportType getReportType() {
        return this.reportType;
    }

    @Override
    public AssessmentType getAssessmentType() {
        return this.assessmentType;
    }

    @Override
    public String getUnit() {
        return this.unit;
    }

    @Override
    public String getRange() {
        return this.range;
    }

    @Override
    public List<WikirateTopic> getTopics() {
        return this.topics;
    }

    @Override
    public List<String> getTopicFrameworks() {
        return this.topic_frameworks;
    }

    @Override
    public String getFormula() {
        return this.formula;
    }

    @Override
    public List<String> getVariables() {
        return this.variables;
    }

    @Override
    public Integer getNumberOfAnswers() {
        return this.numberOfAnswers;
    }

    @Override
    public Integer getNumberOfBookmarkers() {
        return this.numberOfBookmarkers;
    }

    @Override
    public Integer getNumberOfDatasets() {
        return this.numberOfDatasets;
    }

    @Override
    public Integer getNumberOfCompanies() {
        return this.numberOfCompanies;
    }

    @Override
    public List<String> getCalculations() {
        return this.calculations;
    }

    @Override
    public String getAnswersURL() {
        return this.answersURL;
    }


    public static class Builder extends CardImpl.Builder<Builder> {
        private String metricName;
        private String metricDesigner;
        private String question;
        private MetricType metricType;
        private String about;
        private String methodology;
        private ValueType valueType;
        private List<String> valueOptions;
        private ReportType reportType;
        private AssessmentType assessmentType;
        private String unit;
        private String range;
        private List<WikirateTopic> topics;
        private List<String> topicFrameworks;
        private List<String> variables;
        private String formula;
        private Integer numberOfAnswers;
        private Integer numberOfCompanies;
        private Integer numberOfDatasets;
        private Integer numberOfBookmarkers;
        private List<String> calculations;
        private String answersURL;

        public Builder() {
            super();
            this.dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        }

        public Builder metric_name(String metricName) {
            this.metricName = metricName;
            return this;
        }

        public Builder metric_designer(String metricDesigner) {
            this.metricDesigner = metricDesigner;
            return this;
        }

        public Builder question(String question) {
            this.question = question;
            return this;
        }

        public Builder metric_type(String metricType) {
            this.metricType = MetricType.getMetricType(metricType);
            return this;
        }

        public Builder about(String about) {
            this.about = about;
            return this;
        }

        public Builder methodology(String methodology) {
            this.methodology = methodology;
            return this;
        }

        public Builder value_type(String valueType) {
            this.valueType = ValueType.getValueType(valueType);
            return this;
        }

        public Builder value_options(List<String> valueOptions) {
            this.valueOptions = valueOptions;
            return this;
        }

        public Builder report_type(String reportType) {
            this.reportType = ReportType.getReportType(reportType);
            return this;
        }

        public Builder assessment_type(String assessmentType) {
            this.assessmentType = AssessmentType.getAssessmentType(assessmentType);
            return this;
        }

        public Builder unit(String unit) {
            this.unit = unit;
            return this;
        }

        public Builder range(String range) {
            this.range = range;
            return this;
        }

        public Builder topics(List<WikirateTopic> topics) {
            this.topics = topics;
            return this;
        }

        public Builder topic_frameworks(List<String> topicFrameworks) {
            this.topicFrameworks = topicFrameworks;
            return this;
        }

        public Builder variables(List<String> variables) {
            this.variables = variables;
            return this;
        }

        public Builder formula(String formula) {
            this.formula = formula;
            return this;
        }

        public Builder number_of_answers(Integer numberOfAnswers) {
            this.numberOfAnswers = numberOfAnswers;
            return this;
        }

        public Builder number_of_companies(Integer numberOfCompanies) {
            this.numberOfCompanies = numberOfCompanies;
            return this;
        }

        public Builder number_of_datasets(Integer numberOfDatasets) {
            this.numberOfDatasets = numberOfDatasets;
            return this;
        }

        public Builder number_of_bookmarkers(Integer numberOfBookmarkers) {
            this.numberOfBookmarkers = numberOfBookmarkers;
            return this;
        }

        public Builder calculations(List<String> calculations) {
            this.calculations = calculations;
            return this;
        }

        public Builder answers_url(String answersURL) {
            this.answersURL = answersURL;
            return this;
        }

        public Metric build() {
            return new MetricImpl(this);
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
