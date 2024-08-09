package com.labclinico.omega.analisis;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



import java.time.LocalDateTime;
import java.util.Map;

@Data
@Document(collection = "analisis")
public class analisisModel implements Comparable<analisisModel> {

    @Id
    private String id;
    @Indexed
    private String idMuestra;
    @Indexed
    private String tipo;
    @Indexed
    private String codigo;
    @Indexed
    private LocalDateTime fechaRecoleccion;
    private String estado;
    private Map<String, String> resultados;

    @Override
    public int compareTo(analisisModel other){
        return this.id.compareTo(other.id);
    }

}
