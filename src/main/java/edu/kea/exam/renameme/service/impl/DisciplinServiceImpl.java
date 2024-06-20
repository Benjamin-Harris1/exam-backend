package edu.kea.exam.renameme.service.impl;

import edu.kea.exam.renameme.dto.DisciplinDTO;
import edu.kea.exam.renameme.entity.Disciplin;
import edu.kea.exam.renameme.mapper.DisciplinMapper;
import edu.kea.exam.renameme.repository.DisciplinRepository;
import edu.kea.exam.renameme.service.DisciplinService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinServiceImpl implements DisciplinService {

    private final DisciplinRepository disciplinRepository;
    private final DisciplinMapper disciplinMapper;

    public DisciplinServiceImpl(DisciplinRepository disciplinRepository, DisciplinMapper disciplinMapper) {
        this.disciplinRepository = disciplinRepository;
        this.disciplinMapper = disciplinMapper;
    }

    @Override
    public List<DisciplinDTO> getAllDiscipliner() {
        return disciplinRepository.findAllByIsActiveTrue().stream()
                .map(disciplinMapper::toDTO)
                .toList();
    }

    @Override
    public DisciplinDTO createDisciplin(DisciplinDTO disciplinDTO) {
        Disciplin disciplin = disciplinMapper.toEntity(disciplinDTO);
        disciplin.setActive(true);
        return disciplinMapper.toDTO(disciplinRepository.save(disciplin));
    }

    @Override
    public DisciplinDTO updateDisciplin(Long id, DisciplinDTO disciplinDTO) {
        Optional<Disciplin> existingDisciplin = disciplinRepository.findById(id);
        if (existingDisciplin.isEmpty()) {
            throw new RuntimeException("Disciplin med id " + id + " ikke fundet");
        }
        Disciplin disciplin = disciplinMapper.toEntity(disciplinDTO);
        disciplin.setId(id);
        disciplin.setActive(true);
        Disciplin updatedDisciplin = disciplinRepository.save(disciplin);
        return disciplinMapper.toDTO(updatedDisciplin);
    }

    @Override
    public void deleteDisciplin(Long id) {
        Disciplin disciplin = disciplinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplin ikke fundet"));
        disciplin.setActive(false);
        disciplinRepository.save(disciplin);
    }
}
