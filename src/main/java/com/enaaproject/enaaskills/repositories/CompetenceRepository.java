package com.enaaproject.enaaskills.repositories;

import com.enaaproject.enaaskills.models.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence , Long> {
}
