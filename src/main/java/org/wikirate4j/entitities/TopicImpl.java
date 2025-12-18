package org.wikirate4j.entitities;

import org.json.JSONObject;
import org.wikirate4j.utils.TopicFramework;

import java.util.List;

/**
 * @author Vasiliki Gkatziaki
 */
public class TopicImpl extends CardImpl implements Topic {

    String title;

    TopicFramework framework;

    String family;

    String parent;

    List<String> children;

    String metrics;

    String datasets;


    protected TopicImpl(Builder builder) {
        super(builder);
        this.title = builder.title;
        this.framework = builder.framework;
        this.family = builder.family;
        this.parent = builder.parent;
        this.children = builder.children;
        this.metrics = builder.metrics;
        this.datasets = builder.datasets;

    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public TopicFramework getFramework() {
        return this.framework;
    }

    @Override
    public String getFamily() {
        return this.family;
    }

    @Override
    public String getParent() {
        return this.parent;
    }

    @Override
    public List<String> getChildren() {
        return children;
    }

    @Override
    public String getMetrics() {
        return this.metrics;
    }

    @Override
    public String getDatasets() {
        return this.datasets;
    }


    public static final class Builder extends CardImpl.Builder<Builder> {
        private String title;
        private TopicFramework framework;
        private String family;
        private String parent;
        private List<String> children;
        private String metrics;
        private String datasets;

        public Builder() {
            super();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder framework(String framework) {
            this.framework = TopicFramework.getTopicFramework(framework);
            return this;
        }

        public Builder family(String family) {
            this.family = family;
            return this;
        }

        public Builder parent(String parent) {
            this.parent = parent;
            return this;
        }

        public Builder children(List<String> children) {
            this.children = children;
            return this;
        }

        public Builder metrics(String metrics) {
            this.metrics = metrics;
            return this;
        }

        public Builder datasets(String datasets) {
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
