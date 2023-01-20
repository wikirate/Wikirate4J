import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.RelationshipAnswerItem;

import java.util.Map;

/**
 * Example of how to add a new relationship metric answer
 *
 * @author Vasiliki Gkatziaki
 */
public class AddNewRelationshipAnswer {

    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //here we define the metric name, metric designer, the subject and object company and the year the relationship
        //is referring to as well as the value and the source(s) the answer is linked to.
        RelationshipAnswerItem answer = new RelationshipAnswerItem("Supplied By", "Commons", "TOMS Shoes", "Dongguan Xinyilai Rubber Goods. Ltd.", 2022)
                .value("Tier 1 Supplier")
                .source("Source_000125446");

        long id = client.addRelationshipAnswer(answer);
        System.out.println("The relationship answer has successfully added with id: " + id);
    }
}
