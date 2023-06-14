package com.openclassrooms.mediscreenapinotes.repository;

import com.openclassrooms.mediscreenapinotes.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends MongoRepository<Note,String> {
    List<Note> findByPatientId(Long patientId);
}
