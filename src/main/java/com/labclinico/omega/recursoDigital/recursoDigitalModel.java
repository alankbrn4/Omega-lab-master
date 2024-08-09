package com.labclinico.omega.recursoDigital;

import lombok.Data;

import org.hibernate.annotations.Index;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

@Data
@Document(collection = "recursosDigitales")
public class recursoDigitalModel {

    @Id
    private String id;
    @Indexed
    private String nombre;
    private String tipo;
    private String url;
    private String descripcion;
    private String metadata;
    @Indexed
    private List<String> etiquetas;

}
