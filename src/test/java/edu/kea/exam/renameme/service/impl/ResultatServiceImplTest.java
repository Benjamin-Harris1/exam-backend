package edu.kea.exam.renameme.service.impl;

import edu.kea.exam.renameme.dto.ResultatDTO;
import edu.kea.exam.renameme.entity.Deltager;
import edu.kea.exam.renameme.entity.Disciplin;
import edu.kea.exam.renameme.entity.Resultat;
import edu.kea.exam.renameme.mapper.ResultatMapper;
import edu.kea.exam.renameme.repository.DeltagerRepository;
import edu.kea.exam.renameme.repository.DisciplinRepository;
import edu.kea.exam.renameme.repository.ResultatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

class ResultatServiceImplTest {

    @Mock
    private ResultatRepository resultatRepository;

    @Mock
    private DeltagerRepository deltagerRepository;

    @Mock
    private DisciplinRepository disciplinRepository;

    @Mock
    private ResultatMapper resultatMapper;

    @InjectMocks
    private ResultatServiceImpl resultatService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateResultat_ValidAssociation() {
        ResultatDTO resultatDTO = new ResultatDTO(1L, 1L, 1L, "Tid", LocalDate.now(), "00:10:00");
        Disciplin disciplin = new Disciplin(1L, "100-meterløb", "Tid");
        Deltager deltager = new Deltager(1L, "John Doe", "Mand", 25, "Klub A", Collections.singletonList(disciplin));
        Resultat resultat = new Resultat(1L, deltager, disciplin, "Tid", LocalDate.now(), "00:10:00");

        when(deltagerRepository.findById(1L)).thenReturn(Optional.of(deltager));
        when(disciplinRepository.findById(1L)).thenReturn(Optional.of(disciplin));
        when(resultatMapper.toEntity(resultatDTO)).thenReturn(resultat);
        when(resultatRepository.save(resultat)).thenReturn(resultat);
        when(resultatMapper.toDTO(resultat)).thenReturn(resultatDTO);

        ResultatDTO createdResultat = resultatService.createResultat(resultatDTO);

        assertNotNull(createdResultat);
        assertEquals(resultatDTO.getResultatværdi(), createdResultat.getResultatværdi());
    }

    @Test
    void testCreateResultat_InvalidAssociation() {
        ResultatDTO resultatDTO = new ResultatDTO(1L, 1L, 2L, "Tid", LocalDate.now(), "00:10:00");
        Deltager deltager = new Deltager(1L, "John Doe", "Mand", 25, "Klub A", Collections.singletonList(new Disciplin(1L, "100-meterløb", "Tid")));
        Disciplin disciplin = new Disciplin(2L, "Længdespring", "Afstand");

        when(deltagerRepository.findById(1L)).thenReturn(Optional.of(deltager));
        when(disciplinRepository.findById(2L)).thenReturn(Optional.of(disciplin));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            resultatService.createResultat(resultatDTO);
        });

        assertEquals("Deltager er ikke tilknyttet denne disciplin", exception.getMessage());
    }

    @Test
    void testCreateResultater_ValidAssociation() {
        ResultatDTO resultatDTO1 = new ResultatDTO(1L, 1L, 1L, "Tid", LocalDate.now(), "00:10:00");
        ResultatDTO resultatDTO2 = new ResultatDTO(2L, 1L, 1L, "Tid", LocalDate.now(), "00:09:50");
        List<ResultatDTO> resultatDTOs = List.of(resultatDTO1, resultatDTO2);
        Disciplin disciplin = new Disciplin(1L, "100-meterløb", "Tid");
        Deltager deltager = new Deltager(1L, "John Doe", "Mand", 25, "Klub A", Collections.singletonList(disciplin));
        Resultat resultat1 = new Resultat(1L, deltager, disciplin, "Tid", LocalDate.now(), "00:10:00");
        Resultat resultat2 = new Resultat(2L, deltager, disciplin, "Tid", LocalDate.now(), "00:09:50");

        when(deltagerRepository.findById(1L)).thenReturn(Optional.of(deltager));
        when(disciplinRepository.findById(1L)).thenReturn(Optional.of(disciplin));
        when(resultatMapper.toEntity(resultatDTO1)).thenReturn(resultat1);
        when(resultatMapper.toEntity(resultatDTO2)).thenReturn(resultat2);
        when(resultatRepository.saveAll(anyList())).thenReturn(List.of(resultat1, resultat2));
        when(resultatMapper.toDTO(resultat1)).thenReturn(resultatDTO1);
        when(resultatMapper.toDTO(resultat2)).thenReturn(resultatDTO2);

        List<ResultatDTO> createdResultater = resultatService.createResultater(resultatDTOs);

        assertNotNull(createdResultater);
        assertEquals(2, createdResultater.size());
        assertEquals(resultatDTO1.getResultatværdi(), createdResultater.get(0).getResultatværdi());
        assertEquals(resultatDTO2.getResultatværdi(), createdResultater.get(1).getResultatværdi());
    }

    @Test
    void testCreateResultater_InvalidAssociations() {
        ResultatDTO resultatDTO1 = new ResultatDTO(1L, 1L, 1L, "Tid", LocalDate.now(), "00:10:00");
        ResultatDTO resultatDTO2 = new ResultatDTO(2L, 1L, 1L, "Tid", LocalDate.now(), "00:09:50");
        List<ResultatDTO> resultatDTOs = List.of(resultatDTO1, resultatDTO2);
        Disciplin disciplin = new Disciplin(1L, "100-meterløb", "Tid");
        Deltager deltager = new Deltager(1L, "John Doe", "Mand", 25, "Klub A", Collections.singletonList(new Disciplin(2L, "Længdespring", "Afstand")));

        when(deltagerRepository.findById(1L)).thenReturn(Optional.of(deltager));
        when(disciplinRepository.findById(1L)).thenReturn(Optional.of(disciplin));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            resultatService.createResultater(resultatDTOs);
        });

        assertEquals("Deltager er ikke tilknyttet denne disciplin", exception.getMessage());
    }

    @Test
    void testCreateResultater_DifferentDisciplinIds() {
        ResultatDTO resultatDTO1 = new ResultatDTO(1L, 1L, 1L, "Tid", LocalDate.now(), "00:10:00");
        ResultatDTO resultatDTO2 = new ResultatDTO(2L, 1L, 2L, "Tid", LocalDate.now(), "00:09:50");
        List<ResultatDTO> resultatDTOs = List.of(resultatDTO1, resultatDTO2);
        Deltager deltager = new Deltager(1L, "John Doe", "Mand", 25, "Klub A", Collections.singletonList(new Disciplin(1L, "100-meterløb", "Tid")));
        Disciplin disciplin1 = new Disciplin(1L, "100-meterløb", "Tid");
        Disciplin disciplin2 = new Disciplin(2L, "Længdespring", "Afstand");

        when(deltagerRepository.findById(1L)).thenReturn(Optional.of(deltager));
        when(disciplinRepository.findById(1L)).thenReturn(Optional.of(disciplin1));
        when(disciplinRepository.findById(2L)).thenReturn(Optional.of(disciplin2));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            resultatService.createResultater(resultatDTOs);
        });

        assertEquals("Alle ResultatDTOs skal have samme disciplinId", exception.getMessage());
    }
}
