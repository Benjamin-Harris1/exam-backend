package edu.kea.exam.renameme.service.impl;

import edu.kea.exam.renameme.dto.DeltagerDTO;
import edu.kea.exam.renameme.entity.Deltager;
import edu.kea.exam.renameme.mapper.DeltagerMapper;
import edu.kea.exam.renameme.repository.DeltagerRepository;
import edu.kea.exam.renameme.service.DeltagerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeltagerServiceImpl implements DeltagerService {

    private final DeltagerRepository deltagerRepository;
    private final DeltagerMapper deltagerMapper;

    public DeltagerServiceImpl(DeltagerRepository deltagerRepository, DeltagerMapper deltagerMapper) {
        this.deltagerRepository = deltagerRepository;
        this.deltagerMapper = deltagerMapper;
    }

    @Override
    public List<DeltagerDTO> getAllDeltagere() {
        return deltagerRepository.findAllByIsActiveTrue().stream()
                .map(deltagerMapper::toDTO)
                .toList();
    }

    @Override
    public DeltagerDTO getDeltagerById(Long id) {
        Optional<Deltager> deltager = deltagerRepository.findById(id)
                .filter(Deltager::isActive);
        return deltager.map(deltagerMapper::toDTO).orElseThrow(() -> new RuntimeException("Deltager ikke fundet"));
    }

    @Override
    public DeltagerDTO createDeltager(DeltagerDTO deltagerDTO) {
        Deltager deltager = deltagerMapper.toEntity(deltagerDTO);
        deltager.setActive(true);
        return deltagerMapper.toDTO(deltagerRepository.save(deltager));
    }

    @Override
    public DeltagerDTO updateDeltager(Long id, DeltagerDTO deltagerDTO) {
        Optional<Deltager> existingDeltager = deltagerRepository.findById(id);
        if (existingDeltager.isEmpty()) {
            throw new RuntimeException("Deltager med id " + id + " ikke fundet");
        }

        Deltager deltager = deltagerMapper.toEntity(deltagerDTO);
        deltager.setId(id);
        deltager.setActive(true);
        Deltager updatedDeltager = deltagerRepository.save(deltager);
        return deltagerMapper.toDTO(updatedDeltager);
    }

    @Override
    public void deleteDeltager(Long id) {
        Deltager deltager = deltagerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deltager ikke fundet"));
        deltager.setActive(false);
        deltagerRepository.save(deltager);

    }
}
