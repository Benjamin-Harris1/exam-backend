package edu.kea.exam.atletik.service;

import edu.kea.exam.atletik.dto.DisciplinDTO;

import java.util.List;

public interface DisciplinService {

    List<DisciplinDTO> getAllDiscipliner();
    DisciplinDTO createDisciplin(DisciplinDTO disciplinDTO);
    DisciplinDTO updateDisciplin(Long id, DisciplinDTO disciplinDTO);
    void deleteDisciplin(Long id);
}
