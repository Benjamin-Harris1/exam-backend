package edu.kea.exam.renameme.mapper;

import edu.kea.exam.renameme.dto.ResultatDTO;
import edu.kea.exam.renameme.entity.Deltager;
import edu.kea.exam.renameme.entity.Disciplin;
import edu.kea.exam.renameme.entity.Resultat;
import edu.kea.exam.renameme.repository.DeltagerRepository;
import edu.kea.exam.renameme.repository.DisciplinRepository;
import org.springframework.stereotype.Component;

@Component
public class ResultatMapper {

    private final DeltagerRepository deltagerRepository;
    private final DisciplinRepository disciplinRepository;

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
        dto.setResultatværdi(resultat.getResultatværdi());
        return dto;
    }

    public Resultat toEntity(ResultatDTO dto) {
        Resultat resultat = new Resultat();
        resultat.setId(dto.getId());
        Deltager deltager = deltagerRepository.findById(dto.getDeltagerId())
                .orElseThrow(() -> new RuntimeException("Deltager not found with id: " + dto.getDeltagerId()));
        Disciplin disciplin = disciplinRepository.findById(dto.getDisciplinId())
                .orElseThrow(() -> new RuntimeException("Disciplin not found with id: " + dto.getDisciplinId()));
        resultat.setDeltager(deltager);
        resultat.setDisciplin(disciplin);
        resultat.setResultatType(dto.getResultatType());
        resultat.setDato(dto.getDato());
        resultat.setResultatværdi(dto.getResultatværdi());
        return resultat;
    }
}
