package com.labclinico.omega.muestra;

import java.util.Map;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

@Data
@Document(collection = "muestras")
@CompoundIndex(name = "tipo_estado_idx", def = "{'tipo': 1, 'estado': 1}")
public class muestraModel {

    @Id
    private String id;
    @Indexed
    private String idPaciente;
    @Indexed
    private String id_cita;
    @Indexed
    private String tipo;
    @Indexed
    private String codigo;
    @Indexed
    private LocalDateTime fechaRecoleccion;
    private String estado;
    private Map<String, String> metadatos;

}
