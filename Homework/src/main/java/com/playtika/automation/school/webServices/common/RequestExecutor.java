package com.playtika.automation.school.webServices.common;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RequestExecutor {
    private CloseableHttpClient client;

    public RequestExecutor() {
        client = HttpClients.createDefault();
    }

    public void close() throws IOException {
        client.close();
    }

    public CloseableHttpResponse httpDelete(String uri, Map<String, String> headers) throws IOException {
        HttpDelete httpDelete = new HttpDelete(uri);
        return executeCall(httpDelete, headers);
    }

    public CloseableHttpResponse httpPut(String uri, String json, Map<String, String> headers) throws IOException {
        HttpPut httpPut = new HttpPut(uri);
        StringEntity entity = new StringEntity(json);
        httpPut.setEntity(entity);
        return executeCall(httpPut, headers);
    }

    public CloseableHttpResponse httpGet(String uri, Map<String, String> headers) throws IOException {
        HttpGet httpGet = new HttpGet(uri);
        return executeCall(httpGet, headers);
    }

    public CloseableHttpResponse httpPost(String uri, String json, Map<String, String> headers) throws IOException {
        HttpPost httpPost = new HttpPost(uri);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        return executeCall(httpPost, headers);
    }

    private CloseableHttpResponse executeCall(HttpRequestBase method, Map<String, String> headers) throws IOException {
        for (String i : headers.keySet()) {
            method.setHeader(i, headers.get(i));
        }
        return client.execute(method);
    }

    public void printResponseStatus(CloseableHttpResponse response) {
        System.out.println(response.getStatusLine().getStatusCode());
    }
}