package com.enaaproject.enaaskills.services.interfaceServices;

import com.enaaproject.enaaskills.dtos.CompetenceCreationDto;
import com.enaaproject.enaaskills.models.Competence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompetenceService {

    Competence createCompetence (CompetenceCreationDto dto);
    List<Competence> getAllCompetence ();
    Competence UpdateCompetence(Long id , CompetenceCreationDto dto);
    Competence getCompetenceById (Long id);
    void deleteCompetence(Long id);

}
