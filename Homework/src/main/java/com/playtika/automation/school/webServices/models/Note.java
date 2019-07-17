package com.playtika.automation.school.webServices.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Note {

    private int id;
    private String content;
    private String createdAt;
    private String modifiedAt;
    private int version;

    public int getId() {
        return id;
    }
}