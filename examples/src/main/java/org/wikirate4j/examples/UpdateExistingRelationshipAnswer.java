package org.wikirate4j.examples;

import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.RelationshipAnswerItem;

import java.util.Map;

/**
 * Example of how to update an existing relationship metric answer
 *
 * @author Vasiliki Gkatziaki
 */
public class UpdateExistingRelationshipAnswer {

    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //here we define the id of the relationship metric answer we want to update and the new value we wish to assign
        //except from the value we can also update the year, the source or even add comments
        RelationshipAnswerItem answer = new RelationshipAnswerItem(13993953)
                .value("Tier 2 Supplier");

        client.updateRelationshipAnswer(answer);
        System.out.println("Relationship answer successfully updated.");
    }
}
