package com.labclinico.omega.patients;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

import java.util.List;

import com.labclinico.omega.citas.citasModel;


@Data
@Entity
@Table(name = "paciente")
public class pacientesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
    private String nombre;
    private Date fecha_nacimiento;
    private String genero;
    private String correo;
    private Long num_telefono;
    private String rfc_paciente;

    @OneToMany(mappedBy = "paciente")
    private List<citasModel> citas;

   
}