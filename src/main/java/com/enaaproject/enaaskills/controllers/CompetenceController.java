package com.enaaproject.enaaskills.controllers;

import com.enaaproject.enaaskills.dtos.CompetenceCreationDto;
import com.enaaproject.enaaskills.models.Competence;
import com.enaaproject.enaaskills.repositories.CompetenceRepository;
import com.enaaproject.enaaskills.services.interfaceServices.CompetenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/competences")
public class CompetenceController {

    private  final CompetenceService competenceService;

    public CompetenceController (CompetenceService competenceService){
        this.competenceService = competenceService;
    }

    @PostMapping("/add")
    public ResponseEntity<Competence> create(@RequestBody CompetenceCreationDto dto) {
        return new ResponseEntity<>(competenceService.createCompetence(dto), HttpStatus.CREATED);
    }
}
