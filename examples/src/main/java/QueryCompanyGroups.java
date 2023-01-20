import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.CompanyGroup;
import org.wikirate4j.utils.queries.CompanyGroupQuery;

import java.util.List;
import java.util.Map;

/**
 * Example of how to query company groups
 *
 * @author Vasiliki Gkatziaki
 */
public class QueryCompanyGroups {

    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //query by name and limit the results to maximum 100
        CompanyGroupQuery query = new CompanyGroupQuery()
                .name("Wikirate")
                .limit(100);

        List<CompanyGroup> companyGroups = client.getCompanyGroups(query);

        for (CompanyGroup companyGroup : companyGroups) {
            System.out.println(companyGroup.getId() + ": " + companyGroup.getName());
        }
    }
}
