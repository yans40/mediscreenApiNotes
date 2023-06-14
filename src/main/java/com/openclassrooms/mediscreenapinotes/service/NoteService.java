package com.openclassrooms.mediscreenapinotes.service;

import com.openclassrooms.mediscreenapinotes.model.Note;
import com.openclassrooms.mediscreenapinotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public Note savePost(Note note) {
        return noteRepository.insert(note);
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(String id) {
        return noteRepository.findById(id);
    }

    public List<Note> findByPatientId(Long id) {
        return noteRepository.findByPatientId(id);
    }
    public void deleteNote(String id) {
        noteRepository.deleteById(id);
    }
}
