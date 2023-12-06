package org.wikirate4j;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.wikirate4j.entitities.*;
import org.wikirate4j.exceptions.IncompatibleCardTypeException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A class for creating different types of WikiRate Cards
 * @author Vasiliki Gkatziaki
 */
public class WikirateCardFactory {

    /**
     * Creates a {@link Company} given the raw json response from the api request
     * @param rawJson
     * @return
     * @throws IncompatibleCardTypeException in case a different Card type is returned
     */
    public static Company createCompany(String rawJson) throws IncompatibleCardTypeException {
        JSONObject json = new JSONObject(rawJson);

        String card_type = getCardType(json);

        if (!card_type.equals("Company"))
            throw new IncompatibleCardTypeException("The requested Card is not a Company but a " + card_type);
        try {
            return new CompanyImpl.Builder()
                    .id(json.getLong("id"))
                    .name(json.getString("name"))
                    .headquarters(getContentOfArray("headquarters", json, String.class) != null ? getContentOfArray("headquarters", json, String.class).get(0) : null)
                    .aliases(getContentOfArray("alias", json, String.class))
                    .open_corporates(getContentOf("open_corporates", json, String.class))
                    .wikipedia(getContentOf("wikipedia", json, String.class))
                    .cik(getContentOf("sec_cik", json, String.class))
                    .os_id(getContentOf("oar_id", json, String.class))
                    .url(getContentOf("url", json, String.class))
                    .updated_at(getContentOf("updated_at", json, String.class))
                    .created_at(getContentOf("created_at", json, String.class))
                    .requested_at(getContentOf("requested_at", json, String.class))
                    .html_url(getContentOf("html_url", json, String.class))
                    .answers_url(getContentOf("answers_url", json, String.class))
                    .rawJson(json)
                    .build();
        } catch (JSONException ex) {
            return new CompanyImpl.Builder()
                    .id(json.getLong("id"))
                    .name(json.getString("name"))
                    .headquarters(getContentOf("headquarters", json, String.class))
                    .aliases(getContentOfArray("alias", json, String.class))
                    .open_corporates(getContentOf("open_corporates", json, String.class))
                    .wikipedia(getContentOf("wikipedia", json, String.class))
                    .cik(getContentOf("sec_cik", json, String.class))
                    .os_id(getContentOf("oar_id", json, String.class))
                    .url(getContentOf("url", json, String.class))
                    .updated_at(getContentOf("updated_at", json, String.class))
                    .created_at(getContentOf("created_at", json, String.class))
                    .requested_at(getContentOf("requested_at", json, String.class))
                    .html_url(getContentOf("html_url", json, String.class))
                    .answers_url(getContentOf("answers_url", json, String.class))
                    .rawJson(json)
                    .build();
        }
    }

    /**
     * Creates a {@link Metric} given the raw json response from the api request
     * @param rawJson
     * @return
     * @throws IncompatibleCardTypeException in case a different Card type is returned
     */
    public static Metric createMetric(String rawJson) throws IncompatibleCardTypeException {
        JSONObject json = new JSONObject(rawJson);

        String card_type = getCardType(json);

        if (!card_type.equals("Metric"))
            throw new IncompatibleCardTypeException("The requested Card is not a Metric but a " + card_type);

        return new MetricImpl.Builder()
                .id(getContentOf("id", json, Long.class))
                .name(getContentOf("name", json, String.class))
                .metric_name(getContentOf("title", json, String.class))
                .metric_designer(getContentOf("designer", json, String.class))
                .metric_type(getContentOf("metric_type", json, String.class))
                .methodology(getContentOf("methodology", json, String.class))
                .about(getContentOf("about", json, String.class))
                .value_type(getContentOf("value_type", json, String.class))
                .value_options(getContentOfArray("value_options", json, String.class))
                .report_type(getContentOf("report_type", json, String.class))
                .research_policy(getContentOf("research_policy", json, String.class))
                .topics(getContentOfArray("topics", json, String.class))
                .formula(getContentOf("formula", json, String.class))
                .variables(getContentOfArray("variables", json, String.class))
                .calculations(getContentOfArray("calculations", json, String.class))
                .question(getContentOf("question", json, String.class))
                .range(getContentOf("range", json, String.class))
                .unit(getContentOf("unit", json, String.class))
                .number_of_answers(getContentOf("answers", json, Integer.class))
                .number_of_bookmarkers(getContentOf("bookmarkers", json, Integer.class))
                .number_of_datasets(getContentOf("datasets", json, Integer.class))
                .number_of_companies(getContentOf("companies", json, Integer.class))
                .url(getContentOf("url", json, String.class))
                .updated_at(getContentOf("updated_at", json, String.class))
                .created_at(getContentOf("created_at", json, String.class))
                .requested_at(getContentOf("requested_at", json, String.class))
                .html_url(getContentOf("html_url", json, String.class))
                .answers_url(getContentOf("answers_url", json, String.class))
                .rawJson(json)
                .build();
    }

    /**
     * Creates a {@link Source} given the raw json response from the api request
     * @param rawJson
     * @return
     * @throws IncompatibleCardTypeException in case a different Card type is returned
     */
    public static Source createSource(String rawJson) throws IncompatibleCardTypeException {
        JSONObject json = new JSONObject(rawJson);

        String card_type = getCardType(json);

        if (!card_type.equals("Source"))
            throw new IncompatibleCardTypeException("The requested Card is not a Source but a " + card_type);


        return new SourceImpl.Builder()
                .id(json.getLong("id"))
                .name(json.getString("name"))
                .url(getContentOf("url", json, String.class))
                .html_url(getContentOf("html_url", json, String.class))
                .updated_at(getContentOf("updated_at", json, String.class))
                .created_at(getContentOf("created_at", json, String.class))
                .requested_at(getContentOf("requested_at", json, String.class))
                .rawJson(json)
                .title(getContentOf("title", json, String.class))
                .file(getContentOf("file", json, String.class))
                .link(getContentOf("link", json, String.class))
                .description(getContentOf("description", json, String.class))
                .reportTypes(getContentOfArray("report_type", json, String.class))
                .metrics(getContentOfArray("metric", json, String.class))
                .companies(getContentOfArray("company", json, String.class))
                .answers(getContentOfArray("answer", json, String.class))
                .years(getContentOfArray("year", json, Integer.class))
                .build();
    }

    /**
     * Creates a {@link Topic} given the raw json response from the api request
     * @param rawJson
     * @return
     * @throws IncompatibleCardTypeException in case a different Card type is returned
     */
    public static Topic createTopic(String rawJson) throws IncompatibleCardTypeException {
        JSONObject json = new JSONObject(rawJson);
        String card_type = getCardType(json);

        if (!card_type.equals("Topic"))
            throw new IncompatibleCardTypeException("The requested Card is not a Topic but a " + card_type);

        return new TopicImpl.Builder()
                .id(getContentOf("id", json, Long.class))
                .name(getContentOf("name", json, String.class))
                .url(getContentOf("url", json, String.class))
                .html_url(getContentOf("html_url", json, String.class))
                .updated_at(getContentOf("updated_at", json, String.class))
                .created_at(getContentOf("created_at", json, String.class))
                .requested_at(getContentOf("requested_at", json, String.class))
                .rawJson(json)
                .bookmarkers(getContentOf("bookmarkers", json, Integer.class))
                .metrics(getContentOf("metrics", json, Integer.class))
                .datasets(getContentOf("datasets", json, Integer.class))
                .build();
    }

    /**
     * Creates a {@link Dataset} given the raw json response from the api request
     * @param rawJson
     * @return
     * @throws IncompatibleCardTypeException in case a different Card type is returned
     */
    public static Dataset createDataset(String rawJson) throws IncompatibleCardTypeException {
        JSONObject json = new JSONObject(rawJson);
        String card_type = getCardType(json);

        if (!card_type.equals("Data Set"))
            throw new IncompatibleCardTypeException("The requested Card is not a Data Set but a " + card_type);

        return new DatasetImpl.Builder()
                .id(getContentOf("id", json, Long.class))
                .name(getContentOf("name", json, String.class))
                .url(getContentOf("url", json, String.class))
                .html_url(getContentOf("html_url", json, String.class))
                .updated_at(getContentOf("updated_at", json, String.class))
                .created_at(getContentOf("created_at", json, String.class))
                .requested_at(getContentOf("requested_at", json, String.class))
                .rawJson(json)
                .answers(getContentOfArray("items", json, Answer.class))
                .metrics(getContentOfArray("metrics", json, String.class))
                .companies(getContentOfArray("companies", json, String.class))
                .license(getContentOf("license", json, String.class))
                .build();
    }

    /**
     * Creates a {@link CompanyGroup} given the raw json response from the api request
     * @param rawJson
     * @return
     * @throws IncompatibleCardTypeException in case a different Card type is returned
     */
    public static CompanyGroup createCompanyGroup(String rawJson) throws IncompatibleCardTypeException {
        JSONObject json = new JSONObject(rawJson);
        String card_type = getCardType(json);

        if (!card_type.equals("Company Group"))
            throw new IncompatibleCardTypeException("The requested Card is not a Company Group but a " + card_type);

        return new CompanyGroupImpl.Builder()
                .id(json.getLong("id"))
                .name(getContentOf("name", json, String.class))
                .url(getContentOf("url", json, String.class))
                .html_url(getContentOf("html_url", json, String.class))
                .updated_at(getContentOf("updated_at", json, String.class))
                .created_at(getContentOf("created_at", json, String.class))
                .requested_at(getContentOf("requested_at", json, String.class))
                .rawJson(json)
                .companies(getContentOfArray("companies", json, String.class))
                .links(getContentOfArray("links", json, String.class))
                .specification(getContentOf("specification", json, String.class))
                .build();
    }

    /**
     * Creates a {@link ResearchGroup} given the raw json response from the api request
     * @param rawJson
     * @return
     * @throws IncompatibleCardTypeException in case a different Card type is returned
     */
    public static ResearchGroup createResearchGroup(String rawJson) throws IncompatibleCardTypeException {
        JSONObject json = new JSONObject(rawJson);
        String card_type = getCardType(json);

        if (!card_type.equals("Research Group"))
            throw new IncompatibleCardTypeException("The requested Card is not a Research Group but a " + card_type);

        return new ResearchGroupImpl.Builder()
                .id(json.getLong("id"))
                .name(getContentOf("name", json, String.class))
                .url(getContentOf("url", json, String.class))
                .html_url(getContentOf("html_url", json, String.class))
                .updated_at(getContentOf("updated_at", json, String.class))
                .created_at(getContentOf("created_at", json, String.class))
                .requested_at(getContentOf("requested_at", json, String.class))
                .rawJson(json)
                .researchers(getContentOfArray("researchers", json, String.class))
                .build();
    }

    /**
     * Creates a {@link Company} given the raw json response from the api request
     * @param rawJson
     * @return
     * @throws IncompatibleCardTypeException in case a different Card type is returned
     */
    public static Answer createAnswer(String rawJson) throws IncompatibleCardTypeException {
        JSONObject json = new JSONObject(rawJson);
        String card_type = getCardType(json);

        if (!card_type.equals("Answer"))
            throw new IncompatibleCardTypeException("The requested Card is not a Answer but a " + card_type);

        return new AnswerImpl.Builder()
                .company(getContentOf("company", json, String.class))
                .year(getContentOf("year", json, Integer.class))
                .value(getContentOf("value", json, String.class))
                .comments(getContentOf("comments", json, String.class))
                .recordUrl(getContentOf("record_url", json, String.class))
                .metricDesigner(json.getString("metric").split("\\+")[0])
                .metricName(json.getString("metric").split("\\+")[1])
                .sources(getContentOfArray("sources", json, Source.class))
                .id(getContentOf("id", json, Long.class))
                .name(getContentOf("name", json, String.class))
                .url(getContentOf("url", json, String.class))
                .html_url(getContentOf("html_url", json, String.class))
                .updated_at(getContentOf("updated_at", json, String.class))
                .created_at(getContentOf("created_at", json, String.class))
                .requested_at(getContentOf("requested_at", json, String.class))
                .rawJson(json)
                .build();
    }

    /**
     * Creates a {@link RelationshipAnswer} given the raw json response from the api request
     * @param rawJson
     * @return
     * @throws IncompatibleCardTypeException in case a different Card type is returned
     */
    public static RelationshipAnswer createRelationshipAnswer(String rawJson) throws IncompatibleCardTypeException {
        JSONObject json = new JSONObject(rawJson);
        String card_type = getCardType(json);

        if (!card_type.equals("Relationship Answer"))
            throw new IncompatibleCardTypeException("The requested Card is not a Relationship Answer but a " + card_type);

        return new RelationshipAnswerImpl.Builder()
                .id(json.getLong("id"))
                .name(getContentOf("name", json, String.class))
                .url(getContentOf("url", json, String.class))
                .html_url(getContentOf("html_url", json, String.class))
                .updated_at(getContentOf("updated_at", json, String.class))
                .created_at(getContentOf("created_at", json, String.class))
                .requested_at(getContentOf("requested_at", json, String.class))
                .rawJson(json)
                .metric_id(getContentOf("metric_id", json, Long.class))
                .inverse_metric_id(getContentOf("inverse_metric_id", json, Long.class))
                .subject_company(json.get("subject_company") instanceof String ?
                        getContentOf("subject_company", json, String.class) :
                        getContentOf("name", json.getJSONObject("subject_company"), String.class))
                .subject_company_id(getContentOf("subject_company_id", json, Long.class))
                .object_company(json.get("object_company") instanceof String ?
                        getContentOf("object_company", json, String.class) :
                        getContentOf("name", json.getJSONObject("object_company"), String.class))
                .object_company_id(getContentOf("object_company_id", json, Long.class))
                .year(getContentOf("year", json, Integer.class))
                .value(getContentOf("value", json, String.class))
                .comments(json.getString("comments"))
                .recordUrl(getContentOf("record_url", json, String.class))
                .sources(getContentOfArray("sources", json, Source.class))
                .checkedBy(getContentOf("checked_by", json, CheckedBy.class))
                .build();
    }

    /**
     * Creates a {@link Region} given the raw json response from the api request
     * @param rawJson
     * @return
     * @throws IncompatibleCardTypeException in case a different Card type is returned
     */
    public static Region createRegion(String rawJson) throws IncompatibleCardTypeException {
        JSONObject json = new JSONObject(rawJson);
        String card_type = getCardType(json);

        if (!card_type.equals("Region"))
            throw new IncompatibleCardTypeException("The requested Card is not a Region but a " + card_type);

        String ilo_region = null;
        String country = null;
        String jurisdiction_key = null;

        if (json.get("type") instanceof JSONObject) {
            JSONArray items = json.getJSONArray("items");
            jurisdiction_key = items.getJSONObject(1).getString("content");
            ilo_region = items.getJSONObject(2).getString("content");
            country = items.getJSONObject(3).getJSONArray("content").getString(0);
        }

        return new RegionImpl.Builder()
                .id(getContentOf("id", json, Long.class))
                .name(json.getString("name"))
                .url(getContentOf("url", json, String.class))
                .html_url(getContentOf("html_url", json, String.class))
                .updated_at(getContentOf("updated_at", json, String.class))
                .created_at(getContentOf("created_at", json, String.class))
                .requested_at(getContentOf("requested_at", json, String.class))
                .rawJson(json)
                .ILORegion(ilo_region)
                .jurisdiction_key(jurisdiction_key)
                .country(country)
                .build();
    }

    /**
     * Creates a {@link CheckedBy} given the raw json response from the api request
     * @param rawJson
     * @return
     * @throws IncompatibleCardTypeException in case a different Card type is returned
     */
    public static CheckedBy createCheckedBy(String rawJson) throws IncompatibleCardTypeException {
        JSONObject json = new JSONObject(rawJson);
        String card_type = getCardType(json);

        if (!json.getString("name").endsWith("checked by")) {
            throw new IncompatibleCardTypeException("The requested Card is not a Checked By but a " + card_type);
        }
        return new CheckedByImpl.Builder()
                .id(getContentOf("id", json, Long.class))
                .name(json.getString("name"))
                .content(json.get("content"))
                .url(getContentOf("url", json, String.class))
                .html_url(getContentOf("html_url", json, String.class))
                .updated_at(getContentOf("updated_at", json, String.class))
                .created_at(getContentOf("created_at", json, String.class))
                .requested_at(getContentOf("requested_at", json, String.class))
                .rawJson(json)
                .numOfChecks(getContentOf("checks", json, Integer.class))
                .build();
    }

    /**
     * Creates a {@link Card} given the raw json response from the api request
     * @param rawJson
     * @return
     */
    public static Card createCard(String rawJson) {
        JSONObject json = new JSONObject(rawJson);
        return new CardImpl.Builder()
                .id(json.getLong("id"))
                .name(getContentOf("name", json, String.class))
                .url(getContentOf("url", json, String.class))
                .html_url(getContentOf("html_url", json, String.class))
                .updated_at(getContentOf("updated_at", json, String.class))
                .created_at(getContentOf("created_at", json, String.class))
                .requested_at(getContentOf("requested_at", json, String.class))
                .content(json.isNull("content") ? null : json.get("content"))
                .rawJson(json)

                .build();
    }

    private static <T> List<T> getContentOfArray(String field, JSONObject json, Class<T> classType) {
        if (json.isNull(field) || json.get(field).equals(""))
            return null;
        else if (json.get(field) instanceof JSONArray)
            if (classType.equals(Integer.class))
                return (List<T>) json.getJSONArray(field).toList().stream().map(x -> Integer.parseInt((String) x)).collect(Collectors.toList());
            else if (classType.equals(Long.class))
                return (List<T>) json.getJSONArray(field).toList().stream().map(x -> Long.parseLong((String) x)).collect(Collectors.toList());
            else if (classType.equals(Double.class))
                return (List<T>) json.getJSONArray(field).toList().stream().map(x -> Double.parseDouble((String) x)).collect(Collectors.toList());
            else if (classType.equals(Source.class)) {
                List<Source> sources = new ArrayList<>();
                for (int i = 0; i < json.getJSONArray(field).length(); i++) {
                    try {
                        sources.add(createSource(json.getJSONArray(field).getJSONObject(i).toString()));
                    } catch (IncompatibleCardTypeException e) {
                        throw new RuntimeException(e);
                    }
                }
                return (List<T>) sources;
            } else if (classType.equals(Answer.class)) {
                List<Answer> answers = new ArrayList<>();
                for (int i = 0; i < json.getJSONArray(field).length(); i++) {
                    try {
                        answers.add(createAnswer(json.getJSONArray(field).getJSONObject(i).toString()));
                    } catch (IncompatibleCardTypeException e) {
                        throw new RuntimeException(e);
                    }
                }
                return (List<T>) answers;
            } else
                return (List<T>) json.getJSONArray(field).toList().stream().map(x -> x.toString()).collect(Collectors.toList());
        else if (json.get(field) instanceof String) {
            JSONObject values = new JSONObject(json.getString(field));
            List<String> options = new ArrayList<>();
            for (String key : values.keySet()) {
                options.add(key);
            }
            return (List<T>) options;
        } else if (classType.equals(Integer.class))
            return json.getJSONObject(field).isNull("content") ? null : (List<T>) json.getJSONObject(field).getJSONArray("content").toList().stream().map(x -> Integer.parseInt((String) x)).collect(Collectors.toList());
        else if (classType.equals(Long.class))
            return json.getJSONObject(field).isNull("content") ? null : (List<T>) json.getJSONObject(field).getJSONArray("content").toList().stream().map(x -> Long.parseLong((String) x)).collect(Collectors.toList());
        else if (classType.equals(Double.class))
            return json.getJSONObject(field).isNull("content") ? null : (List<T>) json.getJSONObject(field).getJSONArray("content").toList().stream().map(x -> Double.parseDouble((String) x)).collect(Collectors.toList());
        else
            return json.getJSONObject(field).isNull("content") ? null : (List<T>) json.getJSONObject(field).getJSONArray("content").toList().stream().map(x -> x.toString()).collect(Collectors.toList());

    }

    private static <T> T getContentOf(String field, JSONObject json, Class<T> classType) {
        if (json.isNull(field)) {
            return null;
        } else if (json.get(field) instanceof JSONObject)
            if (classType.equals(CheckedBy.class)) {
                try {
                    return (T) createCheckedBy(json.getJSONObject(field).toString());
                } catch (IncompatibleCardTypeException e) {
                    throw new RuntimeException(e);
                }
            } else if (classType.equals(Company.class)) {
                try {
                    return (T) createCompany(json.getJSONObject(field).toString());
                } catch (IncompatibleCardTypeException e) {
                    throw new RuntimeException(e);
                }
            } else if (classType.equals(Long.class)) {
                return json.getJSONObject(field).isNull("content") ? null : classType.cast(json.getJSONObject(field).getLong("content"));
            } else
                return json.getJSONObject(field).isNull("content") ? null : classType.cast(json.getJSONObject(field).get("content"));
        if (classType.equals(Long.class)) {
            return classType.cast(json.getLong(field));
        }
        return classType.cast(json.get(field));
    }

    private static String getCardType(JSONObject json) {
        if (json.get("type") instanceof String) {
            return json.getString("type");
        } else {
            return json.getJSONObject("type").getString("name");
        }
    }
}
