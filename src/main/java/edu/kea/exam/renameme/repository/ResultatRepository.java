package edu.kea.exam.renameme.repository;

import edu.kea.exam.renameme.entity.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultatRepository extends JpaRepository<Resultat, Long> {
    List<Resultat> findByDisciplinIdAndDeltagerKønAndDeltagerAlderBetween(Long disciplinId, String køn, int alderFra, int alderTil);
}
