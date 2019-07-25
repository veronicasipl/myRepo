package com.playtika.automation.school.webServices.constant;

public enum Endpoint {

    CREATE_USER("https://taschool-notes-service.herokuapp.com/v1/accounts"),
    GET_TOKEN("https://taschool-notes-service.herokuapp.com/oauth/token"),
    GET_NOTES("https://taschool-notes-service.herokuapp.com/v1/notes");

    private String url;

    Endpoint(String envUrl) {
        this.url = envUrl;
    }

    public String getUrl() {
        return url;
    }
}