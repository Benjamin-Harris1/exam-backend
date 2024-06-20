package edu.kea.exam.renameme.api;

import edu.kea.exam.renameme.dto.DisciplinDTO;
import edu.kea.exam.renameme.service.impl.DisciplinServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DisciplinController.class)
class DisciplinControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DisciplinServiceImpl disciplinService;

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