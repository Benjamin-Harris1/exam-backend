package edu.kea.exam.renameme.repository;

import edu.kea.exam.renameme.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long>{
}
