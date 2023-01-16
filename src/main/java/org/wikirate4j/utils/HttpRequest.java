package org.wikirate4j.utils;

import org.json.JSONObject;
/**
 * An interface for HttpRequests
 * @author Vasiliki Gkatziaki
 */
public interface HttpRequest {

    /**
     * Returns the response as a string
     * @return
     */
    String getResponse();

    /**
     * Returns the response as a JSONObject
     * @return
     */
    JSONObject getJSONResponse();

    /**
     * Returns the status code of the request
     * @return
     */
    int getStatusCode();

    /**
     * Returns the host
     * @return
     */
    String getHost();

    /**
     * Returns the endpoint of the request
     * @return
     */
    String getEndpoint();


}
