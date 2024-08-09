package com.labclinico.omega.patients;

import org.springframework.data.jpa.repository.JpaRepository;

public interface pacientesRepository extends JpaRepository<pacientesModel, Long> {
}