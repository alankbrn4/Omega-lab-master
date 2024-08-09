package com.labclinico.omega.recursoDigital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recursos")
public class recursoDigitalController {

    private final recursoDigitalService recursoDigitalService;

    @Autowired
    public recursoDigitalController(recursoDigitalService recursoDigitalService) {
        this.recursoDigitalService = recursoDigitalService;
    }

    @GetMapping
    public ResponseEntity<List<recursoDigitalModel>> getAllRecursos() {
        return ResponseEntity.ok(recursoDigitalService.getAllRecursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<recursoDigitalModel> getRecursoById(@PathVariable String id) {
        return recursoDigitalService.getRecursoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<recursoDigitalModel> saveRecurso(@RequestBody recursoDigitalModel recurso) {
        return ResponseEntity.ok(recursoDigitalService.saveRecurso(recurso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<recursoDigitalModel> updateRecurso(@PathVariable String id, @RequestBody recursoDigitalModel recurso) {
        return recursoDigitalService.getRecursoById(id)
                .map(existingRecurso -> {
                    recurso.setId(id);
                    return ResponseEntity.ok(recursoDigitalService.saveRecurso(recurso));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecurso(@PathVariable String id) {
        recursoDigitalService.deleteRecurso(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<recursoDigitalModel>> buscarPorEtiquetas(@RequestParam List<String> etiquetas) {
        return ResponseEntity.ok(recursoDigitalService.buscarPorEtiquetas(etiquetas));
    }

    @GetMapping("/buscarPorNombre")
    public ResponseEntity<List<recursoDigitalModel>> getAllRecursos(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(recursoDigitalService.getAllRecursos(page, size));
    }


}
