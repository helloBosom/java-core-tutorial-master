package com.logic.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class HttpClientService {
    private static final Logger log = LoggerFactory.getLogger(HttpClientService.class);

    private final HttpClient httpClient = HttpClientBuilder.create().build();

    private HttpClientService() {
    }

    public static HttpClientService newInstance() {
        return new HttpClientService();
    }

    public void post(String url, ContentType contentType, Object reqBody) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(buildHttpEntity(contentType, reqBody));
        try {
            log.debug("HttpClient sent a msg: [{}]", String.valueOf(reqBody));
            HttpResponse response = httpClient.execute(httpPost);
            log.debug("HttpClient received a msg: [{}], the request body is [{}]",
                    EntityUtils.toString(response.getEntity()),
                    String.valueOf(reqBody));
        } catch (IOException e) {
            log.error("Failed to send msg, the request url is {}, the request body is {}",
                    url, String.valueOf(reqBody), e);
        }
    }

    private HttpEntity buildHttpEntity(ContentType contentType, Object reqBody) {
        try {
            switch (contentType) {
                case APPLICATION_JSON:
                    return buildJsonEntity((String) reqBody);
                case APPLICATION_XML:
                    return buildXmlEntity((String) reqBody);
                case FORM_URLENCOED:
                    return buildUrlencodedEntity((Map<String, ?>) reqBody);
                default:
                    log.error("Not supported content type: {}", contentType.name());
                    return null;
            }
        } catch (ClassCastException e) {
            log.error("Not supported request body: {}", reqBody.getClass());
            return null;
        }
    }

    private HttpEntity buildUrlencodedEntity(Map<String, ?> reqBody) {
        if (reqBody == null || reqBody.isEmpty()) {
            return null;
        }
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(reqBody.size());
        for (Entry<String, ?> entry : reqBody.entrySet()) {
            nameValuePair.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
        }
        try {
            return new UrlEncodedFormEntity(nameValuePair, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("Failed to build urlencoded entity", e);
            return null;
        }
    }

    private HttpEntity buildJsonEntity(String reqBody) {
        return new StringEntity(reqBody, org.apache.http.entity.ContentType.APPLICATION_JSON);
    }

    private HttpEntity buildXmlEntity(String reqBody) {
        return new StringEntity(reqBody, org.apache.http.entity.ContentType.create("application/xml", "UTF-8"));
    }

    public static enum ContentType {
        APPLICATION_JSON, APPLICATION_XML, FORM_URLENCOED
    }
}
