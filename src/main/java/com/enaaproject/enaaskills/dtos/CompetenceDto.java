package com.enaaproject.enaaskills.dtos;

import com.enaaproject.enaaskills.models.SousCompetences;

import java.security.SecureRandom;
import java.util.List;
import java.util.SimpleTimeZone;

public record CompetenceDto(
        Long id,
        String code,
        String titre,
        String statut,
        List<SousCompetenceDto> sousCompetences
) {
}
