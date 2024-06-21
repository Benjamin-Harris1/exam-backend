package edu.kea.exam.atletik.repository;

import edu.kea.exam.atletik.entity.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultatRepository extends JpaRepository<Resultat, Long> {
    List<Resultat> findByDisciplinId(Long disciplinId);
}
