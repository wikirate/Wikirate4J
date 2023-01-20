package org.wikirate4j.examples;

import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;

import org.wikirate4j.entitities.Metric;
import org.wikirate4j.utils.*;

import org.wikirate4j.utils.queries.MetricQuery;

import java.util.List;
import java.util.Map;

/**
 * Example of how to query Metrics
 *
 * @author Vasiliki Gkatziaki
 */
public class QueryMetrics {

    public static void main(String[] args) {
        Map<String, String> environment = new ProcessBuilder().environment();

        WikirateClient client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();

        //here we define the query to get only Researched metrics, with multi-category values, the answers must be
        // designer assessed and with metric desginer Fashion Revolution
        MetricQuery query = new MetricQuery()
                .metric_type(MetricType.RESEARCHED)
                .value_type(ValueType.MULTI_CATEGORY)
                .research_policy(ResearchPolicy.DESIGNER_ASSESSED)
                .designer("Fashion Revolution")
                .limit(10);

        List<Metric> metrics = client.getMetrics(query);

        for (Metric metric : metrics) {
            System.out.println(metric.getId() + ": " + metric.getName());
        }
    }
}
