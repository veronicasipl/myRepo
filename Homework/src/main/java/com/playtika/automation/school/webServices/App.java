package com.playtika.automation.school.webServices;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class App {
    public static void main(String[] args) throws IOException {
        try {
            createUserAccount();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        requestForToken();
        createNote();
        getAllNotes();
    }

    public static void createUserAccount() throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://taschool-notes-service.herokuapp.com/v1/accounts");
        String json = "{\"email\":\"vero@aa3a.com\",\"password\":\"qwerty\"}";
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = client.execute(httpPost);
        System.out.println(response.getStatusLine().getStatusCode());
        client.close();
    }

    public static void requestForToken() throws ClientProtocolException, IOException {
        CloseableHttpClient client2 = HttpClients.createDefault();
        HttpPost httpPost2 = new HttpPost("https://taschool-notes-service.herokuapp.com/oauth/token");
        String json2 = ("grant_type=password&username=vero@aa3a.com&password=qwerty");
        StringEntity entity2 = new StringEntity(json2);
        httpPost2.setEntity(entity2);
        httpPost2.setHeader("Authorization", "Basic Y2xpZW50OnNlY3JldA==");
        httpPost2.setHeader("Content-type", "application/x-www-form-urlencoded");
        System.out.println(httpPost2);
        CloseableHttpResponse response2 = client2.execute(httpPost2);
        HttpEntity entity = response2.getEntity();
        String content = EntityUtils.toString(entity);
        System.out.println(response2.getStatusLine().getStatusCode());
        System.out.println(content);
        client2.close();
    }

    public static void createNote() throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost3 = new HttpPost("https://taschool-notes-service.herokuapp.com/v1/notes");
        String json = "{\"content\":\"test\"}";
        StringEntity entity = new StringEntity(json);
        httpPost3.setEntity(entity);
        httpPost3.setHeader("Content-type", "application/json");
        httpPost3.setHeader("Authorization", "Bearer" + "25648419-5a05-4300-96c7-b374a930b91f");
        for (int i = 0; i < 2; i++) {
            CloseableHttpResponse response3 = client.execute(httpPost3);
            HttpEntity entity2 = response3.getEntity();
            String content = EntityUtils.toString(entity2);
            System.out.println(response3.getStatusLine().getStatusCode());
            System.out.println(content);
        }
    }

    public static void getAllNotes() throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://taschool-notes-service.herokuapp.com/v1/notes");
        httpGet.setHeader("Accept", "*/*");
        httpGet.setHeader("Content-type", "application/json");
        httpGet.setHeader("Authorization", "Bearer" + "25648419-5a05-4300-96c7-b374a930b91f");
        CloseableHttpResponse response3 = client.execute(httpGet);
        HttpEntity entity2 = response3.getEntity();
        String content = EntityUtils.toString(entity2);
        System.out.println(response3.getStatusLine().getStatusCode());
        System.out.println(content);
    }
}