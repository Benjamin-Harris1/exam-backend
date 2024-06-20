package edu.kea.exam.renameme.config;

import edu.kea.exam.renameme.entity.TestEntity;
import edu.kea.exam.renameme.repository.TestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestConfig implements CommandLineRunner {

    private final TestRepository testRepository;

    public TestConfig(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    initData();
    }

    public void initData() {
        TestEntity testEntity = new TestEntity("Testname", "Testdescription");
        testRepository.save(testEntity);
    }
}
