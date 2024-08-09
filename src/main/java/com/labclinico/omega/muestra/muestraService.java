package com.labclinico.omega.muestra;

import com.labclinico.omega.muestra.muestraModel;
import com.labclinico.omega.muestra.muestraRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class muestraService {

    private final muestraRepository muestraRepository;

    @Autowired
    public muestraService(muestraRepository muestraRepository) {
        this.muestraRepository = muestraRepository;
    }

    public List<muestraModel> getAllMuestras() {
        return muestraRepository.findAll();
    }

    public Optional<muestraModel> getMuestraById(String id) {
        return muestraRepository.findById(id);
    }

    public muestraModel saveMuestra(muestraModel muestra) {
        return muestraRepository.save(muestra);
    }

    public void deleteMuestra(String id) {
        muestraRepository.deleteById(id);
    }

    public List<muestraModel> getMuestrasByPaciente(String pacienteId) {
        return muestraRepository.findByIdPaciente(pacienteId);
    }

    public List<muestraModel> getMuestrasByEstado(String estado) {
        return muestraRepository.findByEstado(estado);
    }

    public List<muestraModel> getMuestrasByTipoAnalisis(String tipo) {
        return muestraRepository.findByTipo(tipo);
    }

    public List<muestraResumen> getMuestrasResumenByPaciente(String pacienteId) {
        return muestraRepository.findMuestrasResumenByIdPaciente(pacienteId)
            .stream()
            .map(m -> new muestraResumen(m.getId(), m.getTipo(), m.getEstado()))
            .collect(Collectors.toList());
    }

}

