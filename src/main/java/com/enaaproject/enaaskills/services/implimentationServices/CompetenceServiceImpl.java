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
        if (competence.getSousCompetences() != null) {
            for (SousCompetences sc : competence.getSousCompetences()) {
                sc.setCompetence(competence);
            }
        }
        Competence saved = competenceRepository.save(competence);
        return competenceMapper.competenceToCompetenceDto(saved);
    }

    @Override
    public List<CompetenceDto> getAllCompetences() {
        List<Competence> competences = competenceRepository.findAll();
        return competences.stream()
                .map(competenceMapper::competenceToCompetenceDto)
                .collect(Collectors.toList());
    }

    @Override
    public Competence UpdateCompetence(Long id, CompetenceDto dto) {
        return null;
    }

    @Override
    public CompetenceDto getCompetenceById(Long id) {
        Competence c = competenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compétence non trouvée"));
        return competenceMapper.competenceToCompetenceDto(c);
    }

    @Override
    public void deleteCompetence(Long id) {

    }
}
