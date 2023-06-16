package com.openclassrooms.mediscreenapinotes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.openclassrooms.mediscreenapinotes.model.Note;
import com.openclassrooms.mediscreenapinotes.service.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class NoteControllerTest {
    private final ObjectMapper objectMapper = new ObjectMapper()
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private NoteService noteService;

    @InjectMocks
    private NoteController noteController;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void cleanUpDatabase() {
        mongoTemplate.getDb().drop(); // Supprime toutes les collections de la base de données
    }
    @Test
    public void testCreateNote() throws Exception {
        Note note = new Note();
        note.setId("3");
        note.setPatientId(1L);
        note.setPatient("John Doe");
        note.setObservation("Some observation");
        note.setDate(new Date());

        when(noteService.saveNote(Mockito.any(Note.class))).thenReturn(note);

        mockMvc.perform(post("/apiNote/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(note)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(note.getId()))
                .andExpect(jsonPath("$.patientId").value(note.getPatientId()))
                .andExpect(jsonPath("$.patient").value(note.getPatient()))
                .andExpect(jsonPath("$.observation").value(note.getObservation()));

    }

    @Test
    void testGetAllNotes() {
        // Créer une liste de notes de test
        Note note1 = new Note();
        note1.setId("4");
        note1.setObservation("Observation 4");
        // Initialiser la date avec LocalDate
        note1.setDate(new Date());

        Note note2 = new Note();
        note2.setId("5");
        note2.setObservation("Observation 5");
        note2.setDate(new Date());

        List<Note> notes = Arrays.asList(note1, note2);

        // Définir le comportement attendu du service de notes
        when(noteService.findAll()).thenReturn(notes);

        // Appeler la méthode du contrôleur à tester
        ResponseEntity<List<Note>> response = noteController.getAllNotes();

        // Vérifier le résultat
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(notes, response.getBody());
    }

    @Test
    void testGetNotesById_existingNote() {
        // Préparer les données de test
        String noteId = "1";
        Note note = new Note();
        note.setId(noteId);
        // Définir le comportement attendu du service de notes
        when(noteService.getNoteById(noteId)).thenReturn(Optional.of(note));
        // Appeler la méthode du contrôleur à tester
        ResponseEntity<Note> response = noteController.getNotesById(noteId);
        // Vérifier le résultat
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(note, response.getBody());
    }

    @Test
    void testGetNotesById_nonExistingNote() {
        // Préparer les données de test
        String noteId = "1";
        // Définir le comportement attendu du service de notes
        when(noteService.getNoteById(noteId)).thenReturn(Optional.empty());
        // Appeler la méthode du contrôleur à tester
        ResponseEntity<Note> response = noteController.getNotesById(noteId);
        // Vérifier le résultat
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    void testGetNotesByPatientId_noNotesFound() {
        // Préparer les données de test
        Long patientId = 1L;
        // Définir le comportement attendu du service de notes
        when(noteService.findByPatientId(patientId)).thenReturn(new ArrayList<>());
        // Appeler la méthode du contrôleur à tester
        ResponseEntity<List<Note>> response = noteController.getNotesByPatientId(patientId);
        // Vérifier le résultat
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    void testGetNotesByPatientId_notesFound() {
        // Préparer les données de test
        Long patientId = 1L;
        List<Note> notes = new ArrayList<>();
        notes.add(new Note());
        notes.add(new Note());
        // Définir le comportement attendu du service de notes
        when(noteService.findByPatientId(patientId)).thenReturn(notes);
        // Appeler la méthode du contrôleur à tester
        ResponseEntity<List<Note>> response = noteController.getNotesByPatientId(patientId);
        // Vérifier le résultat
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(notes, response.getBody());
    }

    @Test
    void testDeleteNote() {
        // Préparer les données de test
        String noteId = "1";
        // Appeler la méthode du contrôleur à tester
        noteController.deleteNote(noteId);
        // Vérifier l'appel au service de notes
        verify(noteService).deleteNote(noteId);
    }
}
