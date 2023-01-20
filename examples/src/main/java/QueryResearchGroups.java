import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.ResearchGroup;
import org.wikirate4j.utils.queries.ResearchGroupQuery;

import java.util.List;
import java.util.Map;

/**
 * Example of how to query research groups
 *
 * @author Vasiliki Gkatziaki
 */
public class QueryResearchGroups {

    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //here we define the query to get research groups of University of Nottingham
        ResearchGroupQuery query = new ResearchGroupQuery()
                .name("University of Nottingham")
                .limit(100);

        List<ResearchGroup> researchGroups = client.getResearchGroups(query);

        for (ResearchGroup researchGroup : researchGroups) {
            System.out.println(researchGroup.getId() + ": " + researchGroup.getName());
        }
    }
}
