package com.playtika.automation.school.webServices.common;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.playtika.automation.school.webServices.models.Note;
import com.playtika.automation.school.webServices.models.Token;

public class JsonParser {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Token getToken(String content) throws IOException {
        return objectMapper.readValue(content, Token.class);
    }

    public static List<Note> getNotes(String content) throws IOException {
        return objectMapper.readValue(content, new TypeReference<List<Note>>() {
        });
    }

    public static Note getNote(String content) throws IOException {
        return objectMapper.readValue(content, Note.class);
    }
}