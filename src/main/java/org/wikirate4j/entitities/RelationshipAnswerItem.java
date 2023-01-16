package org.wikirate4j.entitities;

import java.util.List;
/**
 * @author Vasiliki Gkatziaki
 */
public class RelationshipAnswerItem {

    int year;

    String card_name;

    String value;

    String sources;

    String comment;

    public RelationshipAnswerItem(Long answer_id) {
        this.card_name = "~" + answer_id;
    }

    public RelationshipAnswerItem(String metric_name, String metric_designer, String subject_company, String object_company, int year) {
        this.card_name = metric_designer + "+" + metric_name + "+" + subject_company + "+" + year + "+" + object_company;
    }

    public RelationshipAnswerItem(Long metric_id, Long subject_company_id, Long object_company_id, int year) {
        this.card_name = "~" + metric_id + "+~" + subject_company_id + "+" + year + "+~" + object_company_id;
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

    public RelationshipAnswerItem year(int year) {
        this.year = year;
        return this;
    }

    public RelationshipAnswerItem value(Object value) {
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

    public RelationshipAnswerItem source(String source) {
        this.sources = source;
        return this;
    }

    public RelationshipAnswerItem sources(List<String> sources) {
        this.sources = "";
        for (String source_item : sources) {
            this.sources += source_item + "\n";
        }
        return this;
    }

    public RelationshipAnswerItem comment(String comment) {
        this.comment = comment;
        return this;
    }
}
