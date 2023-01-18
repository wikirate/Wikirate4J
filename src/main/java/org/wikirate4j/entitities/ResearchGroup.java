package org.wikirate4j.entitities;

import java.util.List;

/**
 * Research Groups are a collection of WikiRate contributors, their Research Projects, and Metrics they created.
 * ResearchGroup entity extends the notion of a {@link Card} to provide additional information and functionality.
 *
 * @author Vasiliki Gkatziaki
 */
public interface ResearchGroup extends Card {

    List<String> getResearchers();
}
