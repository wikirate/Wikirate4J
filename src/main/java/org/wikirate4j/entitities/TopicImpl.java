package org.wikirate4j.entitities;

import org.json.JSONObject;

/**
 * @author Vasiliki Gkatziaki
 */
public class TopicImpl extends CardImpl implements Topic {

    Integer bookmarkers;

    Integer metrics;

    Integer datasets;


    protected TopicImpl(Builder builder) {
        super(builder);
        this.bookmarkers = builder.bookmarkers;
        this.metrics = builder.metrics;
        this.datasets = builder.datasets;
    }

    @Override
    public Integer getBookmarkers() {
        return this.bookmarkers;
    }

    @Override
    public Integer getMetrics() {
        return this.metrics;
    }

    @Override
    public Integer getDatasets() {
        return this.datasets;
    }


    public static final class Builder extends CardImpl.Builder<Builder> {
        private Integer bookmarkers;
        private Integer metrics;
        private Integer datasets;

        public Builder() {
            super();
        }

        public Builder bookmarkers(Integer bookmarkers) {
            this.bookmarkers = bookmarkers;
            return this;
        }

        public Builder metrics(Integer metrics) {
            this.metrics = metrics;
            return this;
        }

        public Builder datasets(Integer datasets) {
            this.datasets = datasets;
            return this;
        }

        public Topic build() {
            return new TopicImpl(this);
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
