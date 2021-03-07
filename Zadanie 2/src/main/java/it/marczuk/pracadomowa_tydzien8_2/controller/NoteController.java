package it.marczuk.pracadomowa_tydzien8_2.controller;

import it.marczuk.pracadomowa_tydzien8_2.model.Note;
import it.marczuk.pracadomowa_tydzien8_2.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {

    private NoteService service;

    @Autowired
    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping("/note")
    public String getMainPage(Model model) {
        model.addAttribute("newNote", new Note());
        return "index";
    }

    @GetMapping("/yournote")
    public String getYourNote(@RequestParam(value = "title") String title, Model model) {
        model.addAttribute("noteList", service.getNoteByTitle(title));
        model.addAttribute("newNote", new Note());
        return "note";
    }

    @GetMapping("/add")
    public String getAddPage(Model model) {
        model.addAttribute("newNote", new Note());
        return "add";
    }

    @PostMapping("/addnote")
    public String addNote(@ModelAttribute Note newNote) {
        service.addNote(newNote);
        return "redirect:/add";
    }

    @PostMapping("/edit/{id}")
    public String editNote(@PathVariable long id, @ModelAttribute Note newNote, Model model) {
        model.addAttribute("newNote", new Note());
        service.updateNote(id, newNote);
        return "redirect:/yournote?title=" + newNote.getTitle();
    }
}
