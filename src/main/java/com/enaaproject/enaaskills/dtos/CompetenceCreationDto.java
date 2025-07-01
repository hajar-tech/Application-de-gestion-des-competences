package com.enaaproject.enaaskills.dtos;

import java.util.List;

public record CompetenceCreationDto(
        String titre,
        List<String> sousCompetences
) {
}
