package edu.kea.exam.atletik.mapper;

import edu.kea.exam.atletik.dto.DisciplinDTO;
import edu.kea.exam.atletik.entity.Disciplin;
import org.springframework.stereotype.Component;


@Component
public class DisciplinMapper {

    public DisciplinDTO toDTO(Disciplin disciplin) {
        DisciplinDTO dto = new DisciplinDTO();
        dto.setId(disciplin.getId());
        dto.setNavn(disciplin.getNavn());
        dto.setResultatType(disciplin.getResultatType());
        return dto;
    }

    // Not used yet. Will be used when DisciplinService is implemented
    public Disciplin toEntity(DisciplinDTO dto) {
        Disciplin disciplin = new Disciplin();
        disciplin.setId(dto.getId());
        disciplin.setNavn(dto.getNavn());
        disciplin.setResultatType(dto.getResultatType());
        return disciplin;
    }
}
