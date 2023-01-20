import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.Company;
import org.wikirate4j.entitities.CompanyImpl;
import org.wikirate4j.utils.Country;

import java.util.Map;

/**
 * Example of how to add a new company
 *
 * @author Vasiliki Gkatziaki
 */
public class AddNewCompany {

    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //here we define the company we want to add to the platform
        Company company = new CompanyImpl.Builder()
                .name("My new test company Inc.")
                .headquarters(Country.UNITED_KINGDOM.value())
                .build();

        long id = client.addCompany(company);
        System.out.println("The company has successfully created with id: " + id);
    }
}
