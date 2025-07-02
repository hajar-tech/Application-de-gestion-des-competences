package com.enaaproject.enaaskills.services.implimentationServices;

import com.enaaproject.enaaskills.dtos.CompetenceDto;
import com.enaaproject.enaaskills.mappers.CompetenceMapper;
import com.enaaproject.enaaskills.models.Competence;
import com.enaaproject.enaaskills.models.SousCompetences;
import com.enaaproject.enaaskills.repositories.CompetenceRepository;
import com.enaaproject.enaaskills.repositories.SousCompetenceRepository;
import com.enaaproject.enaaskills.services.interfaceServices.CompetenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetenceServiceImpl implements CompetenceService {

    private final CompetenceRepository competenceRepository;
    private  final SousCompetenceRepository sousCompetenceRepository;
    private final CompetenceMapper competenceMapper;


    public CompetenceServiceImpl (CompetenceRepository competenceRepository , SousCompetenceRepository sousCompetenceRepository , CompetenceMapper competenceMapper){
        this.competenceRepository = competenceRepository;
        this.competenceMapper = competenceMapper;
        this.sousCompetenceRepository = sousCompetenceRepository;
    }

    @Override
    public CompetenceDto createCompetence(CompetenceDto dto) {
        Competence competence = competenceMapper.competenceDtoToCompetence(dto);
        competence.setId(null);//nouvelle entité
        Competence saved = competenceRepository.save(competence);
        return competenceMapper.competenceToCompetenceDto(saved);
    }

    @Override
    public List<Competence> getAllCompetence() {
        return List.of();
    }

    @Override
    public Competence UpdateCompetence(Long id, CompetenceDto dto) {
        return null;
    }

    @Override
    public Competence getCompetenceById(Long id) {
        return null;
    }

    @Override
    public void deleteCompetence(Long id) {

    }
}
