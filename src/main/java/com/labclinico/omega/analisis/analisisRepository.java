package com.labclinico.omega.analisis;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface analisisRepository extends MongoRepository<analisisModel, String> {
    List<analisisModel> findByIdMuestra(String idMuestra);
    List<analisisModel> findByTipo(String tipo);
    List<analisisModel> findByCodigo(String codigo);
    List<analisisModel> findByEstado(String estado);
    Page<analisisModel> findByEstado(String estado, Pageable pageable);

}
