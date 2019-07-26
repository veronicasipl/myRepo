package com.playtika.automation.school.webServices.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import com.playtika.automation.school.webServices.common.JsonParser;
import com.playtika.automation.school.webServices.common.RequestExecutor;
import com.playtika.automation.school.webServices.constant.Endpoint;

public class UserService {

    private User user;
    private RequestExecutor requestExecutor;

    public UserService(User user, RequestExecutor requestExecutor) {
        this.user = user;
        this.requestExecutor = requestExecutor;
    }

    public void createUserAccount() throws IOException {
        System.out.println("CREATE USER:");
        String uri = Endpoint.CREATE_USER.getUrl();
        String json = "{\"email\":\"" + user.getEmail() + "\",\"password\":\"" + user.getPassword() + "\"}";
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-type", "application/json");
        CloseableHttpResponse response = requestExecutor.httpPost(uri, json, headers);
        requestExecutor.printResponseStatus(response);
        response.close();
    }

    public void requestForToken() throws IOException {
        System.out.println("GET USER'S TOKEN:");
        String uri = Endpoint.GET_TOKEN.getUrl();
        String json = "grant_type=password&username=" + user.getEmail() + "&password=" + user.getPassword();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Basic Y2xpZW50OnNlY3JldA==");
        headers.put("Content-type", "application/x-www-form-urlencoded");
        CloseableHttpResponse response = requestExecutor.httpPost(uri, json, headers);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        requestExecutor.printResponseStatus(response);
        System.out.println(content);
        String token = JsonParser.getToken(content).getAccessToken();
        user.setToken(token);
        response.close();
    }
}