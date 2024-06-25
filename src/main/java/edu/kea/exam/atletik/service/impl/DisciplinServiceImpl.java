package edu.kea.exam.atletik.service.impl;

import edu.kea.exam.atletik.dto.DisciplinDTO;
import edu.kea.exam.atletik.entity.Deltager;
import edu.kea.exam.atletik.entity.Disciplin;
import edu.kea.exam.atletik.entity.Resultat;
import edu.kea.exam.atletik.mapper.DisciplinMapper;
import edu.kea.exam.atletik.repository.DeltagerRepository;
import edu.kea.exam.atletik.repository.DisciplinRepository;
import edu.kea.exam.atletik.repository.ResultatRepository;
import edu.kea.exam.atletik.service.DisciplinService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinServiceImpl implements DisciplinService {

    private final DisciplinRepository disciplinRepository;
    private final ResultatRepository resultatRepository;
    private final DeltagerRepository deltagerRepository;
    private final DisciplinMapper disciplinMapper;

    public DisciplinServiceImpl(DisciplinRepository disciplinRepository, ResultatRepository resultatRepository, DeltagerRepository deltagerRepository, DisciplinMapper disciplinMapper) {
        this.disciplinRepository = disciplinRepository;
        this.resultatRepository = resultatRepository;
        this.deltagerRepository = deltagerRepository;
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

        // Remove the disciplin from all associated deltagere
        List<Deltager> deltagere = deltagerRepository.findAll();
        for (Deltager deltager : deltagere) {
            if (deltager.getDiscipliner().contains(disciplin)) {
                deltager.getDiscipliner().remove(disciplin);
                deltagerRepository.save(deltager);
            }
        }

        // Delete all related resultater
        List<Resultat> resultater = resultatRepository.findByDisciplinId(id);
        resultatRepository.deleteAll(resultater);
    }
}
