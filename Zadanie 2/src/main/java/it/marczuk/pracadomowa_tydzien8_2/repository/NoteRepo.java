package it.marczuk.pracadomowa_tydzien8_2.repository;

import it.marczuk.pracadomowa_tydzien8_2.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {

    List<Note> findNotesByTitle(String title);

    Note findNoteById(long id);
}
