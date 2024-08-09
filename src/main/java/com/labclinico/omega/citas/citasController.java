package com.labclinico.omega.citas;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class citasController {

    private final citasService citasService;

    @Autowired
    public citasController(citasService citasService) {
        this.citasService = citasService;
    }

    @GetMapping
    public ResponseEntity<List<citasModel>> getAllCitas() {
        return ResponseEntity.ok(citasService.getAllCitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<citasModel> getCitasById(@PathVariable Long id) {
        return ResponseEntity.ok(citasService.getCitasById(id).get());
    }

    @PostMapping
    public ResponseEntity<citasModel> saveCitas(@RequestBody citasModel citas) {
        return ResponseEntity.ok(citasService.saveCitas(citas));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCitas(@PathVariable Long id) {
        citasService.deleteCitas(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCitas(@PathVariable Long id, @RequestBody citasModel citas) {
        citasService.updateCitas(id, citas);
        return ResponseEntity.ok().build();
    }

}
