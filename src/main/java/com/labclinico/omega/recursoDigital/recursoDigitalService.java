package com.labclinico.omega.recursoDigital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class recursoDigitalService {

    private final recursoDigitalRepository recursoDigitalRepository;

    @Autowired
    public recursoDigitalService(recursoDigitalRepository recursoDigitalRepository) {
        this.recursoDigitalRepository = recursoDigitalRepository;
    }

    public List<recursoDigitalModel> getAllRecursos() {
        return recursoDigitalRepository.findAll();
    }

    public Optional<recursoDigitalModel> getRecursoById(String id) {
        return recursoDigitalRepository.findById(id);
    }

    public recursoDigitalModel saveRecurso(recursoDigitalModel recurso) {
        return recursoDigitalRepository.save(recurso);
    }

    public void deleteRecurso(String id) {
        recursoDigitalRepository.deleteById(id);
    }

    public List<recursoDigitalModel> buscarPorEtiquetas(List<String> etiquetas) {
        return recursoDigitalRepository.findByEtiquetasIn(etiquetas);
    }

    public List<recursoDigitalModel> getAllRecursos(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return recursoDigitalRepository.findAll(pageable).getContent();
    }
    
}