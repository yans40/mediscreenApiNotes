package com.openclassrooms.mediscreenapinotes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ComponentScan("com.openclassrooms.mediscreenapinotes.service")
class MediscreenApiNotesApplicationTests {


}
