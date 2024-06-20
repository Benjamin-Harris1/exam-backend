package edu.kea.exam.renameme.service.impl;

import edu.kea.exam.renameme.dto.ResultatDTO;
import edu.kea.exam.renameme.entity.Resultat;
import edu.kea.exam.renameme.mapper.ResultatMapper;
import edu.kea.exam.renameme.repository.ResultatRepository;
import edu.kea.exam.renameme.service.ResultatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultatServiceImpl implements ResultatService {

    private final ResultatRepository resultatRepository;
    private final ResultatMapper resultatMapper;

    public ResultatServiceImpl(ResultatRepository resultatRepository, ResultatMapper resultatMapper) {
        this.resultatRepository = resultatRepository;
        this.resultatMapper = resultatMapper;
    }

    @Override
    public List<ResultatDTO> getAllResultater() {
        return resultatRepository.findAll().stream()
                .map(resultatMapper::toDTO)
                .toList();
    }

    @Override
    public List<ResultatDTO> getResultaterByDiscipline(Long disciplineId, String køn, int alderFra, int alderTil) {
        return resultatRepository.findByDisciplinIdAndDeltagerKønAndDeltagerAlderBetween(disciplineId, køn, alderFra, alderTil).stream()
                .map(resultatMapper::toDTO)
                .toList();
    }

    @Override
    public ResultatDTO createResultat(ResultatDTO resultatDTO) {
        Resultat resultat = resultatMapper.toEntity(resultatDTO);
        return resultatMapper.toDTO(resultatRepository.save(resultat));
    }

    @Override
    public List<ResultatDTO> createResultater(List<ResultatDTO> resultatDTOs) {
        List<Resultat> resultater = resultatDTOs.stream()
                .map(resultatMapper::toEntity)
                .collect(Collectors.toList());
        return resultatRepository.saveAll(resultater).stream()
                .map(resultatMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResultatDTO updateResultat(Long id, ResultatDTO resultatDTO) {
        Optional<Resultat> existingResultat = resultatRepository.findById(id);
        if (existingResultat.isEmpty()) {
            throw new RuntimeException("Resultat med id " + id + " ikke fundet");
        }

        Resultat resultat = resultatMapper.toEntity(resultatDTO);
        resultat.setId(id);
        Resultat updatedResultat = resultatRepository.save(resultat);
        return resultatMapper.toDTO(updatedResultat);
    }

    @Override
    public void deleteResultat(Long id) {
        Resultat resultat = resultatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resultat ikke fundet"));
        resultatRepository.delete(resultat);
    }
}
