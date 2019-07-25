package com.playtika.automation.school.webServices;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import com.playtika.automation.school.webServices.common.Helper;
import com.playtika.automation.school.webServices.constant.Endpoint;
import com.playtika.automation.school.webServices.user.User;

public class NoteService {

    public void createNote(User user) throws ClientProtocolException, IOException {
        System.out.println("CREATE NOTE:");
        for (int i = 0; i < 2; i++) {
            String uri = Endpoint.GET_NOTES.getUrl();
            String json = "{\"content\":\"test\"}";
            HashMap<String, String> headers = new HashMap<String, String>();
            headers.put("Content-type", "application/json");
            headers.put("Authorization", "Bearer" + user.getToken());
            CloseableHttpResponse response = Helper.httpPost(uri, json, headers);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity, "UTF-8");
            Helper.printResponseStatus(response);
            System.out.println(content);
        }
    }

    public void getAllNotes(User user) throws ClientProtocolException, IOException {
        System.out.println("ALL USER'S NOTES:");
        String uri = Endpoint.GET_NOTES.getUrl();
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "*/*");
        headers.put("Content-type", "application/json");
        headers.put("Authorization", "Bearer" + user.getToken());
        CloseableHttpResponse response = Helper.httpGet(uri, headers);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        Helper.printResponseStatus(response);
        System.out.println(content);
    }

    public void getNoteById(int id, User user) throws ClientProtocolException, IOException {
        System.out.println("GET NOTE ID 318:");
        String uri = Endpoint.GET_NOTES.getUrl() + "/" + id;
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "*/*");
        headers.put("Content-type", "application/json");
        headers.put("Authorization", "Bearer" + user.getToken());
        CloseableHttpResponse response = Helper.httpGet(uri, headers);
        HttpEntity entity = response.getEntity();
        Helper.printResponseStatus(response);
    }

    public void updateNote(int id, User user) throws ClientProtocolException, IOException {
        System.out.println("UPDATE NOTE ID 377:");
        String uri = Endpoint.GET_NOTES.getUrl() + "/" + id;
        String json = "{\"content\":\"testnew\"}";
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-type", "application/json");
        headers.put("Authorization", "Bearer" + user.getToken());
        CloseableHttpResponse response = Helper.httpPut(uri, json, headers);
        Helper.printResponseStatus(response);
    }

    public void deleteNote(int id, User user) throws ClientProtocolException, IOException {
        System.out.println("DELETE NOTE 395:");
        String uri = Endpoint.GET_NOTES.getUrl() + "/" + id;
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Bearer" + user.getToken());
        CloseableHttpResponse response = Helper.httpDelete(uri, headers);
        Helper.printResponseStatus(response);
    }
}