package edu.kea.exam.renameme.config;

import edu.kea.exam.renameme.entity.Disciplin;
import edu.kea.exam.renameme.repository.DisciplinRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    private final DisciplinRepository disciplinRepository;

    public InitData(DisciplinRepository disciplinRepository) {
        this.disciplinRepository = disciplinRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        InitDiscipliner();
    }


    public void InitDiscipliner() {
        List<Disciplin> discipliner = List.of(
            new Disciplin("100-meterløb", "Tid"),
            new Disciplin("200-meterløb", "Tid"),
            new Disciplin("400-meterløb", "Tid"),
            new Disciplin("800-meterløb", "Tid"),
            new Disciplin("1500-meterløb", "Tid"),
            new Disciplin("5000-meter-løb", "Tid"),
            new Disciplin("10.000-meterløb", "Tid"),
            new Disciplin("Maratonløb", "Tid"),
            new Disciplin("110 meter hækkeløb", "Tid"),
            new Disciplin("400 meter hækkeløb", "Tid"),
            new Disciplin("4 × 100-meterløb", "Tid"),
            new Disciplin("4 × 400-meterløb", "Tid"),
            new Disciplin("Højdespring", "Højde"),
            new Disciplin("Længdespring", "Længde"),
            new Disciplin("Trespring", "Længde"),
            new Disciplin("Stangspring", "Højde"),
            new Disciplin("Kuglestød", "Længde"),
            new Disciplin("Diskoskast", "Længde"),
            new Disciplin("Spydkast", "Længde"),
            new Disciplin("Hammerkast", "Længde")
        );
    disciplinRepository.saveAll(discipliner);
    }

}


