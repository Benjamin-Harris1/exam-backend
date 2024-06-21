package edu.kea.exam.atletik.api;

import edu.kea.exam.atletik.dto.DeltagerDTO;
import edu.kea.exam.atletik.service.impl.DeltagerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeltagerController.class)
class DeltagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeltagerServiceImpl deltagerService;

    @Test
    public void testGetAllDeltagere() throws Exception {
        // Arrange
        List<DeltagerDTO> deltagere = new ArrayList<>();
        deltagere.add(new DeltagerDTO(1L, "John Doe", "Mand", 25, "Klub A", null));
        deltagere.add(new DeltagerDTO(2L, "Jane Doe", "Kvinde", 30, "Klub B", null));
        when(deltagerService.getAllDeltagere()).thenReturn(deltagere);

        // Act & Assert
        mockMvc.perform(get("/api/deltager"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].navn").value("John Doe"))
                .andExpect(jsonPath("$[1].navn").value("Jane Doe"));
    }

    @Test
    public void testGetDeltagerById() throws Exception {
        // Arrange
        DeltagerDTO deltagerDTO = new DeltagerDTO(1L, "John Doe", "Mand", 25, "Klub A", null);
        when(deltagerService.getDeltagerById(1L)).thenReturn(deltagerDTO);

        // Act & Assert
        mockMvc.perform(get("/api/deltager/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.navn").value("John Doe"))
                .andExpect(jsonPath("$.køn").value("Mand"))
                .andExpect(jsonPath("$.alder").value(25))
                .andExpect(jsonPath("$.klub").value("Klub A"));
    }

    @Test
    public void testGetDeltagerByName() throws Exception {
        // Arrange
        List<DeltagerDTO> deltagere = new ArrayList<>();
        deltagere.add(new DeltagerDTO(1L, "John Doe", "Mand", 25, "Klub A", null));
        when(deltagerService.getDeltagerByName("John Doe")).thenReturn(deltagere);

        // Act & Assert
        mockMvc.perform(get("/api/deltager/name/John Doe")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].navn").value("John Doe"));
    }

    @Test
    public void testGetFilteredDeltagere() throws Exception {
        // Arrange
        List<DeltagerDTO> deltagere = new ArrayList<>();
        deltagere.add(new DeltagerDTO(1L, "John Doe", "Mand", 25, "Klub A", null));
        when(deltagerService.getFilteredDeltagere("Mand", 20, 30, "Klub A", "100-meterløb")).thenReturn(deltagere);

        // Act & Assert
        mockMvc.perform(get("/api/deltager/filter")
                        .param("køn", "Mand")
                        .param("minAlder", "20")
                        .param("maxAlder", "30")
                        .param("klub", "Klub A")
                        .param("disciplin", "100-meterløb")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].navn").value("John Doe"));
    }


    @Test
    public void testUpdateDeltager() throws Exception {
        // Arrange
        DeltagerDTO deltagerDTO = new DeltagerDTO(1L, "John Doe", "Mand", 26, "Klub B", null);
        when(deltagerService.updateDeltager(anyLong(), any(DeltagerDTO.class))).thenReturn(deltagerDTO);

        // Act & Assert
        mockMvc.perform(put("/api/deltager/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"navn\": \"John Doe\", \"køn\": \"Mand\", \"alder\": 26, \"klub\": \"Klub B\", \"discipliner\": [{\"id\": 1, \"navn\": \"100-meterløb\", \"resultatType\": \"Tid\"}]}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.navn").value("John Doe"))
                .andExpect(jsonPath("$.køn").value("Mand"))
                .andExpect(jsonPath("$.alder").value(26))
                .andExpect(jsonPath("$.klub").value("Klub B"));
    }

    @Test
    public void testCreateDeltager() throws Exception {
        // Arrange
        DeltagerDTO deltagerDTO = new DeltagerDTO(1L, "John Doe", "Mand", 25, "Klub A", null);
        when(deltagerService.createDeltager(any(DeltagerDTO.class))).thenReturn(deltagerDTO);
    
        // Act & Assert
        mockMvc.perform(post("/api/deltager")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"navn\": \"John Doe\", \"køn\": \"Mand\", \"alder\": 25, \"klub\": \"Klub A\", \"discipliner\": [{\"id\": 1, \"navn\": \"100-meterløb\", \"resultatType\": \"Tid\"}]}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.navn").value("John Doe"))
                .andExpect(jsonPath("$.køn").value("Mand"))
                .andExpect(jsonPath("$.alder").value(25))
                .andExpect(jsonPath("$.klub").value("Klub A"));
    }


    @Test
    public void testDeleteDeltager() throws Exception {
        // Act & Assert
        mockMvc.perform(delete("/api/deltager/1"))
                .andExpect(status().isNoContent());

        verify(deltagerService, times(1)).deleteDeltager(1L);
    }
}