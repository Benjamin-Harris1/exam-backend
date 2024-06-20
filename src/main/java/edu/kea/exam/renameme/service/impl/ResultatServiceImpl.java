package edu.kea.exam.renameme.service.impl;

import edu.kea.exam.renameme.dto.ResultatDTO;
import edu.kea.exam.renameme.entity.Deltager;
import edu.kea.exam.renameme.entity.Disciplin;
import edu.kea.exam.renameme.entity.Resultat;
import edu.kea.exam.renameme.mapper.ResultatMapper;
import edu.kea.exam.renameme.repository.DeltagerRepository;
import edu.kea.exam.renameme.repository.DisciplinRepository;
import edu.kea.exam.renameme.repository.ResultatRepository;
import edu.kea.exam.renameme.service.ResultatService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultatServiceImpl implements ResultatService {

    private final ResultatRepository resultatRepository;
    private final DeltagerRepository deltagerRepository;
    private final DisciplinRepository disciplinRepository;
    private final ResultatMapper resultatMapper;

    public ResultatServiceImpl(ResultatRepository resultatRepository, DeltagerRepository deltagerRepository, DisciplinRepository disciplinRepository, ResultatMapper resultatMapper) {
        this.resultatRepository = resultatRepository;
        this.deltagerRepository = deltagerRepository;
        this.disciplinRepository = disciplinRepository;
        this.resultatMapper = resultatMapper;
    }

    @Override
    public List<ResultatDTO> getAllResultater() {
        return resultatRepository.findAll().stream()
                .map(resultatMapper::toDTO)
                .toList();
    }

    @Override
    public List<ResultatDTO> getResultaterByDisciplin(Long disciplinId, String køn, Integer minAlder, Integer maxAlder) {
        List<Resultat> resultater = resultatRepository.findByDisciplinId(disciplinId);
    
        if (køn != null) {
            resultater = resultater.stream()
                    .filter(r -> r.getDeltager().getKøn().equalsIgnoreCase(køn))
                    .collect(Collectors.toList());
        }
    
        if (minAlder != null && maxAlder != null) {
            resultater = resultater.stream()
                    .filter(r -> r.getDeltager().getAlder() >= minAlder && r.getDeltager().getAlder() <= maxAlder)
                    .collect(Collectors.toList());
        }
    
        // Determine the sorting logic based on the resultatType
        if (!resultater.isEmpty() && "Tid".equalsIgnoreCase(resultater.get(0).getResultatType())) {
            // Sort from best to worst for 'Tid' (lower is better)
            resultater.sort(Comparator.comparing(Resultat::getResultatværdi));
        } else if (!resultater.isEmpty() && "Afstand".equalsIgnoreCase(resultater.get(0).getResultatType())) {
            // Sort from best to worst for 'Afstand' (higher is better)
            resultater.sort(Comparator.comparing(Resultat::getResultatværdi).reversed());
        }
    
        return resultater.stream()
                .map(resultatMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResultatDTO createResultat(ResultatDTO resultatDTO) {
        // Use helper method to validate that the deltager is associated with the discipline
        validateDeltagerDisciplinAssociation(resultatDTO.getDeltagerId(), resultatDTO.getDisciplinId());
        Resultat resultat = resultatMapper.toEntity(resultatDTO);
        return resultatMapper.toDTO(resultatRepository.save(resultat));
    }

    @Override
    public List<ResultatDTO> createResultater(List<ResultatDTO> resultatDTOs) {
        if (resultatDTOs.isEmpty()) {
            throw new IllegalArgumentException("ResultatDTO liste må ikke være tom");
        }

        // Get disciplinId from first resultatDTO in the list
        Long disciplinId = resultatDTOs.get(0).getDisciplinId();
        // Check if all resultatDTOs in the list have the same disciplinId
        boolean allSameDisciplin = resultatDTOs.stream()
                .allMatch(dto -> dto.getDisciplinId().equals(disciplinId));

        // If not - throw error
        if (!allSameDisciplin) {
            throw new IllegalArgumentException("Alle ResultatDTOs skal have samme disciplinId");
        }

        List<Resultat> resultater = resultatDTOs.stream()
                .map(resultatDTO -> {
                    validateDeltagerDisciplinAssociation(resultatDTO.getDeltagerId(), resultatDTO.getDisciplinId());
                    return resultatMapper.toEntity(resultatDTO);
                })
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

    private void validateDeltagerDisciplinAssociation(Long deltagerId, Long disciplinId) {
        Deltager deltager = deltagerRepository.findById(deltagerId)
                .orElseThrow(() -> new RuntimeException("Deltager not found with id: " + deltagerId));
        Disciplin disciplin = disciplinRepository.findById(disciplinId)
                .orElseThrow(() -> new RuntimeException("Disciplin not found with id: " + disciplinId));

        // Validate that the deltager is associated with the disciplin
        if (!deltager.getDiscipliner().contains(disciplin)) {
            throw new IllegalArgumentException("Deltager is not associated with the given disciplin");
        }
    }
}
