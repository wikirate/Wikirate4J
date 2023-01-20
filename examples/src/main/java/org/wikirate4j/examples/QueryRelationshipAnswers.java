package org.wikirate4j.examples;

import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.RelationshipAnswer;
import org.wikirate4j.utils.queries.RelationshipAnswerQuery;

import java.util.List;
import java.util.Map;

/**
 * Example of how to query Relationship Answers
 *
 * @author Vasiliki Gkatziaki
 */
public class QueryRelationshipAnswers {
    public static void main(String[] args) {

        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //here we define the query to get the suppliers of TOMS Shoes on 2021
        RelationshipAnswerQuery query = new RelationshipAnswerQuery("Supplied By", "Commons")
                .subject_company("TOMS Shoes")
                .year(2021)
                .limit(100);

        List<RelationshipAnswer> answers = client.getRelationshipAnswers(query);

        for (RelationshipAnswer answer : answers) {
            System.out.println(answer.getId() + ": " + answer.getObjectCompany() + " = " + answer.getValue());
        }
    }
}
