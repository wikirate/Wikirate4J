import org.junit.Test;
import org.wikirate4j.WikirateCardFactory;
import org.wikirate4j.entitities.*;
import org.wikirate4j.exceptions.IncompatibleCardTypeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

/**
 * @author Vasiliki Gkatziaki
 */
public class TestWikirateCardFactory {

    ClassLoader classLoader;

    public TestWikirateCardFactory() {
        classLoader = getClass().getClassLoader();
    }

    /**
     * Tests if the WikirateCardFactory is able to create a {@link Company} Object either when the detailed or the summarized
     * version of the company is given as input
     */
    @Test
    public void TestCreateCompany() {
        //detailed company
        File company = new File(classLoader.getResource("Company.json").getFile());
        //summary company
        File company_item = new File(classLoader.getResource("CompanyItem.json").getFile());
        try {
            String company_json = new Scanner(company, "UTF-8").useDelimiter("\\A").next();
            String company_item_json = new Scanner(company_item, "UTF-8").useDelimiter("\\A").next();
            assertTrue(WikirateCardFactory.createCompany(company_json) instanceof Company);
            assertTrue(WikirateCardFactory.createCompany(company_item_json) instanceof Company);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Tests if the WikirateCardFactory is able to create a {@link Metric} Object when different metric types are given as input
     * either detailed or summarized
     */
    @Test
    public void TestCreateMetric() {
        //detailed researched metric
        File researched = new File(classLoader.getResource("ResearchMetric.json").getFile());
        //detailed formula metric
        File formula = new File(classLoader.getResource("FormulaMetric.json").getFile());
        //detailed relationship metric
        File relationship = new File(classLoader.getResource("RelationshipMetric.json").getFile());
        //detailed inverse relationship metric
        File inverse_relationship = new File(classLoader.getResource("InverseRelationshipMetric.json").getFile());
        //detailed wikirating
        File wikirating = new File(classLoader.getResource("WikiRating.json").getFile());
        //detailed score metric
        File score = new File(classLoader.getResource("ScoreMetric.json").getFile());
        //detailed descendant metric
        File descendant = new File(classLoader.getResource("DescendantMetric.json").getFile());

        //Summarized researched metric
        File researched_item = new File(classLoader.getResource("ResearchMetricItem.json").getFile());
        //Summarized formula metric
        File formula_item = new File(classLoader.getResource("FormulaMetricItem.json").getFile());
        //Summarized relationship metric
        File relationship_item = new File(classLoader.getResource("RelationshipMetricItem.json").getFile());
        //Summarized inverse relationship metric
        File inverse_relationship_item = new File(classLoader.getResource("InverseRelationshipMetricItem.json").getFile());
        //Summarized wikirating
        File wikirating_item = new File(classLoader.getResource("WikiRatingItem.json").getFile());
        //Summarized score metric
        File score_item = new File(classLoader.getResource("ScoreMetricItem.json").getFile());
        //Summarized descendant metric
        File descendant_item = new File(classLoader.getResource("DescendantMetricItem.json").getFile());


        try {
            String researched_json = new Scanner(researched, "UTF-8").useDelimiter("\\A").next();
            String formula_json = new Scanner(formula, "UTF-8").useDelimiter("\\A").next();
            String relationship_json = new Scanner(relationship, "UTF-8").useDelimiter("\\A").next();
            String inverse_relationship_json = new Scanner(inverse_relationship, "UTF-8").useDelimiter("\\A").next();
            String wikirating_json = new Scanner(wikirating, "UTF-8").useDelimiter("\\A").next();
            String score_json = new Scanner(score, "UTF-8").useDelimiter("\\A").next();
            String descendant_json = new Scanner(descendant, "UTF-8").useDelimiter("\\A").next();

            String researched_item_json = new Scanner(researched_item, "UTF-8").useDelimiter("\\A").next();
            String formula_item_json = new Scanner(formula_item, "UTF-8").useDelimiter("\\A").next();
            String relationship_item_json = new Scanner(relationship_item, "UTF-8").useDelimiter("\\A").next();
            String inverse_item_relationship_json = new Scanner(inverse_relationship_item, "UTF-8").useDelimiter("\\A").next();
            String wikirating_item_json = new Scanner(wikirating_item, "UTF-8").useDelimiter("\\A").next();
            String score_item_json = new Scanner(score_item, "UTF-8").useDelimiter("\\A").next();
            String descendant_item_json = new Scanner(descendant_item, "UTF-8").useDelimiter("\\A").next();

            assertTrue(WikirateCardFactory.createMetric(researched_json) instanceof Metric);
            assertTrue(WikirateCardFactory.createMetric(formula_json) instanceof Metric);
            assertTrue(WikirateCardFactory.createMetric(relationship_json) instanceof Metric);
            assertTrue(WikirateCardFactory.createMetric(inverse_relationship_json) instanceof Metric);
            assertTrue(WikirateCardFactory.createMetric(wikirating_json) instanceof Metric);
            assertTrue(WikirateCardFactory.createMetric(score_json) instanceof Metric);
            assertTrue(WikirateCardFactory.createMetric(descendant_json) instanceof Metric);

            assertTrue(WikirateCardFactory.createMetric(researched_item_json) instanceof Metric);
            assertTrue(WikirateCardFactory.createMetric(formula_item_json) instanceof Metric);
            assertTrue(WikirateCardFactory.createMetric(relationship_item_json) instanceof Metric);
            assertTrue(WikirateCardFactory.createMetric(inverse_item_relationship_json) instanceof Metric);
            assertTrue(WikirateCardFactory.createMetric(wikirating_item_json) instanceof Metric);
            assertTrue(WikirateCardFactory.createMetric(score_item_json) instanceof Metric);
            assertTrue(WikirateCardFactory.createMetric(descendant_item_json) instanceof Metric);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Tests if the WikirateCardFactory is able to create a {@link Source} Object either when the detailed or the summarized
     * version of the source is given as input
     */
    @Test
    public void TestCreateSource() {
        //detailed source
        File source = new File(classLoader.getResource("Source.json").getFile());
        //summary source
        File source_item = new File(classLoader.getResource("SourceItem.json").getFile());
        try {
            String source_json = new Scanner(source, "UTF-8").useDelimiter("\\A").next();
            String source_item_json = new Scanner(source_item, "UTF-8").useDelimiter("\\A").next();
            assertTrue(WikirateCardFactory.createSource(source_json) instanceof Source);
            assertTrue(WikirateCardFactory.createSource(source_item_json) instanceof Source);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Tests if the WikirateCardFactory is able to create a {@link Topic} Object either when the detailed or the summarized
     * version of the topic is given as input
     */
    @Test
    public void TestCreateTopic() {
        //detailed topic
        File topic = new File(classLoader.getResource("Topic.json").getFile());
        //summary topic
        File topic_item = new File(classLoader.getResource("TopicItem.json").getFile());
        try {
            String topic_json = new Scanner(topic, "UTF-8").useDelimiter("\\A").next();
            String topic_item_json = new Scanner(topic_item, "UTF-8").useDelimiter("\\A").next();
            assertTrue(WikirateCardFactory.createTopic(topic_json) instanceof Topic);
            assertTrue(WikirateCardFactory.createTopic(topic_item_json) instanceof Topic);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Tests if the WikirateCardFactory is able to create a {@link Answer} Object either when the detailed or the summarized
     * version of the answer is given as input
     */
    @Test
    public void TestCreateAnswer() {
        //detailed answer
        File answer = new File(classLoader.getResource("Answer.json").getFile());
        //summary answer
        File answer_item = new File(classLoader.getResource("AnswerItem.json").getFile());
        try {
            String answer_json = new Scanner(answer, "UTF-8").useDelimiter("\\A").next();
            String answer_item_json = new Scanner(answer_item, "UTF-8").useDelimiter("\\A").next();
            assertTrue(WikirateCardFactory.createAnswer(answer_json) instanceof Answer);
            assertTrue(WikirateCardFactory.createAnswer(answer_item_json) instanceof Answer);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Tests if the WikirateCardFactory is able to create a {@link RelationshipAnswer} Object either when the detailed or the summarized
     * version of the relationship answer is given as input
     */
    @Test
    public void TestCreateRelationshipAnswer() {
        //detailed answer
        File answer = new File(classLoader.getResource("RelationshipAnswer.json").getFile());
        //summary answer
        File answer_item = new File(classLoader.getResource("RelationshipAnswerItem.json").getFile());
        try {
            String answer_json = new Scanner(answer, "UTF-8").useDelimiter("\\A").next();
            String answer_item_json = new Scanner(answer_item, "UTF-8").useDelimiter("\\A").next();
            assertTrue(WikirateCardFactory.createRelationshipAnswer(answer_json) instanceof RelationshipAnswer);
            assertTrue(WikirateCardFactory.createRelationshipAnswer(answer_item_json) instanceof RelationshipAnswer);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Tests if the WikirateCardFactory is able to create a {@link ResearchGroup} Object either when the detailed or the summarized
     * version of the research group is given as input
     */
    @Test
    public void TestCreateResearchGroup() {
        //detailed research group
        File research_group = new File(classLoader.getResource("ResearchGroup.json").getFile());
        //summary research group item
        //summary research group item
        File research_group_item = new File(classLoader.getResource("ResearchGroupItem.json").getFile());
        try {
            String research_group_json = new Scanner(research_group, "UTF-8").useDelimiter("\\A").next();
            String resarch_group_item_json = new Scanner(research_group_item, "UTF-8").useDelimiter("\\A").next();
            assertTrue(WikirateCardFactory.createResearchGroup(research_group_json) instanceof ResearchGroup);
            assertTrue(WikirateCardFactory.createResearchGroup(resarch_group_item_json) instanceof ResearchGroup);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Tests if the WikirateCardFactory is able to create a {@link Dataset} Object either when the detailed or the summarized
     * version of the dataset is given as input
     */
    @Test
    public void TestCreateDataset() {
        //detailed dataset
        File dataset = new File(classLoader.getResource("Dataset.json").getFile());
        //summary dataset item
        File dataset_item = new File(classLoader.getResource("DatasetItem.json").getFile());
        try {
            String dataset_json = new Scanner(dataset, "UTF-8").useDelimiter("\\A").next();
            String dataset_item_json = new Scanner(dataset_item, "UTF-8").useDelimiter("\\A").next();
            assertTrue(WikirateCardFactory.createDataset(dataset_json) instanceof Dataset);
            assertTrue(WikirateCardFactory.createDataset(dataset_item_json) instanceof Dataset);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Tests if the WikirateCardFactory is able to create a {@link CheckedBy} Object
     */
    @Test
    public void TestCreateCheckedBy() {
        File checked_by = new File(classLoader.getResource("CheckedBy.json").getFile());
        try {
            String checked_by_json = new Scanner(checked_by, "UTF-8").useDelimiter("\\A").next();
            assertTrue(WikirateCardFactory.createCheckedBy(checked_by_json) instanceof CheckedBy);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Tests if the WikirateCardFactory is able to create a {@link Card} Object
     */
    @Test
    public void TestCreateCard() {
        File card = new File(classLoader.getResource("Card.json").getFile());
        try {
            String card_json = new Scanner(card, "UTF-8").useDelimiter("\\A").next();
            assertTrue(WikirateCardFactory.createCard(card_json) instanceof Card);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Tests if the WikirateCardFactory is able to create a {@link CompanyGroup} Object either when the detailed or the summarized
     * version of the company group is given as input
     */
    @Test
    public void TestCreateCompanyGroup() {
        //detailed company group
        File company_group = new File(classLoader.getResource("CompanyGroup.json").getFile());
        //summary company group item
        File company_group_item = new File(classLoader.getResource("CompanyGroupItem.json").getFile());
        try {
            String company_group_json = new Scanner(company_group, "UTF-8").useDelimiter("\\A").next();
            String company_group_item_json = new Scanner(company_group_item, "UTF-8").useDelimiter("\\A").next();
            assertTrue(WikirateCardFactory.createCompanyGroup(company_group_json) instanceof CompanyGroup);
            assertTrue(WikirateCardFactory.createCompanyGroup(company_group_item_json) instanceof CompanyGroup);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        }
    }
}
