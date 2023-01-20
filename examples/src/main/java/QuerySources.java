import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.Source;
import org.wikirate4j.utils.queries.SourceQuery;

import java.util.List;
import java.util.Map;

/**
 * Example of how to query sources
 *
 * @author Vasiliki Gkatziaki
 */
public class QuerySources {
    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //here we define the query to get sources of Nike Inc. that include on the title the phrase Conflict Minerals
        //Report and include on the link sec.gov
        SourceQuery query = new SourceQuery()
                .title("Conflict Minerals Report")
                .company_name("Nike Inc.")
                .link("sec.gov")
                .limit(100);

        List<Source> sources = client.getSources(query);

        for (Source source : sources) {
            System.out.println(source.getId() + ": " + source.getTitle() + ", " + source.getYears());
        }
    }
}
