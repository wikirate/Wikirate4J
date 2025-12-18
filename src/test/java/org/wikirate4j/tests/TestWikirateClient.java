package org.wikirate4j.tests;

import org.junit.Test;
import org.wikirate4j.WikirateClient;
import org.wikirate4j.WikirateClientImpl;
import org.wikirate4j.entitities.*;
import org.wikirate4j.utils.MetricType;
import org.wikirate4j.utils.queries.*;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Vasiliki Gkatziaki
 */
public class TestWikirateClient {

    WikirateClient client;

    public TestWikirateClient() {
        Map<String, String> environment = new ProcessBuilder().environment();

        client = new WikirateClientImpl.Builder()
                .api_key(environment.get("API_KEY"))
                .host(environment.get("WIKIRATE_HOST"))
                .auth(environment.get("USERNAME"), environment.get("PASSWORD"))
                .build();
    }

    @Test
    public void TestGetCompanies() {
        List<Company> companies = client.getCompanies(new CompanyQuery());
        assertTrue(companies.size() > 0);

        Company company = client.getCompany(companies.get(0).getId());
        assertNotNull(company);
    }

    @Test
    public void TestGetMetrics() {
        List<Metric> metrics = client.getMetrics(new MetricQuery());
        assertTrue(metrics.size() > 0);

        Metric metric = client.getMetric(metrics.get(0).getId());
        assertNotNull(metric);
    }

    @Test
    public void TestGetProjects() {
        List<Card> projects = client.getProjects(new ProjectQuery());
        assertTrue(projects.size() > 0);

        Card card = client.getCard(projects.get(0).getId());
        assertNotNull(card);
    }

    @Test
    public void TestGetDatasets() {
        List<Dataset> datasets = client.getDatasets(new DatasetQuery());
        assertTrue(datasets.size() > 0);

        Dataset dataset = client.getDataset(datasets.get(0).getId());
        assertNotNull(dataset);
    }

    @Test
    public void TestGetTopics() {
        List<Topic> topics = client.getTopics(new TopicQuery());
        assertTrue(topics.size() > 0);

        Topic topic = client.getTopic(topics.get(0).getId());
        assertNotNull(topic);
    }

    @Test
    public void TestGetAnswers() {
        List<Answer> answers = client.getAnswers(new AnswerQuery().metric_type(MetricType.RESEARCHED));
        assertTrue(answers.size() > 0);

        Answer answer = client.getAnswer(answers.get(0).getId());
        assertNotNull(answer);
    }

    @Test
    public void TestGetRelationships() {
        List<Relationship> answers = client.getRelationships(new RelationshipQuery(2929009L));
        assertTrue(answers.size() > 0);

        Relationship answer = client.getRelationship(answers.get(0).getId());
        assertNotNull(answer);
    }

    @Test
    public void TestGetSources() {
        List<Source> sources = client.getSources(new SourceQuery());
        assertTrue(sources.size() > 0);

        Source source = client.getSource(sources.get(0).getId());
        assertNotNull(source);
    }

    @Test
    public void TestGetResearchGroups() {
        List<ResearchGroup> researchGroups = client.getResearchGroups(new ResearchGroupQuery());
        assertTrue(researchGroups.size() > 0);

        ResearchGroup researchGroup = client.getResearchGroup(researchGroups.get(0).getId());
        assertNotNull(researchGroup);
    }

    @Test
    public void TestGetCompanyGroups() {
        List<CompanyGroup> companyGroups = client.getCompanyGroups(new CompanyGroupQuery());
        assertTrue(companyGroups.size() > 0);

        CompanyGroup companyGroup = client.getCompanyGroup(companyGroups.get(0).getId());
        assertNotNull(companyGroup);
    }
}
