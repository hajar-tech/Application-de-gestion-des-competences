package com.enaaproject.enaaskills.services.interfaceServices;

import com.enaaproject.enaaskills.dtos.CompetenceDto;
import com.enaaproject.enaaskills.dtos.SousCompetenceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompetenceServiceTest {

    @Autowired
    CompetenceService competenceService;
    @Test
    void createCompetence() {
        SousCompetenceDto sousDto = new SousCompetenceDto(1L, "Programmation orientée objet", "EN_ATTENTE");

        CompetenceDto dto = new CompetenceDto(
                10L,
                "C001",
                "Développement Java",
                "EN_ATTENTE",
                List.of(sousDto)
        );

        CompetenceDto saveCompetenceDto = competenceService.createCompetence(dto);

        assertNotNull(saveCompetenceDto.id());
        assertEquals("C001" , saveCompetenceDto.code());
    }

    @Test
    void getAllCompetences() {
    }

    @Test
    void updateCompetence() {
    }

    @Test
    void getCompetenceById() {
    }

    @Test
    void deleteCompetence() {
    }

    @Test
    void validerAutomatiquementCompetence() {
    }
}