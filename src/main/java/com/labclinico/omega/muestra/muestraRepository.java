package com.labclinico.omega.muestra;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface muestraRepository extends MongoRepository<muestraModel, String> {
    @Query(value = "{ 'pacienteId': ?0 }", fields = "{ 'tipo': 1, 'estado': 1 }")
    List<muestraModel> findByIdPaciente(String idPaciente);
    List<muestraModel> findByTipo(String tipo);
    List<muestraModel> findByCodigo(String codigo);
    List<muestraModel> findByEstado(String estado);
    List<muestraResumen> findMuestrasResumenByIdPaciente(String idPaciente);

}
