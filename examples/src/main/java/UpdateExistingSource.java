import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.Source;
import org.wikirate4j.entitities.SourceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Example of how we can update an existing source
 *
 * @author Vasiliki Gkatziaki
 */
public class UpdateExistingSource {

    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        List<Integer> years = new ArrayList<>();
        years.add(2015);
        years.add(2014);
        years.add(2013);

        //here we define the source we want to update by giving its id and updating the years the source is referring to.
        Source source = new SourceImpl.Builder()
                .id(13993958L)
                .years(years)
                .build();

        client.updateSource(source);
        System.out.println("Source successfully updated.");
    }
}
