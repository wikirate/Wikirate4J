import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.Source;
import org.wikirate4j.entitities.SourceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Example of how to add a new source
 *
 * @author Vasiliki Gkatziaki
 */
public class AddNewSource {

    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        List<Integer> years = new ArrayList<>();
        years.add(2015);
        List<String> companies = new ArrayList<>();
        companies.add("Tesla Motors");

        //here we define details about the source such as title, years, companies, url
        Source source = new SourceImpl.Builder()
                .title("Tesla Motors, Inc. 10-K Filing of 2015")
                .years(years)
                .companies(companies)
                .url("https://www.sec.gov/Archives/edgar/data/1318605/000156459016013195/tsla-10k_20151231.htm")
                .build();
        String source_name = client.addSource(source);
        System.out.println("The source has successfully added with name: " + source_name);
    }
}

