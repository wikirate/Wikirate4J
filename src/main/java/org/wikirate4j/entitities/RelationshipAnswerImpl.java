package org.wikirate4j.entitities;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Vasiliki Gkatziaki
 */
public class RelationshipAnswerImpl extends CardImpl implements RelationshipAnswer {

    Long metric_id;

    Long inverse_metric_id;

    Long subject_company_id;

    Long object_company_id;

    String subject_company;

    String object_company;

    Integer year;

    String value;

    String record_url;

    List<Source> sources;

    String answers_url;

    String comments;

    CheckedBy checkedBy;

    private RelationshipAnswerImpl(Builder builder) {
        super(builder);
        this.metric_id = builder.metric_id;
        this.inverse_metric_id = builder.inverse_metric_id;
        this.subject_company = builder.subject_company;
        this.object_company = builder.object_company;
        this.subject_company_id = builder.subject_company_id;
        this.object_company_id = builder.object_company_id;
        this.comments = builder.comments;
        this.sources = builder.sources;
        this.year = builder.year;
        this.value = builder.value;
        this.answers_url = builder.answers_url;
        this.record_url = builder.record_url;
    }

    @Override
    public Long getMetricId() {
        return metric_id;
    }

    @Override
    public Long getInverseMetricId() {
        return inverse_metric_id;
    }

    @Override
    public Long getSubjectCompanyId() {
        return subject_company_id;
    }

    @Override
    public Long getObjectCompanyId() {
        return object_company_id;
    }

    @Override
    public String getSubjectCompany() {
        return subject_company;
    }

    @Override
    public String getObjectCompany() {
        return object_company;
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
        return record_url;
    }

    @Override
    public List<Source> getSources() {
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
        private Long metric_id;
        private Long inverse_metric_id;
        private Long subject_company_id;
        private Long object_company_id;
        private String subject_company;
        private String object_company;

        private Integer year;
        private String value;
        private String record_url;
        private List<Source> sources;
        private String answers_url;

        private String comments;

        private CheckedBy checkedBy;

        public Builder() {
            super();
        }

        public Builder metric_id(Long metric_id) {
            this.metric_id = metric_id;
            return this;
        }

        public Builder inverse_metric_id(Long inverse_metric_id) {
            this.inverse_metric_id = inverse_metric_id;
            return this;
        }

        public Builder subject_company_id(Long subject_company_id) {
            this.subject_company_id = subject_company_id;
            return this;
        }

        public Builder object_company_id(Long object_company_id) {
            this.object_company_id = object_company_id;
            return this;
        }

        public Builder subject_company(String subject_company) {
            this.subject_company = subject_company;
            return this;
        }

        public Builder object_company(String object_company) {
            this.object_company = object_company;
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

        public Builder recordUrl(String record_url) {
            this.record_url = record_url;
            return this;
        }

        public Builder sources(List<Source> sources) {
            this.sources = sources;
            return this;
        }

        public Builder answers_url(String answers_url) {
            this.answers_url = answers_url;
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

        public RelationshipAnswer build() {
            return new RelationshipAnswerImpl(this);
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
