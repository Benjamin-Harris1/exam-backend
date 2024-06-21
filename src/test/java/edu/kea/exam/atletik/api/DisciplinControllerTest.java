package edu.kea.exam.atletik.api;

import edu.kea.exam.atletik.dto.DisciplinDTO;
import edu.kea.exam.atletik.service.impl.DisciplinServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(DisciplinController.class)
class DisciplinControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DisciplinServiceImpl disciplinService;


    @Test
    public void testGetAllDiscipliner() throws Exception {
        // Arrange
        List<DisciplinDTO> discipliner = new ArrayList<>();
        discipliner.add(new DisciplinDTO(1L, "100-meterløb", "Tid"));
        discipliner.add(new DisciplinDTO(2L, "Længdespring", "Afstand"));
        when(disciplinService.getAllDiscipliner()).thenReturn(discipliner);

        // Act & Assert
        mockMvc.perform(get("/api/discipliner")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].navn").value("100-meterløb"))
                .andExpect(jsonPath("$[1].navn").value("Længdespring"));
    }

    @Test
    public void testCreateDisciplin() throws Exception {
        DisciplinDTO disciplinDTO = new DisciplinDTO(1L, "100-meterløb", "Tid");
        when(disciplinService.createDisciplin(any(DisciplinDTO.class))).thenReturn(disciplinDTO);

        String disciplinJson = "{\"navn\": \"100-meterløb\", \"resultatType\": \"Tid\"}";

        mockMvc.perform(post("/api/discipliner")
                .contentType(MediaType.APPLICATION_JSON)
                .content(disciplinJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.navn").value("100-meterløb"))
                .andExpect(jsonPath("$.resultatType").value("Tid"));
    }

    @Test
    public void testUpdateDisciplin() throws Exception {
        DisciplinDTO updatedDisciplinDTO = new DisciplinDTO(1L, "200-meterløb", "Afstand");
        when(disciplinService.updateDisciplin(anyLong(), any(DisciplinDTO.class))).thenReturn(updatedDisciplinDTO);

        String updatedDisciplinJson = "{\"navn\": \"200-meterløb\", \"resultatType\": \"Afstand\"}";

        mockMvc.perform(put("/api/discipliner/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedDisciplinJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.navn").value("200-meterløb"))
                .andExpect(jsonPath("$.resultatType").value("Afstand"));
    }

    @Test
    public void testDeleteDisciplin() throws Exception {
        doNothing().when(disciplinService).deleteDisciplin(anyLong());

        mockMvc.perform(delete("/api/discipliner/1"))
                .andExpect(status().isNoContent());
    }
    

}