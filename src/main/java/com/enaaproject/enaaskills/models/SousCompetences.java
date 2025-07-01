package com.enaaproject.enaaskills.models;

import jakarta.persistence.*;

@Entity
public class SousCompetences {
    @Id
    @GeneratedValue
    private Long id;

    private String titre;

    @ManyToOne
    @JoinColumn(name = "competence_id")
    private Competence competence;
}
