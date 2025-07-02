package com.enaaproject.enaaskills.mappers;

import ch.qos.logback.core.model.ComponentModel;
import com.enaaproject.enaaskills.dtos.CompetenceDto;
import com.enaaproject.enaaskills.dtos.SousCompetenceDto;
import com.enaaproject.enaaskills.models.Competence;
import com.enaaproject.enaaskills.models.SousCompetences;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenceMapper {

    CompetenceMapper INSTANCE = Mappers.getMapper(CompetenceMapper.class);
    CompetenceDto competenceToCompetenceDto(Competence competence);
    Competence competenceDtoToCompetence(CompetenceDto dto);


    SousCompetenceDto sousCompetenceToSousCompetenceDto(SousCompetences sousCompetence);
    SousCompetences sousCompetenceDtoToSousCompetence(SousCompetenceDto dto);

    List<SousCompetenceDto> toSousCompetenceDtos(List<SousCompetences> list);
    List<SousCompetences> toSousCompetenceEntities(List<SousCompetenceDto> list);


}
