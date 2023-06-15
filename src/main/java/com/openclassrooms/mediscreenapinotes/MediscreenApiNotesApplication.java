package com.openclassrooms.mediscreenapinotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.openclassrooms.mediscreenapinotes.service")
public class MediscreenApiNotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediscreenApiNotesApplication.class, args);
    }

}
