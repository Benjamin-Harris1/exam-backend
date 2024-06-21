package edu.kea.exam.atletik.repository;

import edu.kea.exam.atletik.entity.Disciplin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplinRepository extends JpaRepository<Disciplin, Long> {
    List<Disciplin> findAllByIsActiveTrue();
}
