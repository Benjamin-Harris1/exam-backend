package edu.kea.exam.renameme.repository;

import edu.kea.exam.renameme.entity.Deltager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeltagerRepository extends JpaRepository<Deltager, Long>{
    List<Deltager> findByNavnContainingIgnoreCaseAndIsActiveTrue(String navn);
    List<Deltager> findAllByIsActiveTrue();

}
