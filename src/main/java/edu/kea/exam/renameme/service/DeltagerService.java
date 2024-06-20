package edu.kea.exam.renameme.service;

import edu.kea.exam.renameme.dto.DeltagerDTO;

import java.util.List;

public interface DeltagerService {
    List<DeltagerDTO> getAllDeltagere();
    DeltagerDTO getDeltagerById(Long id);
    List<DeltagerDTO> getDeltagerByName(String navn);
    List<DeltagerDTO> getFilteredDeltagere(String køn, Integer minAlder, Integer maxAlder, String klub, String disciplin);
    DeltagerDTO createDeltager(DeltagerDTO deltagerDTO);
    DeltagerDTO updateDeltager(Long id, DeltagerDTO deltagerDTO);
    void deleteDeltager(Long id);
}
