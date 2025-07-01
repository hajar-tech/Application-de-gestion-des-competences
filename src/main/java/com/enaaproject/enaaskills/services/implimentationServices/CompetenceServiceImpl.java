package com.enaaproject.enaaskills.services.implimentationServices;

import com.enaaproject.enaaskills.dtos.CompetenceCreationDto;
import com.enaaproject.enaaskills.models.Competence;
import com.enaaproject.enaaskills.models.SousCompetences;
import com.enaaproject.enaaskills.repositories.CompetenceRepository;
import com.enaaproject.enaaskills.services.interfaceServices.CompetenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetenceServiceImpl implements CompetenceService {

    private final CompetenceRepository competenceRepository;

    public CompetenceServiceImpl (CompetenceRepository competenceRepository){
        this.competenceRepository = competenceRepository;
    }

    @Override
    public Competence createCompetence(CompetenceCreationDto dto) {

        Competence competence = new Competence();
        competence.setTitre(dto.titre());
        List<SousCompetences> sousCompetences = dto.sousCompetences().stream()
                .map(titre->{
                    SousCompetences sc = new SousCompetences();
                    sc.setTitre(titre);
                    sc.setCompetence(competence);
                    return sc;
                }).collect(Collectors.toList());
        competence.setSousCompetences(sousCompetences);
        return competenceRepository.save(competence);
    }

    @Override
    public List<Competence> getAllCompetence() {
        return List.of();
    }

    @Override
    public Competence UpdateCompetence(Long id, CompetenceCreationDto dto) {
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
