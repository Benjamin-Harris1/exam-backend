package edu.kea.exam.atletik.api;

import edu.kea.exam.atletik.dto.DisciplinDTO;
import edu.kea.exam.atletik.service.DisciplinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discipliner")
public class DisciplinController {

    private final DisciplinService disciplinService;

    public DisciplinController(DisciplinService disciplinService) {
        this.disciplinService = disciplinService;
    }

    @GetMapping
    public ResponseEntity<List<DisciplinDTO>> getAllDiscipliner(){
        return ResponseEntity.ok().body(disciplinService.getAllDiscipliner());
    }

    @PostMapping
    public ResponseEntity<DisciplinDTO> createDisciplin(@RequestBody DisciplinDTO disciplinDTO){
        return ResponseEntity.ok().body(disciplinService.createDisciplin(disciplinDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinDTO> updateDisciplin(@PathVariable Long id, @RequestBody DisciplinDTO disciplinDTO){
        return ResponseEntity.ok().body(disciplinService.updateDisciplin(id, disciplinDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisciplin(@PathVariable Long id){
        disciplinService.deleteDisciplin(id);
        return ResponseEntity.noContent().build();
    }
}
