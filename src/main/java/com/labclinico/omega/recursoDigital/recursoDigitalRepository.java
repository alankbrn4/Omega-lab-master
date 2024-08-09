package com.labclinico.omega.recursoDigital;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface recursoDigitalRepository extends MongoRepository<recursoDigitalModel, String> {
    List<recursoDigitalModel> findByEtiquetasIn(List<String> etiquetas);
}