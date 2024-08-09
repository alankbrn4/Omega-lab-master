package com.labclinico.omega.patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class pacientesController {

    private final pacientesService pacientesService;

    @Autowired
    public pacientesController(pacientesService pacientesService) {
        this.pacientesService = pacientesService;
    }

    @GetMapping
    public List<pacientesModel> getAllPacientes() {
        return pacientesService.getAllPacientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<pacientesModel> getPacienteById(@PathVariable Long id) {
        return pacientesService.getPacienteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public pacientesModel createPaciente(@RequestBody pacientesModel paciente) {
        return pacientesService.savePaciente(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<pacientesModel> updatePaciente(@PathVariable Long id, @RequestBody pacientesModel paciente) {
        return pacientesService.getPacienteById(id)
                .map(existingPaciente -> {
                    paciente.setIdPaciente(id);
                    return ResponseEntity.ok(pacientesService.savePaciente(paciente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        pacientesService.deletePaciente(id);
        return ResponseEntity.ok().build();
    }
}