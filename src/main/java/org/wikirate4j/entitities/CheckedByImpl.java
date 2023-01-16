package org.wikirate4j.entitities;

import org.json.JSONObject;

import java.util.List;
/**
 * @author Vasiliki Gkatziaki
 */
public class CheckedByImpl extends CardImpl<List> implements CheckedBy<List> {

    Integer numOfChecks;

    protected CheckedByImpl(Builder builder) {
        super(builder);
        this.numOfChecks = builder.numOfChecks;
    }

    @Override
    public Integer getChecks() {
        return this.numOfChecks;
    }

    public static final class Builder extends CardImpl.Builder<Builder> {
        private Integer numOfChecks;

        public Builder() {
            super();
        }

        public Builder numOfChecks(Integer numOfChecks) {
            this.numOfChecks = numOfChecks;
            return this;
        }

        public CheckedBy build() {
            return new CheckedByImpl(this);
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
