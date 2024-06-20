package edu.kea.exam.renameme.service.impl;

import edu.kea.exam.renameme.dto.ResultatDTO;
import edu.kea.exam.renameme.entity.Resultat;
import edu.kea.exam.renameme.service.ResultatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultatServiceImpl implements ResultatService {

    @Override
    public List<ResultatDTO> getAllResultater() {
        return null;
    }

    @Override
    public ResultatDTO createResultat(ResultatDTO resultatDTO) {
        return null;
    }

    @Override
    public ResultatDTO updateResultat(Long id, ResultatDTO resultatDTO) {
        return null;
    }

    @Override
    public void deleteResultat(Long id) {

    }

    @Override
    public ResultatDTO convertToDTO(Resultat resultat) {
        return null;
    }

    @Override
    public Resultat convertToEntity(ResultatDTO resultatDTO) {
        return null;
    }
}
