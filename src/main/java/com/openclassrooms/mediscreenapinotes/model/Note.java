package com.openclassrooms.mediscreenapinotes.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "notes")
public class Note {
    @Id
    private String id;
    private Long patientId;
    private String patient;
    private String notes;
    private Date date;
}
