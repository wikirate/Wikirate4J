import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.AnswerItem;

import java.util.Map;

/**
 * Example of how to add a new researched answer
 *
 * @author Vasiliki Gkatziaki
 */
public class AddNewAnswer {

    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //here we define the metric name, metric designer, the company name and the year the answer is referring to, as
        //well as the value and the source(s) the answer is linked to.
        AnswerItem answer = new AnswerItem("Employee", "Core", "Infosys", 2022)
                .value(260256)
                .source("Source_000155425");

        long id = client.addAnswer(answer);
        System.out.println("The answer has successfully added with id: " + id);
    }

}
