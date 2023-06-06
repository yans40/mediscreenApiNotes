package com.openclassrooms.mediscreenapinotes.controller;

import com.openclassrooms.mediscreenapinotes.model.Note;
import com.openclassrooms.mediscreenapinotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiNotes")
public class NoteController {
   @Autowired
   NoteService noteService;


    @PostMapping("/notes")
    public ResponseEntity<Note> createPatient(@RequestBody Note note) {
        Note createdNote = noteService.savePost(note); ;
        return new ResponseEntity<>(createdNote, HttpStatus.CREATED);
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.findAll();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNotesById(@PathVariable String id) {
        Optional<Note> note = noteService.getNoteById(id);
        return note.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable String id) {
        noteService.deleteNote(id);
    }
}
