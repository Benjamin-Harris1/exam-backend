package edu.kea.exam.atletik.config;

import edu.kea.exam.atletik.entity.Deltager;
import edu.kea.exam.atletik.entity.Disciplin;
import edu.kea.exam.atletik.entity.Resultat;
import edu.kea.exam.atletik.repository.DeltagerRepository;
import edu.kea.exam.atletik.repository.DisciplinRepository;
import edu.kea.exam.atletik.repository.ResultatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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
            new Resultat(deltagerRepository.findById(1L).get(), disciplinRepository.findById(1L).get(), "Tid", LocalDate.now(), new BigDecimal("60")),
            new Resultat(deltagerRepository.findById(3L).get(), disciplinRepository.findById(3L).get(), "Tid", LocalDate.now(), new BigDecimal("120")),
            new Resultat(deltagerRepository.findById(4L).get(), disciplinRepository.findById(4L).get(), "Tid", LocalDate.now(), new BigDecimal("180")),
            new Resultat(deltagerRepository.findById(5L).get(), disciplinRepository.findById(5L).get(), "Tid", LocalDate.now(), new BigDecimal("800")),
            new Resultat(deltagerRepository.findById(6L).get(), disciplinRepository.findById(6L).get(), "Tid", LocalDate.now(), new BigDecimal("2400")),
            new Resultat(deltagerRepository.findById(7L).get(), disciplinRepository.findById(7L).get(), "Tid", LocalDate.now(), new BigDecimal("2400")),
            new Resultat(deltagerRepository.findById(8L).get(), disciplinRepository.findById(8L).get(), "Tid", LocalDate.now(), new BigDecimal("200")),
            new Resultat(deltagerRepository.findById(9L).get(), disciplinRepository.findById(9L).get(), "Tid", LocalDate.now(), new BigDecimal("1800")),
            new Resultat(deltagerRepository.findById(10L).get(), disciplinRepository.findById(10L).get(), "Tid", LocalDate.now(), new BigDecimal("400")),
            new Resultat(deltagerRepository.findById(11L).get(), disciplinRepository.findById(11L).get(), "Tid", LocalDate.now(), new BigDecimal("500")),
            new Resultat(deltagerRepository.findById(12L).get(), disciplinRepository.findById(12L).get(), "Tid", LocalDate.now(), new BigDecimal("6.00")),
            new Resultat(deltagerRepository.findById(13L).get(), disciplinRepository.findById(13L).get(), "Afstand", LocalDate.now(), new BigDecimal("20")),
            new Resultat(deltagerRepository.findById(14L).get(), disciplinRepository.findById(14L).get(), "Afstand", LocalDate.now(), new BigDecimal("6.10")),
            new Resultat(deltagerRepository.findById(15L).get(), disciplinRepository.findById(15L).get(), "Afstand", LocalDate.now(), new BigDecimal("13")),
            new Resultat(deltagerRepository.findById(16L).get(), disciplinRepository.findById(16L).get(), "Afstand", LocalDate.now(), new BigDecimal("6.20")),
            new Resultat(deltagerRepository.findById(17L).get(), disciplinRepository.findById(17L).get(), "Afstand", LocalDate.now(), new BigDecimal("12.2")),
            new Resultat(deltagerRepository.findById(18L).get(), disciplinRepository.findById(18L).get(), "Afstand", LocalDate.now(), new BigDecimal("6.30")),
            new Resultat(deltagerRepository.findById(19L).get(), disciplinRepository.findById(19L).get(), "Afstand", LocalDate.now(), new BigDecimal("15.5")),
            new Resultat(deltagerRepository.findById(20L).get(), disciplinRepository.findById(20L).get(), "Afstand", LocalDate.now(), new BigDecimal("6.40")),
            // Additional Resultat entries for the same disciplines and participants
            new Resultat(deltagerRepository.findById(1L).get(), disciplinRepository.findById(1L).get(), "Tid", LocalDate.now().minusDays(1), new BigDecimal("60")),
            new Resultat(deltagerRepository.findById(2L).get(), disciplinRepository.findById(2L).get(), "Tid", LocalDate.now().minusDays(1), new BigDecimal("5.50")),
            new Resultat(deltagerRepository.findById(2L).get(), disciplinRepository.findById(2L).get(), "Tid", LocalDate.now().minusDays(2), new BigDecimal("5.40")),
            new Resultat(deltagerRepository.findById(3L).get(), disciplinRepository.findById(3L).get(), "Tid", LocalDate.now().minusDays(1), new BigDecimal("500")),
            new Resultat(deltagerRepository.findById(3L).get(), disciplinRepository.findById(3L).get(), "Tid", LocalDate.now().minusDays(2), new BigDecimal("400")),
            new Resultat(deltagerRepository.findById(4L).get(), disciplinRepository.findById(4L).get(), "Tid", LocalDate.now().minusDays(1), new BigDecimal("400")),
            new Resultat(deltagerRepository.findById(4L).get(), disciplinRepository.findById(4L).get(), "Tid", LocalDate.now().minusDays(2), new BigDecimal("400")),
            new Resultat(deltagerRepository.findById(5L).get(), disciplinRepository.findById(5L).get(), "Tid", LocalDate.now().minusDays(1), new BigDecimal("500")),
            new Resultat(deltagerRepository.findById(5L).get(), disciplinRepository.findById(5L).get(), "Tid", LocalDate.now().minusDays(2), new BigDecimal("700")),
            new Resultat(deltagerRepository.findById(6L).get(), disciplinRepository.findById(6L).get(), "Tid", LocalDate.now().minusDays(1), new BigDecimal("1200")),
            new Resultat(deltagerRepository.findById(6L).get(), disciplinRepository.findById(6L).get(), "Tid", LocalDate.now().minusDays(2), new BigDecimal("120")),
            new Resultat(deltagerRepository.findById(7L).get(), disciplinRepository.findById(7L).get(), "Tid", LocalDate.now().minusDays(2), new BigDecimal("650")),
            new Resultat(deltagerRepository.findById(8L).get(), disciplinRepository.findById(8L).get(), "Tid", LocalDate.now().minusDays(1), new BigDecimal("180")),
            new Resultat(deltagerRepository.findById(8L).get(), disciplinRepository.findById(8L).get(), "Tid", LocalDate.now().minusDays(2), new BigDecimal("200")),
            new Resultat(deltagerRepository.findById(9L).get(), disciplinRepository.findById(9L).get(), "Tid", LocalDate.now().minusDays(1), new BigDecimal("400")),
            new Resultat(deltagerRepository.findById(9L).get(), disciplinRepository.findById(9L).get(), "Tid", LocalDate.now().minusDays(2), new BigDecimal("1200")),
            new Resultat(deltagerRepository.findById(10L).get(), disciplinRepository.findById(10L).get(), "Tid", LocalDate.now().minusDays(1), new BigDecimal("2400")),
            new Resultat(deltagerRepository.findById(10L).get(), disciplinRepository.findById(10L).get(), "Tid", LocalDate.now().minusDays(2), new BigDecimal("6700")),
            new Resultat(deltagerRepository.findById(11L).get(), disciplinRepository.findById(11L).get(), "Tid", LocalDate.now().minusDays(1), new BigDecimal("1200")),
            new Resultat(deltagerRepository.findById(11L).get(), disciplinRepository.findById(11L).get(), "Tid", LocalDate.now().minusDays(2), new BigDecimal("800")),
            new Resultat(deltagerRepository.findById(12L).get(), disciplinRepository.findById(12L).get(), "Tid", LocalDate.now().minusDays(1), new BigDecimal("1200")),
            new Resultat(deltagerRepository.findById(12L).get(), disciplinRepository.findById(12L).get(), "Tid", LocalDate.now().minusDays(2), new BigDecimal("1500")),
            new Resultat(deltagerRepository.findById(13L).get(), disciplinRepository.findById(13L).get(), "Afstand", LocalDate.now().minusDays(1), new BigDecimal("20")),
            new Resultat(deltagerRepository.findById(13L).get(), disciplinRepository.findById(13L).get(), "Afstand", LocalDate.now().minusDays(2), new BigDecimal("10")),
            new Resultat(deltagerRepository.findById(14L).get(), disciplinRepository.findById(14L).get(), "Afstand", LocalDate.now().minusDays(1), new BigDecimal("6.20")),
            new Resultat(deltagerRepository.findById(14L).get(), disciplinRepository.findById(14L).get(), "Afstand", LocalDate.now().minusDays(2), new BigDecimal("6.15")),
            new Resultat(deltagerRepository.findById(15L).get(), disciplinRepository.findById(15L).get(), "Afstand", LocalDate.now().minusDays(1), new BigDecimal("12")),
            new Resultat(deltagerRepository.findById(15L).get(), disciplinRepository.findById(15L).get(), "Afstand", LocalDate.now().minusDays(2), new BigDecimal("14.7"))
        );
        resultatRepository.saveAll(resultater);
    }

    

}


