package edu.kea.exam.renameme.service.impl;

import edu.kea.exam.renameme.dto.DeltagerDTO;
import edu.kea.exam.renameme.entity.Deltager;
import edu.kea.exam.renameme.mapper.DeltagerMapper;
import edu.kea.exam.renameme.repository.DeltagerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class DeltagerServiceImplTest {

    @Mock
    private DeltagerRepository deltagerRepository;

    @Mock
    private DeltagerMapper deltagerMapper;

    @InjectMocks
    private DeltagerServiceImpl deltagerService;

    public DeltagerServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateDeltager() {
        // Arrange
        DeltagerDTO deltagerDTO = new DeltagerDTO();
        Deltager deltager = new Deltager();
        when(deltagerMapper.toEntity(any(DeltagerDTO.class))).thenReturn(deltager);
        when(deltagerRepository.save(any(Deltager.class))).thenReturn(deltager);
        when(deltagerMapper.toDTO(any(Deltager.class))).thenReturn(deltagerDTO);

        // Act
        DeltagerDTO result = deltagerService.createDeltager(deltagerDTO);

        // Assert
        assertEquals(deltagerDTO, result);
        verify(deltagerRepository, times(1)).save(deltager);
    }

    @Test
    public void testGetDeltagerById() {
        // Arrange
        Deltager deltager = new Deltager();
        deltager.setActive(true); // Ensure the Deltager is active
        DeltagerDTO deltagerDTO = new DeltagerDTO();
        when(deltagerRepository.findById(anyLong())).thenReturn(Optional.of(deltager));
        when(deltagerMapper.toDTO(any(Deltager.class))).thenReturn(deltagerDTO);

        // Act
        DeltagerDTO result = deltagerService.getDeltagerById(1L);

        // Assert
        assertEquals(deltagerDTO, result);
            verify(deltagerRepository, times(1)).findById(1L);
        }

}