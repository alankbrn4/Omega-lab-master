package com.labclinico.omega.doctores;

import lombok.Data;

import com.labclinico.omega.citas.citasModel;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity 
@Table(name = "medico")

public class doctoresModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_medico;
    private String nombre;
    private String especialidad;
    private String afiliacion;
    private Long num_telefono;
    private String cedula_profesional;

    @OneToMany(mappedBy = "medico")
    private List<citasModel> citas;
        

}
