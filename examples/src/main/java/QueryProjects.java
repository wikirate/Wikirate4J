import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.Card;
import org.wikirate4j.utils.ProjectStatus;
import org.wikirate4j.utils.queries.ProjectQuery;

import java.util.List;
import java.util.Map;

/**
 * Example how to query Projects
 *
 * @author Vasiliki Gkatziaki
 */
public class QueryProjects {

    public static void main(String[] args) {

        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //here we define the query to get only active projects and limit the results to maximum 100
        ProjectQuery query = new ProjectQuery()
                .status(ProjectStatus.ACTIVE)
                .limit(100);

        List<Card> projects = client.getProjects(query);

        for (Card project : projects) {
            System.out.println(project.getId() + ": " + project.getName());
        }
    }
}
