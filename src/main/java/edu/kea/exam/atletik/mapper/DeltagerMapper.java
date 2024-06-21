package edu.kea.exam.atletik.mapper;

import edu.kea.exam.atletik.dto.DeltagerDTO;
import edu.kea.exam.atletik.entity.Deltager;
import edu.kea.exam.atletik.entity.Disciplin;
import edu.kea.exam.atletik.repository.DisciplinRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeltagerMapper {

    private final DisciplinRepository disciplinRepository;
    private final DisciplinMapper disciplinMapper;

    public DeltagerMapper(DisciplinRepository disciplinRepository, DisciplinMapper disciplinMapper) {
        this.disciplinRepository = disciplinRepository;
        this.disciplinMapper = disciplinMapper;
    }

    public DeltagerDTO toDTO(Deltager deltager) {
        DeltagerDTO dto = new DeltagerDTO();
        dto.setId(deltager.getId());
        dto.setNavn(deltager.getNavn());
        dto.setKøn(deltager.getKøn());
        dto.setAlder(deltager.getAlder());
        dto.setKlub(deltager.getKlub());
        dto.setDiscipliner(deltager.getDiscipliner().stream()
                .map(disciplinMapper::toDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    public Deltager toEntity(DeltagerDTO dto) {
        Deltager deltager = new Deltager();
        deltager.setId(dto.getId());
        deltager.setNavn(dto.getNavn());
        deltager.setKøn(dto.getKøn());
        deltager.setAlder(dto.getAlder());
        deltager.setKlub(dto.getKlub());
        List<Disciplin> discipliner = dto.getDiscipliner().stream()
                .map(disciplinDTO -> disciplinRepository.findById(disciplinDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Disciplin not found with id: " + disciplinDTO.getId())))
                .collect(Collectors.toList());
        deltager.setDiscipliner(discipliner);
        return deltager;
    }
}
