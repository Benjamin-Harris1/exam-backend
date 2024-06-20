package edu.kea.exam.renameme.service;

import edu.kea.exam.renameme.dto.DisciplinDTO;

import java.util.List;

public interface DisciplinService {

    List<DisciplinDTO> getAllDiscipliner();
    DisciplinDTO createDisciplin(DisciplinDTO disciplinDTO);
    DisciplinDTO updateDisciplin(Long id, DisciplinDTO disciplinDTO);
    void deleteDisciplin(Long id);
}
