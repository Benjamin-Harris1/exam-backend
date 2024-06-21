package edu.kea.exam.atletik.api;

import edu.kea.exam.atletik.dto.DeltagerDTO;
import edu.kea.exam.atletik.service.impl.DeltagerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deltager")
public class DeltagerController {

    private final DeltagerServiceImpl deltagerService;

    public DeltagerController(DeltagerServiceImpl deltagerService) {
        this.deltagerService = deltagerService;
    }

    @GetMapping
    public ResponseEntity<List<DeltagerDTO>> getAllDeltagere(){
        return ResponseEntity.ok().body(deltagerService.getAllDeltagere());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeltagerDTO> getDeltagerById(@PathVariable Long id){
        return ResponseEntity.ok().body(deltagerService.getDeltagerById(id));
    }

    @GetMapping("/name/{navn}")
    public ResponseEntity<List<DeltagerDTO>> getDeltagerByName(@PathVariable String navn){
        return ResponseEntity.ok().body(deltagerService.getDeltagerByName(navn));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<DeltagerDTO>> getFilteredDeltagere(
        @RequestParam(required = false) String køn,
        @RequestParam(required = false) Integer minAlder,
        @RequestParam(required = false) Integer maxAlder,
        @RequestParam(required = false) String klub,
        @RequestParam(required = false) String disciplin) {
    return ResponseEntity.ok().body(deltagerService.getFilteredDeltagere(køn, minAlder, maxAlder, klub, disciplin));
    }

    @PostMapping
    public ResponseEntity<DeltagerDTO> createDeltager(@RequestBody DeltagerDTO deltagerDTO){
        return ResponseEntity.ok().body(deltagerService.createDeltager(deltagerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeltagerDTO> updateDeltager(@PathVariable Long id, @RequestBody DeltagerDTO deltagerDTO){
        return ResponseEntity.ok().body(deltagerService.updateDeltager(id,deltagerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeltagerDTO> deleteDeltager(@PathVariable Long id){
        deltagerService.deleteDeltager(id);
        return ResponseEntity.noContent().build();
    }
}
