package edu.kea.exam.renameme.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import edu.kea.exam.renameme.dto.ResultatDTO;
import edu.kea.exam.renameme.service.impl.ResultatServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@WebMvcTest(ResultatController.class)
class ResultatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ResultatServiceImpl resultatService;

    @Test
    void testCreateResultat() throws Exception {
        ResultatDTO resultatDTO = new ResultatDTO(1L, 1L, 1L, "Tid", LocalDate.now(), "00:10:00");
        when(resultatService.createResultat(any(ResultatDTO.class))).thenReturn(resultatDTO);

        String resultatJson = "{\"deltagerId\": 1, \"disciplinId\": 1, \"resultatType\": \"Tid\", \"dato\": \"2023-10-10\", \"resultatværdi\": \"00:10:00\"}";

        mockMvc.perform(post("/api/resultater")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(resultatJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.resultatværdi").value("00:10:00"));
    }

    @Test
    void testCreateResultater() throws Exception {
        ResultatDTO resultatDTO1 = new ResultatDTO(1L, 1L, 1L, "Tid", LocalDate.now(), "00:10:00");
        ResultatDTO resultatDTO2 = new ResultatDTO(2L, 1L, 1L, "Tid", LocalDate.now(), "00:09:50");
        List<ResultatDTO> resultatDTOs = List.of(resultatDTO1, resultatDTO2);
        when(resultatService.createResultater(anyList())).thenReturn(resultatDTOs);

        String resultatJson = "[{\"deltagerId\": 1, \"disciplinId\": 1, \"resultatType\": \"Tid\", \"dato\": \"2023-10-10\", \"resultatværdi\": \"00:10:00\"}," +
                "{\"deltagerId\": 1, \"disciplinId\": 1, \"resultatType\": \"Tid\", \"dato\": \"2023-10-10\", \"resultatværdi\": \"00:09:50\"}]";

        mockMvc.perform(post("/api/resultater/batch")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(resultatJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].resultatværdi").value("00:10:00"))
                .andExpect(jsonPath("$[1].resultatværdi").value("00:09:50"));
    }

    @Test
    void testGetAllResultater() throws Exception {
        ResultatDTO resultatDTO1 = new ResultatDTO(1L, 1L, 1L, "Tid", LocalDate.now(), "00:10:00");
        ResultatDTO resultatDTO2 = new ResultatDTO(2L, 1L, 1L, "Tid", LocalDate.now(), "00:09:50");
        List<ResultatDTO> resultatDTOs = List.of(resultatDTO1, resultatDTO2);
        when(resultatService.getAllResultater()).thenReturn(resultatDTOs);

        mockMvc.perform(get("/api/resultater")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].resultatværdi").value("00:10:00"))
                .andExpect(jsonPath("$[1].resultatværdi").value("00:09:50"));
    }

        @Test
    void testGetResultaterByDisciplin() throws Exception {
        ResultatDTO resultatDTO1 = new ResultatDTO(1L, 1L, 1L, "Tid", LocalDate.now(), "00:10:00");
        ResultatDTO resultatDTO2 = new ResultatDTO(2L, 1L, 1L, "Tid", LocalDate.now(), "00:09:50");
        List<ResultatDTO> resultatDTOs = List.of(resultatDTO1, resultatDTO2);
        when(resultatService.getResultaterByDisciplin(anyLong(), any(), any(), any())).thenReturn(resultatDTOs);

        mockMvc.perform(get("/api/resultater/disciplin/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].resultatværdi").value("00:10:00"))
                .andExpect(jsonPath("$[1].resultatværdi").value("00:09:50"));
    }

    @Test
    void testUpdateResultat() throws Exception {
        ResultatDTO resultatDTO = new ResultatDTO(1L, 1L, 1L, "Tid", LocalDate.now(), "00:09:50");
        when(resultatService.updateResultat(anyLong(), any(ResultatDTO.class))).thenReturn(resultatDTO);

        String resultatJson = "{\"deltagerId\": 1, \"disciplinId\": 1, \"resultatType\": \"Tid\", \"dato\": \"2023-10-10\", \"resultatværdi\": \"00:09:50\"}";

        mockMvc.perform(put("/api/resultater/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(resultatJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.resultatværdi").value("00:09:50"));
    }

}