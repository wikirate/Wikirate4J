package org.wikirate4j.entitities;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vasiliki Gkatziaki
 */
public class AnswerImpl extends CardImpl implements Answer {

    String metricName;

    String metricDesigner;

    String company;

    Integer year;

    String value;

    String recordUrl;

    List<SourceReference> sources;

    String answersURL;

    String comments;

    CheckedBy checkedBy;

    protected AnswerImpl(Builder builder) {
        super(builder);
        this.metricName = builder.metricName;
        this.metricDesigner = builder.metricDesigner;
        this.company = builder.company;
        this.comments = builder.comments;
        this.sources = builder.sources;
        this.year = builder.year;
        this.value = builder.value;
        this.answersURL = builder.answersURL;
        this.recordUrl = builder.recordUrl;
    }

    @Override
    public String getMetricName() {
        return metricName;
    }

    @Override
    public String getMetricDesigner() {
        return metricDesigner;
    }

    @Override
    public String getCompany() {
        return this.company;
    }

    @Override
    public Integer getYear() {
        return year;
    }

    @Override
    public <T> T getValue(Class<T> classType) {
        if (classType.equals(Integer.class)) {
            return classType.cast(Integer.parseInt(value));
        } else if (classType.equals(Long.class)) {
            return classType.cast(Long.parseLong(value));
        } else if (classType.equals(Double.class)) {
            return classType.cast(Double.parseDouble(value));
        } else if (classType.equals(Boolean.class)) {
            return classType.cast(Boolean.parseBoolean(value));
        } else if (classType.equals(List.class)) {
            return classType.cast(Arrays.stream(value.split(",")).map(x -> x.trim()).collect(Collectors.toList()));
        }
        return (T) value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getRecordURL() {
        return recordUrl;
    }

    @Override
    public List<SourceReference> getSources() {
        return sources;
    }

    @Override
    public CheckedBy getCheckedBy() {
        return this.checkedBy;
    }

    @Override
    public String getComments() {
        return this.comments;
    }


    public static class Builder extends CardImpl.Builder<Builder> {
        private String metricName;
        private String metricDesigner;

        private String company;
        private Integer year;
        private String value;
        private String recordUrl;
        private List<SourceReference> sources;
        private String answersURL;

        private String comments;

        private CheckedBy checkedBy;

        public Builder() {
            super();
        }
        
        public Builder metricName(String metricName) {
            this.metricName = metricName;
            return this;
        }

        public Builder metricDesigner(String metricDesigner) {
            this.metricDesigner = metricDesigner;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder year(Integer year) {
            this.year = year;
            return this;
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public Builder recordUrl(String recordUrl) {
            this.recordUrl = recordUrl;
            return this;
        }

        public Builder sources(List<SourceReference> sources) {
            this.sources = sources;
            return this;
        }

        public Builder answersURL(String answersURL) {
            this.answersURL = answersURL;
            return this;
        }

        public Builder checkedBy(CheckedBy checked) {
            this.checkedBy = checked;
            return this;
        }

        public Builder comments(String comments) {
            this.comments = comments;
            return this;
        }

        public Answer build() {
            return new AnswerImpl(this);
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
