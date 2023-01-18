package org.wikirate4j.entitities;

import java.util.List;

/**
 * The AnswerItem Object represents an answer on a Metric. This object is used when we want to add/update an answer on
 * Wikirate
 *
 * @author Vasiliki Gkatziaki
 */
public class AnswerItem {

    int year;

    String card_name;

    String value;

    String sources;

    String comment;

    public AnswerItem(Long answer_id) {
        this.card_name = "~" + answer_id;
    }

    public AnswerItem(String metric_name, String metric_designer, String company_name, int year) {
        this.card_name = metric_designer + "+" + metric_name + "+" + company_name + "+" + year;
    }

    public AnswerItem(Long metric_id, Long company_id, int year) {
        this.card_name = "~" + metric_id + "+~" + company_id + "+" + year;
    }

    public int getYear() {
        return this.year;
    }

    public String getCardName() {
        return card_name;
    }

    public String getValue() {
        return value;
    }

    public String getSources() {
        return sources;
    }

    public String getComment() {
        return comment;
    }

    public AnswerItem year(int year) {
        this.year = year;
        return this;
    }

    public AnswerItem value(Object value) {
        this.value = "";
        if (value instanceof List) {
            for (Object value_item : (List) value) {
                this.value += value_item + "\n";
            }
        } else {
            this.value = String.valueOf(value);
        }
        return this;
    }

    public AnswerItem source(String source) {
        this.sources = source;
        return this;
    }

    public AnswerItem sources(List<String> sources) {
        this.sources = "";
        for (String source_item : sources) {
            this.sources += source_item + "\n";
        }
        return this;
    }

    public AnswerItem comment(String comment) {
        this.comment = comment;
        return this;
    }
}
