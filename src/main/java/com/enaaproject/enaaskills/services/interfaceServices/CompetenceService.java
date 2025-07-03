package com.enaaproject.enaaskills.services.interfaceServices;

import com.enaaproject.enaaskills.dtos.CompetenceDto;
import com.enaaproject.enaaskills.models.Competence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompetenceService {

    CompetenceDto createCompetence (CompetenceDto dto);
    List<CompetenceDto> getAllCompetences();
    CompetenceDto updateCompetence(Long id, CompetenceDto dto);
    CompetenceDto getCompetenceById(Long id);
    void deleteCompetence(Long id);

}
