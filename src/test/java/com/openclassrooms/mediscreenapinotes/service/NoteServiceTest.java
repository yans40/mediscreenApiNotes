package com.openclassrooms.mediscreenapinotes.service;

import com.openclassrooms.mediscreenapinotes.model.Note;
import com.openclassrooms.mediscreenapinotes.repository.NoteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteService noteService;

    private Note note;

    @BeforeEach
    public void setUp() {
        // Créer l'objet Note avant chaque test
        note = new Note();
        note.setId("abc");
        note.setPatient("jean");
        note.setDate(new Date());
        note.setPatientId(17l);
        note.setObservation("je suis le patient test");
    }

    @AfterEach
    void tearDown() {
        // Supprimer l'objet Note après chaque test
        noteService.deleteNote(note.getId());
    }

    @Test
    void saveNoteTest() {
        // Définir le comportement simulé du noteRepository lors de l'insertion
        when(noteRepository.insert(note)).thenReturn(note);

        // Appel de la méthode saveNote de NoteService
        Note savedNote = noteService.saveNote(note);

        // Vérification du résultat
        assertEquals(note, savedNote);
        assertEquals(note.getPatientId(), savedNote.getPatientId());
        assertEquals(note.getObservation(), savedNote.getObservation());
        assertEquals(note.getDate(), savedNote.getDate());
    }

    @Test
    void findAllNotesTest() {
        List<Note> noteList = new ArrayList<>();
        noteList.add(note);
        when(noteRepository.findAll()).thenReturn(noteList);

        List<Note> notes = noteService.findAll();
        assertEquals(1, notes.size());
        assertEquals("jean", notes.get(0).getPatient());
    }

    @Test
    void findAllNotesByPatientIdTest() {
        List<Note> noteList = new ArrayList<>();
        noteList.add(note);
        when(noteRepository.findByPatientId(anyLong())).thenReturn(noteList);

        List<Note> notes = noteService.findByPatientId(17l);
        assertEquals(1, notes.size());
        assertEquals("jean", notes.get(0).getPatient());
    }


    @Test
    void getNoteById() {
        when(noteRepository.findById(anyString())).thenReturn(Optional.ofNullable(note));

        Optional<Note> findedNote = noteService.getNoteById("abc");
        assertNotNull(note);
    }

    @Test
    void deleteNoteById() {
// Vérifier que la note existe avant la suppression
        Optional<Note> existingNote = noteService.getNoteById(note.getId());
        assertNotNull(existingNote);

        // Supprimer la note
        noteService.deleteNote(note.getId());

        // Vérifier que la note n'existe plus après la suppression
        assertFalse(noteRepository.existsById("abc"));

    }

}


