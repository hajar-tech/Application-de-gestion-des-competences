package com.enaaproject.enaaskills.services.implimentationServices;

import com.enaaproject.enaaskills.dtos.CompetenceDto;
import com.enaaproject.enaaskills.dtos.SousCompetenceDto;
import com.enaaproject.enaaskills.enums.StatutCompetence;
import com.enaaproject.enaaskills.mappers.CompetenceMapper;
import com.enaaproject.enaaskills.models.Competence;
import com.enaaproject.enaaskills.models.SousCompetences;
import com.enaaproject.enaaskills.repositories.CompetenceRepository;
import com.enaaproject.enaaskills.repositories.SousCompetenceRepository;
import com.enaaproject.enaaskills.services.interfaceServices.CompetenceService;
import jakarta.persistence.Id;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompetenceServiceImplTest {

    @Mock
    private CompetenceRepository competenceRepository;

    @Mock
    private SousCompetenceRepository sousCompetenceRepository;

    @Mock
    private CompetenceMapper competenceMapper;

    @InjectMocks
    private CompetenceServiceImpl competenceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCompetence() {
        // GIVEN
        SousCompetenceDto sousDto = new SousCompetenceDto(1L, "Programmation orientée objet", "EN_ATTENTE");

        CompetenceDto dto = new CompetenceDto(
                10L,
                "C001",
                "Développement Java",
                "EN_ATTENTE",
                List.of(sousDto)
        );

        // THEN
        assertNotNull(dto, "Le DTO ne doit pas être null");
        assertEquals(10L, dto.id());
        assertEquals("C001", dto.code());
        assertEquals("Développement Java", dto.titre());
        assertEquals("EN_ATTENTE", dto.statut());
        assertNotNull(dto.sousCompetences());
        assertEquals(1, dto.sousCompetences().size());

        // Vérification de la sous-compétence
        SousCompetenceDto sc = dto.sousCompetences().get(0);
        assertEquals(1L, sc.id());
        assertEquals("Programmation orientée objet", sc.titre());
        assertEquals("EN_ATTENTE", sc.statut());

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
        // GIVEN
        Long competenceId = 1L;

        // WHEN
        competenceService.deleteCompetence(competenceId);

        // THEN
        verify(competenceRepository, times(1)).deleteById(competenceId);
    }

    @Test
    void validerAutomatiquementCompetence() {
        // GIVEN
        Long id = 1L;

        SousCompetenceDto sc1 = new SousCompetenceDto(1L , "test1" ,"VALIDE");


        SousCompetenceDto sc2 = new SousCompetenceDto(2L , "test2", "NON_VALIDE");


        CompetenceDto competence = new CompetenceDto(id ,"C001",
                "Développement Java",
                "EN_ATTENTE",   List.of(sc1 , sc2));

//
//        when(competenceRepository.findById(id)).thenReturn(Optional.of(competence));
//        when(competenceRepository.save(any(Competence.class))).thenReturn(competence);
//
//        CompetenceDto expectedDto = new CompetenceDto(id, "C001", "Test", "VALIDE", null);
//        when(competenceMapper.competenceDtoToCompetence(competence)).thenReturn(expectedDto);
//
//        // WHEN
//        CompetenceDto result = competenceService.validerAutomatiquementCompetence(id);
//
//        // THEN
//        assertNotNull(result);
//        assertEquals("VALIDE", result.statut());
    }
}