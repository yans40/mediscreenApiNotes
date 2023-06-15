package com.openclassrooms.mediscreenapinotes.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notes")
public class Note {
    @Id
    private String id;
    private Long patientId;
    private String patient;
    @NotNull(message = "L'observation ne peut pas être vide")
    private String observation;
    private Date date;
}
