package org.wikirate4j.entitities;

import org.json.JSONObject;

import java.util.List;
/**
 * @author Vasiliki Gkatziaki
 */
public class ResearchGroupImpl extends CardImpl implements ResearchGroup {

    List<String> researchers;

    protected ResearchGroupImpl(Builder builder) {
        super(builder);
        this.researchers = builder.researchers;
    }

    @Override
    public List<String> getResearchers() {
        return this.researchers;
    }


    public static final class Builder extends CardImpl.Builder<Builder> {
        private List<String> researchers;

        public Builder() {
            super();
        }

        public Builder researchers(List<String> researchers) {
            this.researchers = researchers;
            return this;
        }

        public ResearchGroup build() {
            return new ResearchGroupImpl(this);
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
