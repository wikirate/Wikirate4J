import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.Company;
import org.wikirate4j.entitities.CompanyImpl;
import org.wikirate4j.utils.Country;

import java.util.Map;

/**
 * Example of how to update an existing company
 *
 * @author Vasiliki Gkatziaki
 */
public class UpdateExistingCompany {

    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //here we define the name of the company we want to update and the fields we would like to update, the headquarters
        //in our case. Alternatively, instead of using the name to define the company we can use its id.
        Company company = new CompanyImpl.Builder()
                .name("My new test company Inc.")
                .headquarters(Country.UNITED_STATES.value())
                .build();

        client.updateCompany(company);
        System.out.println("Company successfully updated.");
    }
}

