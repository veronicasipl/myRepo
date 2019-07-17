package com.playtika.automation.school.webServices;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.playtika.automation.school.webServices.common.Helper;
import com.playtika.automation.school.webServices.user.User;
import com.playtika.automation.school.webServices.user.UserService;

public class NoteApp {
    public static void main(String[] args) throws IOException {
        User user = new User("veron112@yaj.com", "qwerty");
        Helper.createClient();
        UserService userService = new UserService();
        try {
            userService.createUserAccount(user);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userService.requestForToken(user);
        NoteService noteService = new NoteService();
        noteService.createNote(user);
        noteService.getAllNotes(user);
        noteService.getNoteById(318, user);
        noteService.updateNote(377, user);
        noteService.deleteNote(395, user);
        Helper.closeClient();
    }
}