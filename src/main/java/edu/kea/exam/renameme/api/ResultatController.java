package edu.kea.exam.renameme.api;

import edu.kea.exam.renameme.dto.ResultatDTO;
import edu.kea.exam.renameme.service.ResultatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resultater")
public class ResultatController {

    private final ResultatService resultatService;

    public ResultatController(ResultatService resultatService) {
        this.resultatService = resultatService;
    }

    @GetMapping
    public ResponseEntity<List<ResultatDTO>> getAllResultater(){
        return ResponseEntity.ok().body(resultatService.getAllResultater());
    }

    @GetMapping("/disciplin/{disciplinId}")
    public ResponseEntity<List<ResultatDTO>> getResultaterByDisciplin(
            @PathVariable Long disciplinId,
            @RequestParam(required = false) String køn,
            @RequestParam(required = false) Integer minAlder,
            @RequestParam(required = false) Integer maxAlder) {
        return ResponseEntity.ok().body(resultatService.getResultaterByDisciplin(disciplinId, køn, minAlder, maxAlder));
    }

    @PostMapping
    public ResponseEntity<ResultatDTO> createResultat(@RequestBody ResultatDTO resultatDTO){
        return ResponseEntity.ok().body(resultatService.createResultat(resultatDTO));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<ResultatDTO>> createResultater(@RequestBody List<ResultatDTO> resultatDTOs){
        return ResponseEntity.ok().body(resultatService.createResultater(resultatDTOs));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultatDTO> updateResultat(@PathVariable Long id, @RequestBody ResultatDTO resultatDTO){
        return ResponseEntity.ok().body(resultatService.updateResultat(id, resultatDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultat(@PathVariable Long id){
        resultatService.deleteResultat(id);
        return ResponseEntity.noContent().build();
    }
}
