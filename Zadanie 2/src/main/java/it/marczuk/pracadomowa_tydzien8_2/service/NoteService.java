package it.marczuk.pracadomowa_tydzien8_2.service;

import it.marczuk.pracadomowa_tydzien8_2.model.Note;

import java.util.List;

public interface NoteService {

    void addNote(Note note);

    List<Note> getNoteByTitle(String title);

    void updateNote(long id, Note newNote);
}
