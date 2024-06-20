package edu.kea.exam.renameme.service;

import edu.kea.exam.renameme.dto.ResultatDTO;
import edu.kea.exam.renameme.entity.Resultat;

import java.util.List;

public interface ResultatService {
    List<ResultatDTO> getAllResultater();
    ResultatDTO createResultat(ResultatDTO resultatDTO);
    ResultatDTO updateResultat(Long id, ResultatDTO resultatDTO);
    void deleteResultat(Long id);
    ResultatDTO convertToDTO(Resultat resultat);
    Resultat convertToEntity(ResultatDTO resultatDTO);
}
