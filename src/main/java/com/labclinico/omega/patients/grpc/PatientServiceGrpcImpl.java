/*package com.labclinico.omega.patients.grpc;

import com.labclinico.omega.patients.pacientesModel;
import com.labclinico.omega.patients.pacientesRepository;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class PatientServiceGrpcImpl extends PatientServiceGrpc.PatientServiceImplBase {

    @Autowired
    private final pacientesRepository pacientesRepository;

   
    @Override
    public void getAllPatients(PatientRequest request, StreamObserver<PatientResponse> responseObserver) {
        pacientesModel paciente = pacientesRepository.findById(request.getId()).orElse(null);
        if (paciente != null) {
            PatientResponse response = PatientResponse.newBuilder()
            .setIdPaciente(paciente.getIdPaciente())
            .setNombre(paciente.getNombre())
            .setFecha_nacimiento(paciente.getFecha_nacimiento())
            .setNum_telefono(paciente.getNum_telefono())
            .setRfc_paciente(paciente.getRfc_paciente())
            .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
        
    }

    @Override
    public void getPatientById(PatientRequest request, StreamObserver<PatientResponse> responseObserver) {
        pacientesModel paciente = pacientesRepository.findById(request.getId()).orElse(null);
        if (paciente != null) {
            PatientResponse response = PatientResponse.newBuilder()
            .setIdPaciente(paciente.getIdPaciente())
            .setNombre(paciente.getNombre())
            .setFecha_nacimiento(paciente.getFecha_nacimiento())
            .setNum_telefono(paciente.getNum_telefono())
            .setRfc_paciente(paciente.getRfc_paciente())
            .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }

    @Override
    public void createPatient(PatientRequest request, StreamObserver<PatientResponse> responseObserver) {
        pacientesModel paciente = new pacientesModel();
        paciente.setNombre(request.getNombre());
        paciente.setFecha_nacimiento(request.getFecha_nacimiento());
        paciente.setNum_telefono(request.getNum_telefono());
        paciente.setRfc_paciente(request.getRfc_paciente());
        pacientesRepository.save(paciente);
        PatientResponse response = PatientResponse.newBuilder()
        .setIdPaciente(paciente.getIdPaciente())
        .setNombre(paciente.getNombre())
        .setFecha_nacimiento(paciente.getFecha_nacimiento())
        .setNum_telefono(paciente.getNum_telefono())
        .setRfc_paciente(paciente.getRfc_paciente())
        .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updatePatient(PatientRequest request, StreamObserver<PatientResponse> responseObserver) {
        pacientesModel paciente = pacientesRepository.findById(request.getId()).orElse(null);
        if (paciente != null) {
            paciente.setNombre(request.getNombre());
            paciente.setFecha_nacimiento(request.getFecha_nacimiento());
            paciente.setNum_telefono(request.getNum_telefono());
            paciente.setRfc_paciente(request.getRfc_paciente());
            pacientesRepository.save(paciente);
            PatientResponse response = PatientResponse.newBuilder()
            .setIdPaciente(paciente.getIdPaciente())
            .setNombre(paciente.getNombre())
            .setFecha_nacimiento(paciente.getFecha_nacimiento())
            .setNum_telefono(paciente.getNum_telefono())
            .setRfc_paciente(paciente.getRfc_paciente())
            .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }

    @Override
    public void deletePatient(PatientRequest request, StreamObserver<PatientResponse> responseObserver) {
        pacientesRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void getAllPatients(PatientRequest request, StreamObserver<PatientResponse> responseObserver) {
        pacientesModel paciente = pacientesRepository.findById(request.getId()).orElse(null);
        if (paciente != null) {
            PatientResponse response = PatientResponse.newBuilder()
            .setIdPaciente(paciente.getIdPaciente())
            .setNombre(paciente.getNombre())
            .setFecha_nacimiento(paciente.getFecha_nacimiento())
            .setNum_telefono(paciente.getNum_telefono())
            .setRfc_paciente(paciente.getRfc_paciente())
            .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
        
    }

}
*/