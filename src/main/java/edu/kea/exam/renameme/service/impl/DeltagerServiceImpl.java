package edu.kea.exam.renameme.service.impl;

import edu.kea.exam.renameme.dto.DeltagerDTO;
import edu.kea.exam.renameme.entity.Deltager;
import edu.kea.exam.renameme.service.DeltagerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeltagerServiceImpl implements DeltagerService {

    @Override
    public List<DeltagerDTO> getAllDeltagere() {
        return null;
    }

    @Override
    public DeltagerDTO getDeltagerById(Long id) {
        return null;
    }

    @Override
    public DeltagerDTO createDeltager(DeltagerDTO deltagerDTO) {
        return null;
    }

    @Override
    public DeltagerDTO updateDeltager(Long id, DeltagerDTO deltagerDTO) {
        return null;
    }

    @Override
    public void deleteDeltager(Long id) {

    }

    @Override
    public DeltagerDTO convertToDTO(Deltager deltager) {
        return null;
    }

    @Override
    public Deltager convertToEntity(DeltagerDTO deltagerDTO) {
        return null;
    }
}
