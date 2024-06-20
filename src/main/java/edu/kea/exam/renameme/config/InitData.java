package edu.kea.exam.renameme.config;

import edu.kea.exam.renameme.entity.Deltager;
import edu.kea.exam.renameme.entity.Disciplin;
import edu.kea.exam.renameme.entity.Resultat;
import edu.kea.exam.renameme.repository.DeltagerRepository;
import edu.kea.exam.renameme.repository.DisciplinRepository;
import edu.kea.exam.renameme.repository.ResultatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    private final DisciplinRepository disciplinRepository;
    private final DeltagerRepository deltagerRepository;
    private final ResultatRepository resultatRepository;

    public InitData(DisciplinRepository disciplinRepository, DeltagerRepository deltagerRepository, ResultatRepository resultatRepository) {
        this.disciplinRepository = disciplinRepository;
        this.deltagerRepository = deltagerRepository;
        this.resultatRepository = resultatRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        InitDiscipliner();
        initDeltagere();
        initResultater();
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
            new Disciplin("Højdespring", "Afstand"),
            new Disciplin("Længdespring", "Afstand"),
            new Disciplin("Trespring", "Afstand"),
            new Disciplin("Stangspring", "Afstand"),
            new Disciplin("Kuglestød", "Afstand"),
            new Disciplin("Diskoskast", "Afstand"),
            new Disciplin("Spydkast", "Afstand"),
            new Disciplin("Hammerkast", "Afstand")
        );
    disciplinRepository.saveAll(discipliner);
    }

        private void initDeltagere() {
        List<Deltager> deltagere = List.of(
            new Deltager("Beast Rabban", "Mand", 25, "Klub A", List.of(disciplinRepository.findById(1L).get())),
            new Deltager("Jane Doe", "Kvinde", 30, "Klub B", List.of(disciplinRepository.findById(2L).get())),
            new Deltager("Søren Pind", "Mand", 26, "Klub A", List.of(disciplinRepository.findById(3L).get())),
            new Deltager("Leto Atreides ii", "Kvinde", 31, "Klub B", List.of(disciplinRepository.findById(4L).get())),
            new Deltager("Thufir Hawatt", "Mand", 27, "Klub A", List.of(disciplinRepository.findById(5L).get())),
            new Deltager("Majbrit Hansen", "Kvinde", 32, "Klub B", List.of(disciplinRepository.findById(6L).get())),
            new Deltager("John Munch", "Mand", 28, "Klub A", List.of(disciplinRepository.findById(7L).get())),
            new Deltager("Britta Jakobsen", "Kvinde", 33, "Klub B", List.of(disciplinRepository.findById(8L).get())),
            new Deltager("Hasimir Fenring", "Mand", 29, "Klub A", List.of(disciplinRepository.findById(9L).get())),
            new Deltager("Ulrikke Larsen", "Kvinde", 34, "Klub B", List.of(disciplinRepository.findById(10L).get())),
            new Deltager("Lars Ulrich", "Mand", 30, "Klub A", List.of(disciplinRepository.findById(11L).get())),
            new Deltager("Liv Tyler", "Kvinde", 35, "Klub B", List.of(disciplinRepository.findById(12L).get())),
            new Deltager("Aragorn", "Mand", 31, "Klub A", List.of(disciplinRepository.findById(13L).get())),
            new Deltager("Rose Cotton", "Kvinde", 36, "Klub B", List.of(disciplinRepository.findById(14L).get())),
            new Deltager("Frodo Baggins", "Mand", 32, "Klub A", List.of(disciplinRepository.findById(15L).get())),
            new Deltager("Eowyn", "Kvinde", 37, "Klub B", List.of(disciplinRepository.findById(16L).get())),
            new Deltager("The Witch King", "Mand", 33, "Klub A", List.of(disciplinRepository.findById(17L).get())),
            new Deltager("Galadriel", "Kvinde", 38, "Klub B", List.of(disciplinRepository.findById(18L).get())),
            new Deltager("Paul Atreides", "Mand", 80, "Klub A", List.of(disciplinRepository.findById(19L).get())),
            new Deltager("Margot Fenring", "Kvinde", 39, "Klub B", List.of(disciplinRepository.findById(20L).get()))
        );
        deltagerRepository.saveAll(deltagere);
    }


     private void initResultater() {
        List<Resultat> resultater = List.of(
            new Resultat(deltagerRepository.findById(1L).get(), disciplinRepository.findById(1L).get(), "Tid", LocalDate.now(), "00:10:00"),
            new Resultat(deltagerRepository.findById(3L).get(), disciplinRepository.findById(3L).get(), "Tid", LocalDate.now(), "00:09:50"),
            new Resultat(deltagerRepository.findById(4L).get(), disciplinRepository.findById(4L).get(), "Afstand", LocalDate.now(), "5.6"),
            new Resultat(deltagerRepository.findById(5L).get(), disciplinRepository.findById(5L).get(), "Tid", LocalDate.now(), "00:09:40"),
            new Resultat(deltagerRepository.findById(6L).get(), disciplinRepository.findById(6L).get(), "Afstand", LocalDate.now(), "5.7"),
            new Resultat(deltagerRepository.findById(7L).get(), disciplinRepository.findById(7L).get(), "Tid", LocalDate.now(), "00:09:30"),
            new Resultat(deltagerRepository.findById(8L).get(), disciplinRepository.findById(8L).get(), "Afstand", LocalDate.now(), "5.8"),
            new Resultat(deltagerRepository.findById(9L).get(), disciplinRepository.findById(9L).get(), "Tid", LocalDate.now(), "00:09:20"),
            new Resultat(deltagerRepository.findById(10L).get(), disciplinRepository.findById(10L).get(), "Afstand", LocalDate.now(), "5.9"),
            new Resultat(deltagerRepository.findById(11L).get(), disciplinRepository.findById(11L).get(), "Tid", LocalDate.now(), "00:09:10"),
            new Resultat(deltagerRepository.findById(12L).get(), disciplinRepository.findById(12L).get(), "Afstand", LocalDate.now(), "6.0"),
            new Resultat(deltagerRepository.findById(13L).get(), disciplinRepository.findById(13L).get(), "Tid", LocalDate.now(), "00:09:00"),
            new Resultat(deltagerRepository.findById(14L).get(), disciplinRepository.findById(14L).get(), "Afstand", LocalDate.now(), "6.1"),
            new Resultat(deltagerRepository.findById(15L).get(), disciplinRepository.findById(15L).get(), "Tid", LocalDate.now(), "00:08:50"),
            new Resultat(deltagerRepository.findById(16L).get(), disciplinRepository.findById(16L).get(), "Afstand", LocalDate.now(), "6.2"),
            new Resultat(deltagerRepository.findById(17L).get(), disciplinRepository.findById(17L).get(), "Tid", LocalDate.now(), "00:08:40"),
            new Resultat(deltagerRepository.findById(18L).get(), disciplinRepository.findById(18L).get(), "Afstand", LocalDate.now(), "6.3"),
            new Resultat(deltagerRepository.findById(19L).get(), disciplinRepository.findById(19L).get(), "Tid", LocalDate.now(), "00:08:30"),
            new Resultat(deltagerRepository.findById(20L).get(), disciplinRepository.findById(20L).get(), "Afstand", LocalDate.now(), "6.4")
        );
        resultatRepository.saveAll(resultater);
    }

    

}


