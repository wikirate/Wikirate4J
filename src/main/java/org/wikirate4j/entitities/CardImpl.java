package org.wikirate4j.entitities;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vasiliki Gkatziaki

 */
public class CardImpl<K> implements Card<K> {

    Long id;

    String name;

    K content;

    String url;

    String html_url;

    String codename;

    Date created_at;

    Date updated_at;

    Date requested_at;

    JSONObject rawJson;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getContent(Class<?> classType) {
        if (classType.equals(Long.class)) {
            return rawJson.getLong("content");
        } else if (classType.equals(Integer.class)) {
            return rawJson.getInt("content");
        } else if (classType.equals(Boolean.class)) {
            return rawJson.getBoolean("content");
        } else if (classType.equals(Float.class)) {
            return rawJson.getFloat("content");
        } else if (classType.equals(Double.class)) {
            return rawJson.getDouble("content");
        } else if (classType.equals(BigDecimal.class)) {
            return rawJson.getBigDecimal("content");
        } else if (classType.equals(BigInteger.class)) {
            return rawJson.getBigInteger("content");
        } else if (classType.equals(List.class)) {
            return rawJson.getJSONArray("content").toList().stream().map(x -> x).collect(Collectors.toList());
        }
        return this.content;
    }

    @Override
    public K getContent() {
        return this.content;
    }

    @Override
    public String getURL() {
        return this.url;
    }

    @Override
    public String getHtmlURL() {
        return this.html_url;
    }

    @Override
    public String getCodename() {
        return this.codename;
    }

    @Override
    public Date getCreatedAt() {
        return this.created_at;
    }

    @Override
    public Date getUpdatedAt() {
        return this.updated_at;
    }

    @Override
    public Date getRequestedAt() {
        return this.requested_at;
    }

    @Override
    public JSONObject raw_json() {
        return this.rawJson;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject(this);
        json.remove("rawJson");
        return json;
    }


    /**
     * Builder of new {@link CardImpl} instances
     *
     * @param <T>
     */
    public static class Builder<T extends Builder> {
        private Long id;
        private String name;
        private Object content;
        private String url;
        private String html_url;
        private String codename;
        private Date created_at;
        private Date updated_at;
        private Date requested_at;
        private JSONObject rawJson;
        SimpleDateFormat dateFormater;

        public Builder() {
            this.dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        }

        public T id(Long id) {
            this.id = id;
            return (T) this;
        }

        public T name(String name) {
            this.name = name;
            return (T) this;
        }

        public T content(Object content) {
            this.content = content;
            return (T) this;
        }

        public T url(String url) {
            this.url = url;
            return (T) this;
        }

        public T html_url(String html_url) {
            this.html_url = html_url;
            return (T) this;
        }

        public T codename(String codename) {
            this.codename = codename;
            return (T) this;
        }

        public T created_at(String created_at) {
            try {
                this.created_at = created_at == null ? null : dateFormater.parse(created_at);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            return (T) this;
        }

        public T requested_at(String requested_at) {
            try {
                this.requested_at = requested_at == null ? null : dateFormater.parse(requested_at);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            return (T) this;
        }

        public T updated_at(String updated_at) {
            try {
                this.updated_at = updated_at == null ? null : dateFormater.parse(updated_at);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            return (T) this;
        }

        public T rawJson(JSONObject rawJson) {
            this.rawJson = rawJson;
            return (T) this;
        }

        /**
         * Creates a new instance of {@link CardImpl}
         *
         * @return the new instance
         */
        public Card build() {
            return new CardImpl(this);
        }
    }

    protected CardImpl(Builder<?> builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.content = (K) builder.content;
        this.url = builder.url;
        this.html_url = builder.html_url;
        this.codename = builder.codename;
        this.created_at = builder.created_at;
        this.updated_at = builder.updated_at;
        this.requested_at = builder.requested_at;
        this.rawJson = builder.rawJson;
    }
}
