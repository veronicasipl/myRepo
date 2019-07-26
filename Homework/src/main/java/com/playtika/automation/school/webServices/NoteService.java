package com.playtika.automation.school.webServices;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import com.playtika.automation.school.webServices.common.JsonParser;
import com.playtika.automation.school.webServices.common.RequestExecutor;
import com.playtika.automation.school.webServices.constant.Endpoint;
import com.playtika.automation.school.webServices.models.Note;
import com.playtika.automation.school.webServices.user.User;

public class NoteService {

    private User user;
    private RequestExecutor requestExecutor;

    public NoteService(User user, RequestExecutor requestExecutor) {
        this.user = user;
        this.requestExecutor = requestExecutor;
    }

    public void createNote() throws IOException {
        System.out.println("CREATE NOTE:");
        String uri = Endpoint.GET_NOTES.getUrl();
        String json = "{\"content\":\"test\"}";
        CloseableHttpResponse response = requestExecutor.httpPost(uri, json, getHeaders(user.getToken()));
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity, "UTF-8");
        requestExecutor.printResponseStatus(response);
        response.close();
        System.out.println(content);
    }

    public List<Note> getAllNotes() throws IOException {
        System.out.println("ALL USER'S NOTES:");
        String uri = Endpoint.GET_NOTES.getUrl();
        CloseableHttpResponse response = requestExecutor.httpGet(uri, getHeaders(user.getToken()));
        String content = EntityUtils.toString(response.getEntity());
        requestExecutor.printResponseStatus(response);
        List<Note> notesList = JsonParser.getNotes(content);
        response.close();
        return notesList;
    }

    public Note getNoteById(int id) throws IOException {
        System.out.println("GET NOTE ID: " + id);
        String uri = Endpoint.GET_NOTES.getUrl() + "/" + id;
        CloseableHttpResponse response = requestExecutor.httpGet(uri, getHeaders(user.getToken()));
        String content = EntityUtils.toString(response.getEntity());
        requestExecutor.printResponseStatus(response);
        response.close();
        return JsonParser.getNote(content);
    }

    public void updateNote(Note note) throws IOException {
        System.out.println("UPDATE NOTE ID: " + note.getId());
        String uri = Endpoint.GET_NOTES.getUrl() + "/" + note.getId();
        String json = "{\"content\":\"testnew\"}";
        CloseableHttpResponse response = requestExecutor.httpPut(uri, json, getHeaders(user.getToken()));
        response.close();
        requestExecutor.printResponseStatus(response);
    }

    public void deleteNote(Note note) throws IOException {
        System.out.println("DELETE NOTE: " + note.getId());
        String uri = Endpoint.GET_NOTES.getUrl() + "/" + note.getId();
        CloseableHttpResponse response = requestExecutor.httpDelete(uri, getHeaders(user.getToken()));
        response.close();
        requestExecutor.printResponseStatus(response);
    }

    public Map<String, String> getHeaders(String value) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        headers.put("Authorization", "Bearer" + value);
        return headers;
    }

    public Note getRandomNote(List<Note> notesList) {
        Random r = new Random();
        int randomInt = r.nextInt(notesList.size());
        return notesList.get(randomInt);
    }
}