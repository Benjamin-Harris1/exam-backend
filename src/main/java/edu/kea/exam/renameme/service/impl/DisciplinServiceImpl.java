package edu.kea.exam.renameme.service.impl;

import edu.kea.exam.renameme.dto.DisciplinDTO;
import edu.kea.exam.renameme.entity.Disciplin;
import edu.kea.exam.renameme.service.DisciplinService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinServiceImpl implements DisciplinService {

    @Override
    public List<DisciplinDTO> getAllDiscipliner() {
        return null;
    }

    @Override
    public DisciplinDTO getDisciplinById(Long id) {
        return null;
    }

    @Override
    public DisciplinDTO createDisciplin(DisciplinDTO disciplinDTO) {
        return null;
    }

    @Override
    public DisciplinDTO updateDisciplin(Long id, DisciplinDTO disciplinDTO) {
        return null;
    }

    @Override
    public void deleteDisciplin(Long id) {

    }

    @Override
    public DisciplinDTO convertToDTO(Disciplin disciplin) {
        return null;
    }

    @Override
    public Disciplin convertToEntity(DisciplinDTO disciplinDTO) {
        return null;
    }
}
