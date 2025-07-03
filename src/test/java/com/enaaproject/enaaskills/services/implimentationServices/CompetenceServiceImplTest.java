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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        // DTO d'entrée
        CompetenceDto dto = new CompetenceDto(null, "C1", "Titre simple", "EN_ATTENTE", List.of());

        // Entité simulée à retourner par le mapper
        Competence competence = new Competence();
        competence.setCode("C1");
        competence.setTitre("Titre simple");
        competence.setStatut(StatutCompetence.EN_ATTENTE);
        competence.setSousCompetences(List.of());

        Competence saved = new Competence();
        saved.setId(1L);
        saved.setCode("C1");
        saved.setTitre("Titre simple");
        saved.setStatut(StatutCompetence.EN_ATTENTE);
        saved.setSousCompetences(List.of());

        CompetenceDto expectedDto = new CompetenceDto(1L, "C1", "Titre simple", "EN_ATTENTE", List.of());

        // Mock du mapper : quand on demande de convertir le DTO vers l'entité
        when(competenceMapper.competenceDtoToCompetence(dto)).thenReturn(competence);

        // Mock du repository pour la sauvegarde
        when(competenceRepository.save(competence)).thenReturn(saved);

        // Mock du mapper pour la conversion inverse (entité vers DTO)
        when(competenceMapper.competenceToCompetenceDto(saved)).thenReturn(expectedDto);

        // Appel réel à la méthode testée
        CompetenceDto result = competenceService.createCompetence(dto);

        // Assertions basiques
        assertNotNull(result);
        assertEquals(1L, result.id());
        assertEquals("C1", result.code());
        assertEquals("Titre simple", result.titre());

        // Vérifier que le mock a été bien appelé
        verify(competenceMapper).competenceDtoToCompetence(dto);
        verify(competenceRepository).save(competence);
        verify(competenceMapper).competenceToCompetenceDto(saved);

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