package edu.kea.exam.renameme.config;

import edu.kea.exam.renameme.repository.DeltagerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    private final DeltagerRepository deltagerRepository;

    public InitData(DeltagerRepository deltagerRepository) {
        this.deltagerRepository = deltagerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World");
    }

}
