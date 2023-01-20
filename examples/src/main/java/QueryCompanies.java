import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.Company;
import org.wikirate4j.utils.CompanyCategory;
import org.wikirate4j.utils.Country;
import org.wikirate4j.utils.queries.CompanyQuery;

import java.util.List;
import java.util.Map;

/**
 * Example of how to query companies
 *
 * @author Vasiliki Gkatziaki
 */
public class QueryCompanies {

    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //Here we define our query: we want to get 10 companies that fall under MANUFACTURING, located in the UK and
        //the name includes the word Food.
        CompanyQuery query = new CompanyQuery()
                .company_category(CompanyCategory.MANUFACTURING)
                .country(Country.UNITED_KINGDOM)
                .name("Food")
                .limit(10);

        List<Company> companies = client.getCompanies(query);

        for (Company company : companies) {
            System.out.println(company.getId() + ": " + company.getName());
        }
    }
}
