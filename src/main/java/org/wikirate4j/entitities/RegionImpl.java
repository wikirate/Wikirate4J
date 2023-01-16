package org.wikirate4j.entitities;

import org.json.JSONObject;

/**
 * @author Vasiliki Gkatziaki
 */
public class RegionImpl extends CardImpl implements Region {

    String jurisdictionKey;

    String ILORegion;

    String country;

    protected RegionImpl(Builder builder) {
        super(builder);
        this.jurisdictionKey = builder.jurisdictionKey;
        this.ILORegion = builder.ILORegion;
        this.country = builder.country;
    }


    @Override
    public String getJurisdictionKey() {
        return jurisdictionKey;
    }

    @Override
    public String getILORegion() {
        return ILORegion;
    }

    @Override
    public String getCountry() {
        return country;
    }


    public static final class Builder extends CardImpl.Builder<Builder> {
        private String jurisdictionKey;
        private String ILORegion;
        private String country;

        public Builder() {
            super();
        }


        public Builder jurisdiction_key(String jurisdictionKey) {
            this.jurisdictionKey = jurisdictionKey;
            return this;
        }

        public Builder ILORegion(String ILORegion) {
            this.ILORegion = ILORegion;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Region build() {
            return new RegionImpl(this);
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
