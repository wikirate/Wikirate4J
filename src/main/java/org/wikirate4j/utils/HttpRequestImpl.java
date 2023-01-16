package org.wikirate4j.utils;

import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.wikirate4j.exceptions.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

/**
 * @author Vasiliki Gkatziaki
 */
public class HttpRequestImpl implements HttpRequest {

    private static final Logger LOG =
            getLogger(HttpRequest.class.getName());


    private String response;
    private int statusCode;

    private String host;

    private String endpoint;

    private HttpRequestImpl(Builder builder) {
        this.response = builder.response;
        this.statusCode = builder.statusCode;
        this.host = builder.host;
        this.endpoint = builder.endpoint;
    }

    @Override
    public String getResponse() {
        return response;
    }

    @Override
    public JSONObject getJSONResponse() {
        return new JSONObject(response);
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public String getEndpoint() {
        return endpoint;
    }


    /**
     * Builder for new instances of {@link HttpRequest}
     */
    public static class Builder {
        private final CloseableHttpClient httpClient = HttpClients.createDefault();
        private String host;

        private String endpoint;

        private String response;

        private int statusCode;
        private List<NameValuePair> requestParameters;
        private HashMap<String, String> headers;

        private UsernamePasswordCredentials credentials;

        public Builder(String host) {
            this.host = host;
            this.headers = new HashMap();
            this.requestParameters = new ArrayList();
        }

        public Builder endpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        public Builder addHeader(String name, String value) {
            if (value != null)
                headers.put(name, value);
            return this;
        }

        public Builder addParameter(String name, String value) {
            if (value != null)
                requestParameters.add(new BasicNameValuePair(name, value));
            return this;
        }

        public Builder filters(List<NameValuePair> filters) {
            requestParameters.addAll(filters);
            return this;
        }

        public Builder parameters(HashMap<String, String> parms) {
            for (Map.Entry<String, String> entry : parms.entrySet()) {
                requestParameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            return this;
        }

        public Builder auth(String username, String password) {
            if (username != null && password != null)
                this.credentials = new UsernamePasswordCredentials(username, password);
            return this;
        }


        /**
         * Builds and executes a GET http request and returns a new instance of {@link HttpRequest}
         *
         * @return
         * @throws IOException
         * @throws URISyntaxException
         * @throws AuthenticationException
         * @throws HTTPException
         */
        public HttpRequest GET() throws IOException, URISyntaxException, AuthenticationException, HTTPException {

            URIBuilder uriBuilder = new URIBuilder();
            URI uri = uriBuilder.setScheme("https")
                    .setHost(host)
                    .setPath(endpoint)
                    .addParameters(requestParameters).build();
            HttpGet get = new HttpGet(uri);

            if (credentials != null)
                get.addHeader(new BasicScheme().authenticate(credentials, get, null));

            get.setConfig(
                    RequestConfig
                            .custom()
                            .setConnectionRequestTimeout(120000)
                            .build()
            );

            for (Map.Entry<String, String> header : headers.entrySet()) {
                get.addHeader(header.getKey(), header.getValue());
            }
            LOG.info(toString());
            LOG.info(requestParameters.toString());
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(get);
            response = EntityUtils.toString(closeableHttpResponse.getEntity());
            statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            if (statusCode == 400)
                throw new BadRequestException(response);
            else if (statusCode == 401)
                throw new UnauthorizedException(response);
            else if (statusCode == 403)
                throw new ForbiddenException(response);
            else if (statusCode == 404)
                throw new NotFoundException(response);
            else if (statusCode == 429)
                throw new TooManyRequestsException(response);
            else if (statusCode == 500)
                throw new WikiRateServerErrorException(response);
            else if (statusCode != 200)
                throw new HTTPException(response);
            return new HttpRequestImpl(this);
        }

        /**
         * Builds and executes a POST http request and returns a new instance of {@link HttpRequest}
         *
         * @return
         * @throws IOException
         * @throws URISyntaxException
         * @throws AuthenticationException
         * @throws HTTPException
         */
        public HttpRequest POST() throws IOException, URISyntaxException, AuthenticationException, HTTPException {
            URIBuilder uriBuilder = new URIBuilder();
            URI uri = uriBuilder.setScheme("https")
                    .setHost(host)
                    .setPath(endpoint)
                    .addParameters(requestParameters).build();
            HttpPost post = new HttpPost(uri);

            if (credentials != null)
                post.addHeader(new BasicScheme().authenticate(credentials, post, null));

            post.setConfig(
                    RequestConfig
                            .custom()
                            .setConnectionRequestTimeout(120000)
                            .build()
            );

            for (Map.Entry<String, String> header : headers.entrySet()) {
                post.addHeader(header.getKey(), header.getValue());
            }
            LOG.info(requestParameters.toString().replace("\n", ", "));
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(post);
            response = EntityUtils.toString(closeableHttpResponse.getEntity());
            statusCode = closeableHttpResponse.getStatusLine().getStatusCode();

            if (statusCode == 400)
                throw new BadRequestException(response);
            else if (statusCode == 401)
                throw new UnauthorizedException(response);
            else if (statusCode == 403)
                throw new ForbiddenException(response);
            else if (statusCode == 404)
                throw new NotFoundException(response);
            else if (statusCode == 429)
                throw new TooManyRequestsException(response);
            else if (statusCode == 500)
                throw new WikiRateServerErrorException(response);
            else if (statusCode != 200)
                throw new HTTPException(response);

            return new HttpRequestImpl(this);
        }
    }

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }
}
