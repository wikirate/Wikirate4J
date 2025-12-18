package org.wikirate4j.entitities;

import org.json.JSONObject;

import java.util.Date;

public class SourceReferenceImpl implements Card, SourceReference{
    private String reference;

    public SourceReferenceImpl(String reference){
        this.reference = reference;
    }
    @Override
    public String asReference() {
        return this.reference;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public String getName() {
        return this.reference;
    }

    @Override
    public Object getContent() {
        return null;
    }

    @Override
    public String getURL() {
        return null;
    }

    @Override
    public String getHtmlURL() {
        return null;
    }

    @Override
    public String getCodename() {
        return null;
    }

    @Override
    public Date getCreatedAt() {
        return null;
    }

    @Override
    public Date getUpdatedAt() {
        return null;
    }

    @Override
    public Date getRequestedAt() {
        return null;
    }

    @Override
    public JSONObject raw_json() {
        return null;
    }

    @Override
    public JSONObject toJson() {
        return new JSONObject(this);
    }

    @Override
    public Object getContent(Class classType) {
        return null;
    }

    @Override
    public String toString(){
        return this.reference;
    }
}
