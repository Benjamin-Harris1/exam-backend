package edu.kea.exam.renameme.service;

import edu.kea.exam.renameme.dto.DisciplinDTO;
import edu.kea.exam.renameme.entity.Disciplin;

import java.util.List;

public interface DisciplinService {
    DisciplinDTO createDisciplin(DisciplinDTO disciplinDTO);
    DisciplinDTO updateDisciplin(Long id, DisciplinDTO disciplinDTO);
    void deleteDisciplin(Long id);
}
