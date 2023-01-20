import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.Answer;
import org.wikirate4j.utils.Country;
import org.wikirate4j.utils.queries.AnswerQuery;

import java.util.List;
import java.util.Map;

/**
 * Example of how to query answers
 *
 * @author Vasiliki Gkatziaki
 */
public class QueryAnswers {

    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //Here we define our query: we want get all the answers of companies located in the United Kingdom which
        //their Direct greenhouse gas (GHG) emissions (Scope 1), GRI 305-1-a (formerly G4-EN15-a) exceeded 1M tonnes of CO2
        //in 2021. The query limits the results to 100.
        AnswerQuery query = new AnswerQuery()
                .metric_name("Direct greenhouse gas (GHG) emissions (Scope 1), GRI 305-1-a (formerly G4-EN15-a)")
                .designer("Global Reporting Initiative")
                .value_from(1000000)
                .country(Country.UNITED_KINGDOM)
                .year(2021)
                .limit(100);

        List<Answer> answers = client.getAnswers(query);

        for (Answer answer : answers) {
            System.out.println(answer.getId() + ": " + answer.getCompany() + " = " + answer.getValue());
        }
    }
}
