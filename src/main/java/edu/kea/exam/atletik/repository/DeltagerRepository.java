package edu.kea.exam.atletik.repository;

import edu.kea.exam.atletik.entity.Deltager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeltagerRepository extends JpaRepository<Deltager, Long>{
    List<Deltager> findByNavnContainingIgnoreCaseAndIsActiveTrue(String navn);
    List<Deltager> findAllByIsActiveTrue();

}
