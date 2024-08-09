package com.labclinico.omega.doctores;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
public class doctoresController {

    private final doctoresService doctoresService;

    @Autowired
    public doctoresController(doctoresService doctoresService) {
        this.doctoresService = doctoresService;
    }

    @GetMapping
    public ResponseEntity<List<doctoresModel>> getAllDoctores() {
        return ResponseEntity.ok(doctoresService.getAllDoctores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<doctoresModel> getDoctoresById(@PathVariable Long id) {
        return ResponseEntity.ok(doctoresService.getDoctoresById(id).get());
    }

    @PostMapping
    public ResponseEntity<doctoresModel> saveDoctores(@RequestBody doctoresModel doctores) {
        return ResponseEntity.ok(doctoresService.saveDoctores(doctores));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctores(@PathVariable Long id) {
        doctoresService.deleteDoctores(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDoctores(@PathVariable Long id, @RequestBody doctoresModel doctores) {
        doctoresService.updateDoctores(id, doctores);
        return ResponseEntity.ok().build();
    }

    

}
