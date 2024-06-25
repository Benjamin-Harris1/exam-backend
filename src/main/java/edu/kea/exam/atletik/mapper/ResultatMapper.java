package edu.kea.exam.atletik.mapper;

import edu.kea.exam.atletik.dto.ResultatDTO;
import edu.kea.exam.atletik.entity.Resultat;
import edu.kea.exam.atletik.repository.DeltagerRepository;
import edu.kea.exam.atletik.repository.DisciplinRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class ResultatMapper {

    private final DeltagerRepository deltagerRepository;
    private final DisciplinRepository disciplinRepository;

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SS");
    private static final DecimalFormat DISTANCE_FORMATTER = new DecimalFormat("#.##");

    public ResultatMapper(DeltagerRepository deltagerRepository, DisciplinRepository disciplinRepository) {
        this.deltagerRepository = deltagerRepository;
        this.disciplinRepository = disciplinRepository;
    }

    public ResultatDTO toDTO(Resultat resultat) {
        ResultatDTO dto = new ResultatDTO();
        dto.setId(resultat.getId());
        dto.setDeltagerId(resultat.getDeltager().getId());
        dto.setDisciplinId(resultat.getDisciplin().getId());
        dto.setResultatType(resultat.getResultatType());
        dto.setDato(resultat.getDato());
        dto.setResultatværdi(formatResultatværdi(resultat.getResultatværdi(), resultat.getResultatType()));
        return dto;
    }

    public Resultat toEntity(ResultatDTO dto) {
        Resultat resultat = new Resultat();
        resultat.setId(dto.getId());
        resultat.setDeltager(deltagerRepository.findById(dto.getDeltagerId())
                .orElseThrow(() -> new RuntimeException("Deltager not found with id: " + dto.getDeltagerId())));
        resultat.setDisciplin(disciplinRepository.findById(dto.getDisciplinId())
                .orElseThrow(() -> new RuntimeException("Disciplin not found with id: " + dto.getDisciplinId())));
        resultat.setResultatType(dto.getResultatType());
        resultat.setDato(dto.getDato());
        resultat.setResultatværdi(parseResultatværdi(dto.getResultatværdi(), dto.getResultatType()));
        return resultat;
    }

    private String formatResultatværdi(BigDecimal resultatværdi, String resultatType) {
        if ("Tid".equalsIgnoreCase(resultatType)) {
            long totalSeconds = resultatværdi.longValue();
            LocalTime time = LocalTime.ofSecondOfDay(totalSeconds);
            return TIME_FORMATTER.format(time);
        } else if ("Afstand".equalsIgnoreCase(resultatType)) {
            return DISTANCE_FORMATTER.format(resultatværdi) + " m";
        }
        return resultatværdi.toString();
    }

    private BigDecimal parseResultatværdi(String resultatværdi, String resultatType) {
        if ("Tid".equalsIgnoreCase(resultatType)) {
            // Convert time string "HH:MM:SS:SS" to seconds
            LocalTime time = LocalTime.parse(resultatværdi, TIME_FORMATTER);
            long totalSeconds = time.toSecondOfDay();
            return BigDecimal.valueOf(totalSeconds);
        } else if ("Afstand".equalsIgnoreCase(resultatType)) {
            // Replace comma with dot and remove the " m" suffix
            return new BigDecimal(resultatværdi.replace(" m", "").replace(",", "."));
        }
        return new BigDecimal(resultatværdi);
    }
}
