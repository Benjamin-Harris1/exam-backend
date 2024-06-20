package edu.kea.exam.renameme.api;

import edu.kea.exam.renameme.dto.DeltagerDTO;
import edu.kea.exam.renameme.service.impl.DeltagerServiceImpl;
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