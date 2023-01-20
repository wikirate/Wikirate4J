package org.wikirate4j.examples;

import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.Dataset;
import org.wikirate4j.utils.queries.DatasetQuery;

import java.util.List;
import java.util.Map;

/**
 * Example of how to query datsets
 *
 * @author Vasiliki Gkatziaki
 */
public class QueryDatasets {

    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //here we define the query to limit the results to 100 and get all datasets related to the topic of Modern Slavery
        DatasetQuery query = new DatasetQuery()
                .topic("Modern Slavery")
                .limit(100);

        List<Dataset> datasets = client.getDatasets(query);

        for (Dataset dataset : datasets) {
            System.out.println(dataset.getId() + ": " + dataset.getName());
        }
    }
}
