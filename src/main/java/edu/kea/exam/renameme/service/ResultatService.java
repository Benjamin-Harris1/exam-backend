package edu.kea.exam.renameme.service;

import edu.kea.exam.renameme.dto.ResultatDTO;
import edu.kea.exam.renameme.entity.Resultat;

import java.util.List;

public interface ResultatService {
    List<ResultatDTO> getAllResultater();

    List<ResultatDTO> getResultaterByDiscipline(Long disciplineId, String køn, int alderFra, int alderTil);
    ResultatDTO createResultat(ResultatDTO resultatDTO);

    List<ResultatDTO> createResultater(List<ResultatDTO> resultatDTOs);
    ResultatDTO updateResultat(Long id, ResultatDTO resultatDTO);
    void deleteResultat(Long id);

}
