package org.wikirate4j.examples;

import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.AnswerItem;

import java.util.Map;

/**
 * Example of how to update an existing answer
 *
 * @author Vasiliki Gkatziaki
 */
public class UpdateExistingAnswer {

    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //here we define the id of the answer we want to update and the additional fields we wish to update. Here we
        //want to update the value of the speficied answer
        AnswerItem answer = new AnswerItem(13993948)
                .value(261256);

        client.updateAnswer(answer);
        System.out.println("Answer successfully updated.");
    }
}
