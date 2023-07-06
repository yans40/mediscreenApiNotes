package com.openclassrooms.mediscreenapinotes.controller;

import com.openclassrooms.mediscreenapinotes.model.Note;
import com.openclassrooms.mediscreenapinotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiNote")
public class NoteController {
   @Autowired
   NoteService noteService;


    @PostMapping("/notes")
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note createdNote = noteService.saveNote(note);
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

    @GetMapping("/notesList/{patientId}")
    public ResponseEntity<List<Note>> getNotesByPatientId(@PathVariable("patientId") Long patientId) {
        List<Note> notes = noteService.findByPatientId(patientId);
        if (notes.isEmpty()) {
            // Si aucune note n'est trouvée, vous pouvez renvoyer une réponse avec un code HTTP approprié (par exemple, 404 - Not Found, no content)
            return ResponseEntity.noContent().build();
        } else {
            // Si des notes sont trouvées, vous pouvez renvoyer la liste de notes dans la réponse avec un code HTTP 200 - OK
            return ResponseEntity.ok(notes);
        }
    }
    @PutMapping("/notes/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable String id, @RequestBody Note updatedNote) {
        Optional<Note> optionalNote = noteService.getNoteById(id);
        if (optionalNote.isPresent()) {
            Note existingNote = optionalNote.get();
            existingNote.setPatientId(updatedNote.getPatientId());
            existingNote.setObservation(updatedNote.getObservation());

             noteService.update(existingNote); // Sauvegarde dans la base de données MongoDB

            return new ResponseEntity<>(updatedNote, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable String id) {
        noteService.deleteNote(id);
    }
}
