package com.labclinico.omega.muestra;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/muestras")
public class muestraController {

    private final muestraService muestraService;

    @Autowired
    public muestraController(muestraService muestraService) {
        this.muestraService = muestraService;
    }

    @GetMapping
    public ResponseEntity<List<muestraModel>> getAllMuestras() {
        return ResponseEntity.ok(muestraService.getAllMuestras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<muestraModel> getMuestraById(@PathVariable String id) {
        return ResponseEntity.ok(muestraService.getMuestraById(id).get());
    }

    @PostMapping
    public ResponseEntity<muestraModel> saveMuestra(@RequestBody muestraModel muestra) {
        return ResponseEntity.ok(muestraService.saveMuestra(muestra));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMuestra(@PathVariable String id) {
        muestraService.deleteMuestra(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<List<muestraModel>> getMuestrasByPaciente(@PathVariable String id) {
        return ResponseEntity.ok(muestraService.getMuestrasByPaciente(id));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<muestraModel>> getMuestrasByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(muestraService.getMuestrasByEstado(estado));
    }

    @GetMapping("/tipo_analisis/{tipoAnalisis}")
    public ResponseEntity<List<muestraModel>> getMuestrasByTipoAnalisis(@PathVariable String tipoAnalisis) {
        return ResponseEntity.ok(muestraService.getMuestrasByTipoAnalisis(tipoAnalisis));
    }

    @PutMapping("/{id}")
    public ResponseEntity<muestraModel> updateMuestra(@PathVariable String id, @RequestBody muestraModel muestra) {
        return muestraService.getMuestraById(id)
                .map(existingMuestra -> {
                    muestra.setId(id);
                    return ResponseEntity.ok(muestraService.saveMuestra(muestra));
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
