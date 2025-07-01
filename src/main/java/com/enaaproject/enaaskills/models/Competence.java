package com.enaaproject.enaaskills.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Competence {
    @Id
    @GeneratedValue
    private Long id;

    private String titre;

    @OneToMany(mappedBy = "competence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SousCompetences> sousCompetences = new ArrayList<>();
}
