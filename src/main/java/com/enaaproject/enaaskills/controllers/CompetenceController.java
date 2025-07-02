package com.enaaproject.enaaskills.controllers;

import com.enaaproject.enaaskills.dtos.CompetenceDto;
import com.enaaproject.enaaskills.models.Competence;
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
    public ResponseEntity<CompetenceDto> create(@RequestBody CompetenceDto dto) {
        return ResponseEntity.ok(competenceService.createCompetence(dto));
    }
}
