package it.marczuk.pracadomowa_tydzien8_2.service;

import it.marczuk.pracadomowa_tydzien8_2.model.Note;
import it.marczuk.pracadomowa_tydzien8_2.repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepo repo;

    @Autowired
    public NoteServiceImpl(NoteRepo repo) {
        this.repo = repo;
    }

    @Override
    public void addNote(Note note) {
        repo.save(note);
    }

    @Override
    public List<Note> getNoteByTitle(String title) {
        return repo.findNotesByTitle(title);
    }

    @Override
    public void updateNote(long id, Note newNote) {
        Note note = repo.findNoteById(id);
        note.setTitle(newNote.getTitle());
        note.setNoteSource(newNote.getNoteSource());
        repo.save(note);
    }
}
