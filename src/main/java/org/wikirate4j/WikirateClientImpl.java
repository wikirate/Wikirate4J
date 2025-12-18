package org.wikirate4j;

import org.apache.http.auth.AuthenticationException;
import org.json.JSONArray;
import org.wikirate4j.entitities.*;
import org.wikirate4j.exceptions.HTTPException;
import org.wikirate4j.exceptions.IncompatibleCardTypeException;
import org.wikirate4j.utils.*;
import org.wikirate4j.utils.queries.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasiliki Gkatziaki
 */
public class WikirateClientImpl implements WikirateClient {

    private String api_key;

    private String username;

    private String password;

    private String HOST = "wikirate.org";

    private WikirateClientImpl(Builder builder) {
        this.api_key = builder.api_key;
        this.username = builder.username;
        this.password = builder.password;
        if (builder.host != null) {
            this.HOST = builder.host;
        }
    }

    @Override
    public Company getCompany(String name) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint(StringUtils.transformToWikiRateFriendlyName(name) + ".json")
                    .GET();

            return WikirateCardFactory.createCompany(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Company getCompany(long id) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("~" + id + ".json")
                    .GET();

            return WikirateCardFactory.createCompany(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long addCompany(Company company) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .addParameter("card[type]", "Company")
                    .addParameter("card[name]", company.getName())
                    .addParameter("card[subcards][+headquarters]", company.getHeadquarters())
                    .addParameter("card[subcards][+open_corporates_id]", company.getOpenCorporatesID())
                    .addParameter("card[subcards][+open_supply_id]", company.getOpenSupplyHubId())
                    .addParameter("card[subcards][+uk_company_number]", company.getUKCompanyNumber())
                    .addParameter("card[subcards][+australian_business_number]", company.getAustralianBusinessNumber())
                    .addParameter("card[subcards][+australian_company_number]", company.getAustralianCompanyNumber())
                    .addParameter("card[subcards][+international_securities_identification_number][]", String.join("\n", company.getISINs()))
                    .addParameter("card[subcards][+wikidata_id]", company.getWikidataID())
                    .addParameter("card[subcards][+legal_entity_identifier]", company.getLegalEntityIdentifier())
                    .addParameter("card[subcards][+wikipedia]", company.getWikipedia())
                    .addParameter("card[subcards][+sec_cik]", company.getCentralIndexKey())
                    .addParameter("card[skip]", "update_oc_mapping_due_to_headquarters_entry")
                    .addParameter("confirmed", "true")
                    .addParameter("format", "json")
                    .addParameter("success[format]", "json")
                    .endpoint("/card/create")
                    .POST();

            return WikirateCardFactory.createCompany(request.getResponse()).getId();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCompany(Company company) {
        try {
            String endpoint;
            if (company.getId() != null)
                endpoint = "~" + String.valueOf(company.getId());
            else
                endpoint = StringUtils.transformToWikiRateFriendlyName(company.getName());
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .addParameter("card[type]", "Company")
                    .addParameter("card[name]", company.getName())
                    .addParameter("card[subcards][+headquarters]", company.getHeadquarters())
                    .addParameter("card[subcards][+open_corporates_id]", company.getOpenCorporatesID())
                    .addParameter("card[subcards][+open_supply_id]", company.getOpenSupplyHubId())
                    .addParameter("card[subcards][+uk_company_number]", company.getUKCompanyNumber())
                    .addParameter("card[subcards][+australian_business_number]", company.getAustralianBusinessNumber())
                    .addParameter("card[subcards][+australian_company_number]", company.getAustralianCompanyNumber())
                    .addParameter("card[subcards][+international_securities_identification_number][]", String.join("\n", company.getISINs()))
                    .addParameter("card[subcards][+wikidata_id]", company.getWikidataID())
                    .addParameter("card[subcards][+legal_entity_identifier]", company.getLegalEntityIdentifier())
                    .addParameter("card[subcards][+wikipedia]", company.getWikipedia())
                    .addParameter("card[subcards][+sec_central_index_key]", company.getCentralIndexKey())
                    .addParameter("format", "json")
                    .addParameter("success[format]", "json")
                    .endpoint("/update/" + endpoint)
                    .POST();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Company> getSuggestions(String companyName) {
        try {
            List<Company> companies = new ArrayList<>();
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .addParameter("card[type]", "Company")
                    .addParameter("card[name]", companyName)
                    .addParameter("format", "json")
                    .addParameter("success[format]", "json")
                    .endpoint("/card/create")
                    .POST();

            JSONArray items = request.getJSONResponse().getJSONArray("potential_duplicates");
            for (int i = 1; i < items.length(); i++) {
                companies.add(WikirateCardFactory.createCompany(items.getJSONObject(i).toString()));
            }
            return companies;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Company> getCompanies(CompanyQuery query) {
        try {
            List<Company> companies = new ArrayList<>();
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("Companies.json")
                    .parameters(query.getQueryParams())
                    .filters(query.getFilters())
                    .GET();

            JSONArray items = request.getJSONResponse().getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                companies.add(WikirateCardFactory.createCompany(items.getJSONObject(i).toString()));
            }
            return companies;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Metric getMetric(String metricDesigner, String metricName) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint(StringUtils.transformToWikiRateFriendlyName(metricDesigner) + "+" + StringUtils.transformToWikiRateFriendlyName(metricName) + ".json")
                    .GET();

            return WikirateCardFactory.createMetric(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Metric getMetric(long id) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("~" + id + ".json")
                    .GET();

            return WikirateCardFactory.createMetric(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Metric> getMetrics(MetricQuery query) {
        try {
            List<Metric> metrics = new ArrayList<>();
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("Metrics.json")
                    .parameters(query.getQueryParams())
                    .filters(query.getFilters())
                    .GET();

            JSONArray items = request.getJSONResponse().getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                metrics.add(WikirateCardFactory.createMetric(items.getJSONObject(i).toString()));
            }
            return metrics;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Answer getAnswer(long id) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("~" + id + ".json")
                    .GET();

            return WikirateCardFactory.createAnswer(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Answer> getAnswers(AnswerQuery query) {
        try {
            List<Answer> answers = new ArrayList<>();
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("Answer.json")
                    .parameters(query.getQueryParams())
                    .filters(query.getFilters())
                    .GET();

            JSONArray items = request.getJSONResponse().getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                answers.add(WikirateCardFactory.createAnswer(items.getJSONObject(i).toString()));
            }
            return answers;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long addAnswer(AnswerItem answer) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .addParameter("card[type]", "Answer")
                    .addParameter("card[name]", answer.getCardName())
                    .addParameter("card[subcards][+:value]", answer.getValue())
                    .addParameter("card[subcards][+:source]", answer.getSources())
                    .addParameter("card[subcards][+:discussion]", answer.getComment())
                    .addParameter("format", "json")
                    .addParameter("success[format]", "json")
                    .endpoint("/card/create")
                    .POST();

            return WikirateCardFactory.createAnswer(request.getResponse()).getId();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAnswer(AnswerItem answer) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .addParameter("card[type]", "Answer")
                    .addParameter("card[name]", answer.getCardName())
                    .addParameter("card[subcards][+:year]", answer.getYear() == null ? null : String.valueOf(answer.getYear()))
                    .addParameter("card[subcards][+:value]", answer.getValue())
                    .addParameter("card[subcards][+:source]", answer.getSources())
                    .addParameter("card[subcards][+:discussion]", answer.getComment())
                    .addParameter("format", "json")
                    .addParameter("success[format]", "json")
                    .endpoint("/card/update")
                    .POST();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Relationship getRelationship(String name) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint(name + ".json")
                    .GET();

            return WikirateCardFactory.createRelationship(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Relationship getRelationship(long id) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("~" + id + ".json")
                    .GET();

            return WikirateCardFactory.createRelationship(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Relationship> getRelationships(RelationshipQuery query) {
        try {
            String endpoint = "Relationships";
            if (query.getMetricId() != null) {
                endpoint = "~" + query.getMetricId() + "+" + endpoint;
            } else if (query.getMetricDesigner() != null){
                endpoint = query.getMetricDesigner() + "+" + query.getMetricName() + "+" + endpoint;
            }
            List<Relationship> answers = new ArrayList<>();
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint(endpoint + ".json")
                    .parameters(query.getQueryParams())
                    .filters(query.getFilters())
                    .GET();

            JSONArray items = request.getJSONResponse().getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                answers.add(WikirateCardFactory.createRelationship(items.getJSONObject(i).toString()));
            }
            return answers;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long addRelationship(RelationshipItem answer) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .addParameter("card[type]", "Relationship")
                    .addParameter("card[name]", answer.getCardName())
                    .addParameter("card[subcards][+:value]", answer.getValue())
                    .addParameter("card[subcards][+:source]", answer.getSources())
                    .addParameter("card[subcards][+:discussion]", answer.getComment())
                    .addParameter("format", "json")
                    .addParameter("success[format]", "json")
                    .endpoint("/card/create")
                    .POST();

            return WikirateCardFactory.createRelationship(request.getResponse()).getId();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateRelationship(RelationshipItem answer) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .addParameter("card[type]", "Relationship")
                    .addParameter("card[name]", answer.getCardName())
                    .addParameter("card[subcards][+:year]", answer.getYear() == null ? null : String.valueOf(answer.getYear()))
                    .addParameter("card[subcards][+:value]", answer.getValue())
                    .addParameter("card[subcards][+:source]", answer.getSources())
                    .addParameter("card[subcards][+:discussion]", answer.getComment())
                    .addParameter("format", "json")
                    .addParameter("success[format]", "json")
                    .endpoint("/card/update")
                    .POST();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Dataset getDataset(String name) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint(StringUtils.transformToWikiRateFriendlyName(name) + ".json")
                    .GET();

            return WikirateCardFactory.createDataset(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Dataset getDataset(long id) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("~" + id + ".json")
                    .GET();

            return WikirateCardFactory.createDataset(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Dataset> getDatasets(DatasetQuery query) {
        try {
            List<Dataset> datasets = new ArrayList<>();
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("Data_Set.json")
                    .parameters(query.getQueryParams())
                    .filters(query.getFilters())
                    .GET();

            JSONArray items = request.getJSONResponse().getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {

                datasets.add(WikirateCardFactory.createDataset(items.getJSONObject(i).toString()));
            }
            return datasets;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Topic getTopic(long id) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("~" + id + ".json")
                    .GET();

            return WikirateCardFactory.createTopic(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Topic getTopic(String name) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint(StringUtils.transformToWikiRateFriendlyName(name) + ".json")
                    .GET();

            return WikirateCardFactory.createTopic(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Topic> getTopics(TopicQuery query) {
        try {
            List<Topic> topics = new ArrayList<>();
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("Topics.json")
                    .parameters(query.getQueryParams())
                    .filters(query.getFilters())
                    .GET();

            JSONArray items = request.getJSONResponse().getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                topics.add(WikirateCardFactory.createTopic(items.getJSONObject(i).toString()));
            }
            return topics;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Source getSource(String name) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint(name + ".json")
                    .GET();

            return WikirateCardFactory.createSource(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Source getSource(long id) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("~" + id + ".json")
                    .GET();

            return WikirateCardFactory.createSource(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String addSource(Source source) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .addParameter("card[type]", "Source")
                    .addParameter("card[subcards][+title]", source.getTitle())
                    .addParameter("card[subcards][+link]", source.getLink())
                    .addParameter("card[subcards][+company]", getValueFromList(source.getCompanies()))
                    .addParameter("card[subcards][+year]", getValueFromList(source.getYears()))
                    .addParameter("card[subcards][+report_type]", getValueFromList(source.getReportTypes()))
                    .addParameter("card[skip]", "requirements")
                    .addParameter("format", "json")
                    .addParameter("success[format]", "json")
                    .endpoint("/card/create")
                    .POST();

            return WikirateCardFactory.createSource(request.getResponse()).getName();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSource(Source source) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .addParameter("card[type]", "Source")
                    .addParameter("card[name]", source.getName() == null ? "~" + String.valueOf(source.getId()) : source.getName())
                    .addParameter("card[subcards][+title]", source.getTitle())
                    .addParameter("card[subcards][+link]", source.getLink())
                    .addParameter("card[subcards][+company]", getValueFromList(source.getCompanies()))
                    .addParameter("card[subcards][+year]", getValueFromList(source.getYears()))
                    .addParameter("card[subcards][+report_type]", getValueFromList(source.getReportTypes()))
                    .addParameter("card[skip]", "requirements")
                    .addParameter("format", "json")
                    .addParameter("success[format]", "json")
                    .endpoint("/card/update")
                    .POST();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Source> getSources(SourceQuery query) {
        try {
            List<Source> sources = new ArrayList<>();
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("Sources.json")
                    .parameters(query.getQueryParams())
                    .filters(query.getFilters())
                    .GET();

            JSONArray items = request.getJSONResponse().getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                sources.add(WikirateCardFactory.createSource(items.getJSONObject(i).toString()));
            }
            return sources;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CompanyGroup getCompanyGroup(String name) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint(StringUtils.transformToWikiRateFriendlyName(name) + ".json")
                    .GET();

            return WikirateCardFactory.createCompanyGroup(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CompanyGroup getCompanyGroup(long id) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("~" + id + ".json")
                    .GET();

            return WikirateCardFactory.createCompanyGroup(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CompanyGroup> getCompanyGroups(CompanyGroupQuery query) {
        try {
            List<CompanyGroup> companyGroups = new ArrayList<>();
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("Company_Group.json")
                    .parameters(query.getQueryParams())
                    .filters(query.getFilters())
                    .GET();

            JSONArray items = request.getJSONResponse().getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                companyGroups.add(WikirateCardFactory.createCompanyGroup(items.getJSONObject(i).toString()));
            }
            return companyGroups;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long addCompanyGroup(CompanyGroup companyGroup) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .addParameter("card[type]", "Company Group")
                    .addParameter("card[name]", companyGroup.getName())
                    .addParameter("card[subcards][+company]", getValueFromList(companyGroup.getCompanies()))
                    .addParameter("format", "json")
                    .addParameter("success[format]", "json")
                    .endpoint("/card/create")
                    .POST();

            return WikirateCardFactory.createCompanyGroup(request.getResponse()).getId();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCompanyGroup(CompanyGroup companyGroup) {
        try {
            String endpoint = "/update/";
            if (companyGroup.getId() != null) endpoint += "~" + companyGroup.getId();
            else endpoint += StringUtils.transformToWikiRateFriendlyName(companyGroup.getName());

            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .addParameter("card[type]", "Company Group")
                    .addParameter("card[name]", companyGroup.getName())
                    .addParameter("card[subcards][+company]", getValueFromList(companyGroup.getCompanies()))
                    .addParameter("format", "json")
                    .addParameter("success[format]", "json")
                    .endpoint(endpoint)
                    .POST();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResearchGroup getResearchGroup(String name) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint(StringUtils.transformToWikiRateFriendlyName(name) + ".json")
                    .GET();

            return WikirateCardFactory.createResearchGroup(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResearchGroup getResearchGroup(long id) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("~" + id + ".json")
                    .GET();

            return WikirateCardFactory.createResearchGroup(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ResearchGroup> getResearchGroups(ResearchGroupQuery query) {
        try {
            List<ResearchGroup> researchGroups = new ArrayList<>();
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("Research_Group.json")
                    .parameters(query.getQueryParams())
                    .filters(query.getFilters())
                    .GET();

            JSONArray items = request.getJSONResponse().getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                researchGroups.add(WikirateCardFactory.createResearchGroup(items.getJSONObject(i).toString()));
            }
            return researchGroups;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Region getRegion(String name) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint(StringUtils.transformToWikiRateFriendlyName(name) + ".json")
                    .GET();

            return WikirateCardFactory.createRegion(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Region getRegion(long id) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("~" + id + ".json")
                    .GET();

            return WikirateCardFactory.createRegion(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Region> getRegions(Query query) {
        try {
            List<Region> regions = new ArrayList<>();
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("Regions.json")
                    .parameters(query.getQueryParams())
                    .filters(query.getFilters())
                    .GET();

            JSONArray items = request.getJSONResponse().getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                regions.add(WikirateCardFactory.createRegion(items.getJSONObject(i).toString()));
            }
            return regions;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CheckedBy getChecksOfAnswer(String name) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint(name + ".json")
                    .GET();

            return WikirateCardFactory.createCheckedBy(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CheckedBy getChecksOfAnswer(long id) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("~" + id + ".json")
                    .GET();

            return WikirateCardFactory.createCheckedBy(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IncompatibleCardTypeException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Card> getProjects(ProjectQuery query) {
        try {
            List<Card> projects = new ArrayList<>();
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("Projects.json")
                    .parameters(query.getQueryParams())
                    .filters(query.getFilters())
                    .GET();

            JSONArray items = request.getJSONResponse().getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                projects.add(WikirateCardFactory.createCard(items.getJSONObject(i).toString()));
            }
            return projects;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Card getCard(long id) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint("~" + id + ".json")
                    .GET();

            return WikirateCardFactory.createCard(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Card getCard(String name) {
        try {
            HttpRequest request = new HttpRequestImpl.Builder(HOST)
                    .auth(username, password)
                    .addHeader("content-type", "application/json")
                    .addHeader("X-API-KEY", api_key)
                    .endpoint(StringUtils.transformToWikiRateFriendlyName(name) + ".json")
                    .GET();

            return WikirateCardFactory.createCard(request.getResponse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        } catch (HTTPException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Builder for new instances of {@link WikirateClient}
     */
    public static class Builder {

        private String api_key;

        private String username;

        private String password;

        private String host;

        public Builder() {

        }

        public Builder api_key(String api_key) {
            this.api_key = api_key;
            return this;
        }

        public Builder auth(String username, String password) {
            this.username = username;
            this.password = password;
            return this;
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        /**
         * Creates a new instance of {@link WikirateClient}
         *
         * @return the new instance
         */
        public WikirateClient build() {
            return new WikirateClientImpl(this);
        }
    }

    private static String getValueFromList(List value) {
        if (value == null) return null;
        String string_value = "";
        for (Object value_item : (List) value) {
            string_value += value_item + "\n";
        }
        return StringUtils.isBlank(string_value) ? null : string_value;
    }
}
