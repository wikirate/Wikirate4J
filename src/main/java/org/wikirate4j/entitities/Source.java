package org.wikirate4j.entitities;

import org.wikirate4j.utils.ReportType;

import java.util.List;

/**
 * A Source is generally a company report, including CSR Report, Sustainability Report, Annual Report or Integrated
 * Report. It could also be a news article, website, conflict mineral report or modern slavery report and so on.
 * A source can be added to WikiRate as a URL or file upload. The Source entity extends the notion of
 * a {@link Card} to provide additional information and functionality.
 *
 * @author Vasiliki Gkatziaki
 */
public interface Source extends Card {

    /**
     * Returns the title of the Source
     *
     * @return the source title
     */
    String getTitle();

    /**
     * Returns the URL of the Source file
     *
     * @return the file url
     */
    String getFile();

    /**
     * Returns the url of the original source
     *
     * @return the url of the original source
     */
    String getLink();

    List<ReportType> getReportTypes();

    /**
     * Lists the years the source referred to.
     *
     * @return a List of years
     */
    List<Integer> getYears();

    /**
     * A given description of the Source
     *
     * @return a description
     */
    String getDescription();

    /**
     * A List of Companies the source is referred to.
     *
     * @return a list of company names
     */
    List<String> getCompanies();

    /**
     * A list of Metrics the source has answers
     *
     * @return a list of metric names
     */
    List<String> getMetrics();

    /**
     * A list of Answers the source is linked to
     *
     * @return a list of answer names
     */
    List<String> getAnswers();
}
