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
            new Disciplin("100-meterløb", "Tid", true),
            new Disciplin("200-meterløb", "Tid", true),
            new Disciplin("400-meterløb", "Tid", true),
            new Disciplin("800-meterløb", "Tid", true),
            new Disciplin("1500-meterløb", "Tid", true),
            new Disciplin("5000-meter-løb", "Tid", true),
            new Disciplin("10.000-meterløb", "Tid", true),
            new Disciplin("Maratonløb", "Tid", true),
            new Disciplin("110 meter hækkeløb", "Tid", true),
            new Disciplin("400 meter hækkeløb", "Tid", true),
            new Disciplin("4 × 100-meterløb", "Tid", true),
            new Disciplin("4 × 400-meterløb", "Tid", true),
            new Disciplin("Højdespring", "Afstand", true),
            new Disciplin("Længdespring", "Afstand", true),
            new Disciplin("Trespring", "Afstand", true),
            new Disciplin("Stangspring", "Afstand", true),
            new Disciplin("Kuglestød", "Afstand", true),
            new Disciplin("Diskoskast", "Afstand", true),
            new Disciplin("Spydkast", "Afstand", true),
            new Disciplin("Hammerkast", "Afstand", true)
        );
    disciplinRepository.saveAll(discipliner);
    }

        private void initDeltagere() {
        List<Deltager> deltagere = List.of(
            new Deltager("Beast Rabban", "Mand", 25, "Klub A", List.of(disciplinRepository.findById(1L).get()), true),
            new Deltager("Jane Doe", "Kvinde", 30, "Klub B", List.of(disciplinRepository.findById(2L).get()), true),
            new Deltager("Søren Pind", "Mand", 26, "Klub A", List.of(disciplinRepository.findById(3L).get()), true),
            new Deltager("Leto Atreides ii", "Mand", 31, "Klub B", List.of(disciplinRepository.findById(4L).get()), true),
            new Deltager("Thufir Hawatt", "Mand", 27, "Klub A", List.of(disciplinRepository.findById(5L).get()), true),
            new Deltager("Majbrit Hansen", "Kvinde", 32, "Klub B", List.of(disciplinRepository.findById(6L).get()), true),
            new Deltager("John Munch", "Mand", 28, "Klub A", List.of(disciplinRepository.findById(7L).get()), true),
            new Deltager("Britta Jakobsen", "Kvinde", 33, "Klub B", List.of(disciplinRepository.findById(8L).get()), true),
            new Deltager("Hasimir Fenring", "Mand", 29, "Klub A", List.of(disciplinRepository.findById(9L).get()), true),
            new Deltager("Ulrikke Larsen", "Kvinde", 34, "Klub B", List.of(disciplinRepository.findById(10L).get()), true),
            new Deltager("Lars Ulrich", "Mand", 30, "Klub A", List.of(disciplinRepository.findById(11L).get()), true),
            new Deltager("Liv Tyler", "Kvinde", 35, "Klub B", List.of(disciplinRepository.findById(12L).get()), true),
            new Deltager("Aragorn", "Mand", 31, "Klub A", List.of(disciplinRepository.findById(13L).get()), true),
            new Deltager("Rose Cotton", "Kvinde", 36, "Klub B", List.of(disciplinRepository.findById(14L).get()), true),
            new Deltager("Frodo Baggins", "Mand", 32, "Klub A", List.of(disciplinRepository.findById(15L).get()), true),
            new Deltager("Eowyn", "Kvinde", 37, "Klub B", List.of(disciplinRepository.findById(16L).get()), true),
            new Deltager("The Witch King", "Mand", 33, "Klub A", List.of(disciplinRepository.findById(17L).get()), true),
            new Deltager("Galadriel", "Kvinde", 38, "Klub B", List.of(disciplinRepository.findById(18L).get()), true),
            new Deltager("Paul Atreides", "Mand", 80, "Klub A", List.of(disciplinRepository.findById(19L).get()), true),
            new Deltager("Margot Fenring", "Kvinde", 39, "Klub B", List.of(disciplinRepository.findById(20L).get()), true)
        );
        deltagerRepository.saveAll(deltagere);
    }


     private void initResultater() {
        List<Resultat> resultater = List.of(
            new Resultat(deltagerRepository.findById(1L).get(), disciplinRepository.findById(1L).get(), "Tid", LocalDate.now(), "00:10:00:00"),
            new Resultat(deltagerRepository.findById(3L).get(), disciplinRepository.findById(3L).get(), "Tid", LocalDate.now(), "00:09:50:00"),
            new Resultat(deltagerRepository.findById(4L).get(), disciplinRepository.findById(4L).get(), "Afstand", LocalDate.now(), "5.60"),
            new Resultat(deltagerRepository.findById(5L).get(), disciplinRepository.findById(5L).get(), "Tid", LocalDate.now(), "00:09:40:00"),
            new Resultat(deltagerRepository.findById(6L).get(), disciplinRepository.findById(6L).get(), "Afstand", LocalDate.now(), "5.70"),
            new Resultat(deltagerRepository.findById(7L).get(), disciplinRepository.findById(7L).get(), "Tid", LocalDate.now(), "00:09:30:00"),
            new Resultat(deltagerRepository.findById(8L).get(), disciplinRepository.findById(8L).get(), "Afstand", LocalDate.now(), "5.80"),
            new Resultat(deltagerRepository.findById(9L).get(), disciplinRepository.findById(9L).get(), "Tid", LocalDate.now(), "00:09:20:00"),
            new Resultat(deltagerRepository.findById(10L).get(), disciplinRepository.findById(10L).get(), "Afstand", LocalDate.now(), "5.90"),
            new Resultat(deltagerRepository.findById(11L).get(), disciplinRepository.findById(11L).get(), "Tid", LocalDate.now(), "00:09:10:00"),
            new Resultat(deltagerRepository.findById(12L).get(), disciplinRepository.findById(12L).get(), "Afstand", LocalDate.now(), "6.00"),
            new Resultat(deltagerRepository.findById(13L).get(), disciplinRepository.findById(13L).get(), "Tid", LocalDate.now(), "00:09:00:00"),
            new Resultat(deltagerRepository.findById(14L).get(), disciplinRepository.findById(14L).get(), "Afstand", LocalDate.now(), "6.10"),
            new Resultat(deltagerRepository.findById(15L).get(), disciplinRepository.findById(15L).get(), "Tid", LocalDate.now(), "00:08:50:00"),
            new Resultat(deltagerRepository.findById(16L).get(), disciplinRepository.findById(16L).get(), "Afstand", LocalDate.now(), "6.20"),
            new Resultat(deltagerRepository.findById(17L).get(), disciplinRepository.findById(17L).get(), "Tid", LocalDate.now(), "00:08:40:00"),
            new Resultat(deltagerRepository.findById(18L).get(), disciplinRepository.findById(18L).get(), "Afstand", LocalDate.now(), "6.30"),
            new Resultat(deltagerRepository.findById(19L).get(), disciplinRepository.findById(19L).get(), "Tid", LocalDate.now(), "00:08:30:00"),
            new Resultat(deltagerRepository.findById(20L).get(), disciplinRepository.findById(20L).get(), "Afstand", LocalDate.now(), "6.40"),
            // Additional Resultat entries for the same disciplines and participants
            new Resultat(deltagerRepository.findById(1L).get(), disciplinRepository.findById(1L).get(), "Tid", LocalDate.now().minusDays(1), "00:10:10:00"),
            new Resultat(deltagerRepository.findById(1L).get(), disciplinRepository.findById(1L).get(), "Tid", LocalDate.now().minusDays(2), "00:10:20:00"),
            new Resultat(deltagerRepository.findById(2L).get(), disciplinRepository.findById(2L).get(), "Afstand", LocalDate.now().minusDays(1), "5.50"),
            new Resultat(deltagerRepository.findById(2L).get(), disciplinRepository.findById(2L).get(), "Afstand", LocalDate.now().minusDays(2), "5.40"),
            new Resultat(deltagerRepository.findById(3L).get(), disciplinRepository.findById(3L).get(), "Tid", LocalDate.now().minusDays(1), "00:09:45:00"),
            new Resultat(deltagerRepository.findById(3L).get(), disciplinRepository.findById(3L).get(), "Tid", LocalDate.now().minusDays(2), "00:09:55:00"),
            new Resultat(deltagerRepository.findById(4L).get(), disciplinRepository.findById(4L).get(), "Afstand", LocalDate.now().minusDays(1), "5.30"),
            new Resultat(deltagerRepository.findById(4L).get(), disciplinRepository.findById(4L).get(), "Afstand", LocalDate.now().minusDays(2), "5.20"),
            new Resultat(deltagerRepository.findById(5L).get(), disciplinRepository.findById(5L).get(), "Tid", LocalDate.now().minusDays(1), "00:09:35:00"),
            new Resultat(deltagerRepository.findById(5L).get(), disciplinRepository.findById(5L).get(), "Tid", LocalDate.now().minusDays(2), "00:09:45:00"),
            new Resultat(deltagerRepository.findById(6L).get(), disciplinRepository.findById(6L).get(), "Afstand", LocalDate.now().minusDays(1), "5.10"),
            new Resultat(deltagerRepository.findById(6L).get(), disciplinRepository.findById(6L).get(), "Afstand", LocalDate.now().minusDays(2), "5.00"),
            new Resultat(deltagerRepository.findById(7L).get(), disciplinRepository.findById(7L).get(), "Tid", LocalDate.now().minusDays(2), "00:09:35:00"),
        new Resultat(deltagerRepository.findById(8L).get(), disciplinRepository.findById(8L).get(), "Afstand", LocalDate.now().minusDays(1), "5.90"),
        new Resultat(deltagerRepository.findById(8L).get(), disciplinRepository.findById(8L).get(), "Afstand", LocalDate.now().minusDays(2), "5.85"),
        new Resultat(deltagerRepository.findById(9L).get(), disciplinRepository.findById(9L).get(), "Tid", LocalDate.now().minusDays(1), "00:09:15:00"),
        new Resultat(deltagerRepository.findById(9L).get(), disciplinRepository.findById(9L).get(), "Tid", LocalDate.now().minusDays(2), "00:09:25:00"),
        new Resultat(deltagerRepository.findById(10L).get(), disciplinRepository.findById(10L).get(), "Afstand", LocalDate.now().minusDays(1), "6.00"),
        new Resultat(deltagerRepository.findById(10L).get(), disciplinRepository.findById(10L).get(), "Afstand", LocalDate.now().minusDays(2), "5.95"),
        new Resultat(deltagerRepository.findById(11L).get(), disciplinRepository.findById(11L).get(), "Tid", LocalDate.now().minusDays(1), "00:09:05:00"),
        new Resultat(deltagerRepository.findById(11L).get(), disciplinRepository.findById(11L).get(), "Tid", LocalDate.now().minusDays(2), "00:09:15:00"),
        new Resultat(deltagerRepository.findById(12L).get(), disciplinRepository.findById(12L).get(), "Afstand", LocalDate.now().minusDays(1), "6.10"),
        new Resultat(deltagerRepository.findById(12L).get(), disciplinRepository.findById(12L).get(), "Afstand", LocalDate.now().minusDays(2), "6.05"),
        new Resultat(deltagerRepository.findById(13L).get(), disciplinRepository.findById(13L).get(), "Tid", LocalDate.now().minusDays(1), "00:08:55:00"),
        new Resultat(deltagerRepository.findById(13L).get(), disciplinRepository.findById(13L).get(), "Tid", LocalDate.now().minusDays(2), "00:09:05:00"),
        new Resultat(deltagerRepository.findById(14L).get(), disciplinRepository.findById(14L).get(), "Afstand", LocalDate.now().minusDays(1), "6.20"),
        new Resultat(deltagerRepository.findById(14L).get(), disciplinRepository.findById(14L).get(), "Afstand", LocalDate.now().minusDays(2), "6.15"),
        new Resultat(deltagerRepository.findById(15L).get(), disciplinRepository.findById(15L).get(), "Tid", LocalDate.now().minusDays(1), "00:08:45:00"),
        new Resultat(deltagerRepository.findById(15L).get(), disciplinRepository.findById(15L).get(), "Tid", LocalDate.now().minusDays(2), "00:08:55:00"),
        new Resultat(deltagerRepository.findById(16L).get(), disciplinRepository.findById(16L).get(), "Afstand", LocalDate.now().minusDays(1), "6.25"),
        new Resultat(deltagerRepository.findById(16L).get(), disciplinRepository.findById(16L).get(), "Afstand", LocalDate.now().minusDays(2), "6.20"),
        new Resultat(deltagerRepository.findById(17L).get(), disciplinRepository.findById(17L).get(), "Tid", LocalDate.now().minusDays(1), "00:08:35:00"),
        new Resultat(deltagerRepository.findById(17L).get(), disciplinRepository.findById(17L).get(), "Tid", LocalDate.now().minusDays(2), "00:08:45:00"),
        new Resultat(deltagerRepository.findById(18L).get(), disciplinRepository.findById(18L).get(), "Afstand", LocalDate.now().minusDays(1), "6.35"),
        new Resultat(deltagerRepository.findById(18L).get(), disciplinRepository.findById(18L).get(), "Afstand", LocalDate.now().minusDays(2), "6.30"),
        new Resultat(deltagerRepository.findById(19L).get(), disciplinRepository.findById(19L).get(), "Tid", LocalDate.now().minusDays(1), "00:08:25:00"),
        new Resultat(deltagerRepository.findById(19L).get(), disciplinRepository.findById(19L).get(), "Tid", LocalDate.now().minusDays(2), "00:08:35:00"),
        new Resultat(deltagerRepository.findById(20L).get(), disciplinRepository.findById(20L).get(), "Afstand", LocalDate.now().minusDays(1), "6.45"),
        new Resultat(deltagerRepository.findById(20L).get(), disciplinRepository.findById(20L).get(), "Afstand", LocalDate.now().minusDays(2), "6.40")
        );
        resultatRepository.saveAll(resultater);
    }

    

}


