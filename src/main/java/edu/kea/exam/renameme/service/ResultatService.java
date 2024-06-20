package edu.kea.exam.renameme.service;

import edu.kea.exam.renameme.dto.ResultatDTO;

import java.util.List;

public interface ResultatService {
    List<ResultatDTO> getAllResultater();

    List<ResultatDTO> getResultaterByDisciplin(Long disciplinId, String køn, Integer minAlder, Integer maxAlder);
    ResultatDTO createResultat(ResultatDTO resultatDTO);

    List<ResultatDTO> createResultater(List<ResultatDTO> resultatDTOs);
    ResultatDTO updateResultat(Long id, ResultatDTO resultatDTO);
    void deleteResultat(Long id);

}
