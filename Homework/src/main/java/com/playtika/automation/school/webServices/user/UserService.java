package com.playtika.automation.school.webServices.user;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import com.playtika.automation.school.webServices.common.Helper;
import com.playtika.automation.school.webServices.constant.Endpoint;

public class UserService {

    public void createUserAccount(User user) throws ClientProtocolException, IOException {
        System.out.println("CREATE USER:");
        String uri = Endpoint.CREATE_USER.getUrl();
        String json = "{\"email\":\"" + user.getEmail() + "\",\"password\":\"" + user.getPassword() + "\"}";
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-type", "application/json");
        CloseableHttpResponse response = Helper.httpPost(uri, json, headers);
        Helper.printResponseStatus(response);
    }

    public void requestForToken(User user) throws ClientProtocolException, IOException {
        System.out.println("GET USER'S TOKEN:");
        String uri = Endpoint.GET_TOKEN.getUrl();
        String json = "grant_type=password&username=" + user.getEmail() + "&password=" + user.getPassword();
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Basic Y2xpZW50OnNlY3JldA==");
        headers.put("Content-type", "application/x-www-form-urlencoded");
        CloseableHttpResponse response = Helper.httpPost(uri, json, headers);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        Helper.printResponseStatus(response);
        System.out.println(content);
        ObjectMapper objectMapper = new ObjectMapper();
        Token token = objectMapper.readValue(content, Token.class);
        user.setToken(token.access_token);
    }
}