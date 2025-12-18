package org.wikirate4j;

import org.wikirate4j.entitities.*;
import org.wikirate4j.utils.queries.*;

import java.util.List;

/**
 * Interface for WikiRate Client
 *
 * @author Vasiliki Gkatziaki
 */
public interface WikirateClient {

    /**
     * Returns a {@link Company} based on its name
     *
     * @param name
     * @return
     */
    Company getCompany(String name);

    /**
     * Returns a {@link Company} based on its identifier
     *
     * @param id
     * @return
     */
    Company getCompany(long id);

    /**
     * Adds a new {@link Company} on WikiRate and returns its identifier
     *
     * @param company
     * @return the identifier on WikiRate of the new Company
     */
    long addCompany(Company company);

    /**
     * Updates an existing {@link Company} on WikiRate
     *
     * @param company
     */
    void updateCompany(Company company);

    /**
     * Returns {@link Company} suggestions based on a given company name
     *
     * @param companyName
     * @return
     */
    List<Company> getSuggestions(String companyName);

    /**
     * Returns a List of Companies based on a given query
     *
     * @param query
     * @return
     */
    List<Company> getCompanies(CompanyQuery query);

    /**
     * Returns a {@link Metric} based on its metric name and metric designer
     *
     * @param metricDesigner
     * @param metricName
     * @return
     */
    Metric getMetric(String metricDesigner, String metricName);

    /**
     * Returns a {@link Metric} based on its identifier
     *
     * @param id
     * @return
     */
    Metric getMetric(long id);

    /**
     * Returns a List of Metrics based on a given query
     *
     * @param query
     * @return
     */
    List<Metric> getMetrics(MetricQuery query);

    /**
     * Returns an {@link Answer} based on its identifier
     *
     * @param id
     * @return
     */
    Answer getAnswer(long id);

    /**
     * Returns a List of Answers based on a given query
     *
     * @param query
     * @return
     */
    List<Answer> getAnswers(AnswerQuery query);

    /**
     * Add a new Answer on WikiRate and returns its identifier
     *
     * @param answer
     * @return the identifier of the new Answer on WikiRate
     */
    long addAnswer(AnswerItem answer);

    /**
     * Updates an Answer
     *
     * @param answer
     */
    void updateAnswer(AnswerItem answer);

    /**
     * Returns a {@link RelationshipAnswer} on WikiRate based on its name
     *
     * @param name
     * @return
     */
    RelationshipAnswer getRelationshipAnswer(String name);

    /**
     * Returns a {@link RelationshipAnswer} on WikiRate based on its identifier
     *
     * @param id
     * @return
     */
    RelationshipAnswer getRelationshipAnswer(long id);

    /**
     * Returns a List of Relationship Answers based on a given query
     *
     * @param query
     * @return
     */
    List<RelationshipAnswer> getRelationshipAnswers(RelationshipAnswerQuery query);

    /**
     * Adds a new Relationship on WikiRate and returns its identifier
     *
     * @param answer
     * @return identifier
     */
    long addRelationship(RelationshipAnswerItem answer);

    /**
     * Updates an existing Relationship
     *
     * @param answer
     */
    void updateRelationship(RelationshipAnswerItem answer);

    /**
     * Returns a {@link Dataset} based on its name
     *
     * @param name
     * @return
     */
    Dataset getDataset(String name);

    /**
     * Returns a {@link Dataset} based on its identifier
     *
     * @param id
     * @return
     */
    Dataset getDataset(long id);

    /**
     * Retruns a List of Datasets based on a given query
     *
     * @param query
     * @return
     */
    List<Dataset> getDatasets(DatasetQuery query);

    /**
     * Returns a {@link Topic} based on its identifier
     *
     * @param id
     * @return
     */
    Topic getTopic(long id);

    /**
     * Returns a {@link Topic} based on its name
     *
     * @param name
     * @return
     */
    Topic getTopic(String name);

    /**
     * Returns a List of Topics based on a given query
     *
     * @param query
     * @return
     */
    List<Topic> getTopics(TopicQuery query);

    /**
     * Returns a {@link Source} based on its name
     *
     * @param name
     * @return
     */
    Source getSource(String name);

    /**
     * Returns a {@link Source} based on its identifier
     *
     * @param id
     * @return
     */
    Source getSource(long id);

    /**
     * Adds a new Source on WikiRate platform and returns its name
     *
     * @param source
     * @return the source name of the new created Source on WikiRate platform
     */
    String addSource(Source source);

    /**
     * Updates an existing source
     *
     * @param source
     */
    void updateSource(Source source);

    /**
     * Returns a List of Sources based on a given query
     *
     * @param query
     * @return
     */
    List<Source> getSources(SourceQuery query);

    /**
     * Returns a {@link CompanyGroup} based on its name
     *
     * @param name
     * @return
     */
    CompanyGroup getCompanyGroup(String name);

    /**
     * Returns a {@link CompanyGroup} based on its identifier
     *
     * @param id
     * @return
     */
    CompanyGroup getCompanyGroup(long id);

    /**
     * Returns a List of Company Groups based on a given query
     *
     * @param query
     * @return
     */
    List<CompanyGroup> getCompanyGroups(CompanyGroupQuery query);

    /**
     * Adds a new {@link CompanyGroup} on WikiRate platform and returns its identifier
     *
     * @param companyGroup
     * @return the identifier of the new Company Group
     */
    long addCompanyGroup(CompanyGroup companyGroup);

    /**
     * Updates an existing {@link CompanyGroup}
     *
     * @param companyGroup
     */
    void updateCompanyGroup(CompanyGroup companyGroup);

    /**
     * Returns a {@link ResearchGroup} based on its name
     *
     * @param name
     * @return
     */
    ResearchGroup getResearchGroup(String name);

    /**
     * Returns a {@link ResearchGroup} based on its identifier
     *
     * @param id
     * @return
     */
    ResearchGroup getResearchGroup(long id);

    /**
     * Returns a list of Research Groups based on a given query
     *
     * @param query
     * @return
     */
    List<ResearchGroup> getResearchGroups(ResearchGroupQuery query);

    /**
     * Returns a {@link Region} based on its name
     *
     * @param name
     * @return
     */
    Region getRegion(String name);

    /**
     * Returns a {@link Region} based on its identifier
     *
     * @param id
     * @return
     */
    Region getRegion(long id);

    /**
     * Returns a list of Regions based on a given query
     *
     * @param query
     * @return
     */
    List<Region> getRegions(Query query);

    /**
     * Returns a {@link CheckedBy} based its name
     *
     * @param name
     * @return
     */
    CheckedBy getChecksOfAnswer(String name);

    /**
     * Returns a {@link CheckedBy} based on its identifier
     *
     * @param id
     * @return
     */
    CheckedBy getChecksOfAnswer(long id);

    /**
     * Returns a {@link Card} of Project type based on a given Project Query
     *
     * @param query
     * @return
     */
    List<Card> getProjects(ProjectQuery query);

    /**
     * Returns a {@link Card} based on its identifier
     *
     * @param id
     * @return
     */
    Card getCard(long id);

    /**
     * Returns a {@link Card} based on its name
     *
     * @param name
     * @return
     */
    Card getCard(String name);
}
