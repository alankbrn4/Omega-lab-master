package com.labclinico.omega.doctores;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class doctoresService {

    private final doctoresRepository doctoresRepository;

    @Autowired
    public doctoresService(doctoresRepository doctoresRepository) {
        this.doctoresRepository = doctoresRepository;
    }

    public List<doctoresModel> getAllDoctores() {
        return doctoresRepository.findAll();
    }

    public Optional<doctoresModel> getDoctoresById(Long id) {
        return doctoresRepository.findById(id);
    }

    public doctoresModel saveDoctores(doctoresModel doctores) {
        return doctoresRepository.save(doctores);
    }

    public void deleteDoctores(Long id) {
        doctoresRepository.deleteById(id);
    }

    public void updateDoctores(Long id, doctoresModel doctores) {
        doctoresRepository.save(doctores);
    }
    

}
