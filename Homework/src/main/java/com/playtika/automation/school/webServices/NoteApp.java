package com.playtika.automation.school.webServices;

import java.io.IOException;
import java.util.List;

import com.playtika.automation.school.webServices.common.RequestExecutor;
import com.playtika.automation.school.webServices.models.Note;
import com.playtika.automation.school.webServices.user.User;
import com.playtika.automation.school.webServices.user.UserService;

public class NoteApp {

    public static void main(String[] args) throws IOException {
        User user = new User("veron112@yaj.com" + System.nanoTime(), "qwerty");
        RequestExecutor requestExecutor = new RequestExecutor();
        UserService userService = new UserService(user, requestExecutor);
        try {
            userService.createUserAccount();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userService.requestForToken();
        NoteService noteService = new NoteService(user, requestExecutor);

        for (int i = 0; i < 2; i++) {
            noteService.createNote();
        }

        List<Note> notesList = noteService.getAllNotes();
        int randomNoteId = noteService.getRandomNote(notesList).getId();
        Note note = noteService.getNoteById(randomNoteId);
        noteService.updateNote(note);
        noteService.deleteNote(note);
        requestExecutor.close();
    }
}