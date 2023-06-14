package com.openclassrooms.mediscreenapinotes.model;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "L'observation ne peut pas être vide")
    private String observation;
    private Date date;
}
