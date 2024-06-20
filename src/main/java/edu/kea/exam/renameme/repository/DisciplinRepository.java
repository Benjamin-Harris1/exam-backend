package edu.kea.exam.renameme.repository;

import edu.kea.exam.renameme.entity.Disciplin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplinRepository extends JpaRepository<Disciplin, Long> {
    List<Disciplin> findAllByIsActiveTrue();
}
