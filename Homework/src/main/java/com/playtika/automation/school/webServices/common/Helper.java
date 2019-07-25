package com.playtika.automation.school.webServices.common;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Helper {

    private static CloseableHttpClient client;

    public static void createClient() {
        client = HttpClients.createDefault();
    }

    public static void closeClient() throws IOException {
        client.close();
    }

    public static CloseableHttpResponse httpDelete(String uri, HashMap<String, String> headers) throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(uri);
        for (String i : headers.keySet()) {
            httpDelete.setHeader(i, headers.get(i));
        }
        CloseableHttpResponse response = client.execute(httpDelete);
        client.close();
        return response;
    }

    public static CloseableHttpResponse httpPut(String uri, String json, HashMap<String, String> headers) throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(uri);
        StringEntity entity = new StringEntity(json);
        httpPut.setEntity(entity);
        for (String i : headers.keySet()) {
            httpPut.setHeader(i, headers.get(i));
        }
        CloseableHttpResponse response = client.execute(httpPut);
        client.close();
        return response;
    }

    public static CloseableHttpResponse httpGet(String uri, HashMap<String, String> headers) throws ClientProtocolException, IOException {
        HttpGet httpGet = new HttpGet(uri);
        for (String i : headers.keySet()) {
            httpGet.setHeader(i, headers.get(i));
        }
        CloseableHttpResponse response = client.execute(httpGet);
        return response;
    }

    public static CloseableHttpResponse httpPost(String uri, String json, HashMap<String, String> headers) throws ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost(uri);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        for (String i : headers.keySet()) {
            httpPost.setHeader(i, headers.get(i));
        }
        CloseableHttpResponse response = client.execute(httpPost);
        return response;
    }

    public static void printResponseStatus(CloseableHttpResponse response) {
        System.out.println(response.getStatusLine().getStatusCode());
    }
}