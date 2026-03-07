package com.zeeclinic.clinicmanagementsystem.mapper;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.PatientRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.PatientResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient toEntity(PatientRequest request){
        return Patient.builder()
                .fullName(request.getFullName())
                .nik(request.getNik())
                .birthDate(request.getBirthDate())
                .gender(request.getGender())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .address(request.getAddress())
                .bloodType(request.getBloodType())
                .build();
    }

    public PatientResponse toResponse(Patient patient){
        return new PatientResponse(
                patient.getId(),
                patient.getFullName(),
                patient.getNik(),
                patient.getBirthDate(),
                patient.getGender(),
                patient.getPhoneNumber(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getBloodType()
        );
    }

    public void updateEntity(PatientRequest request, Patient patient){
        patient.setFullName(request.getFullName());
        patient.setNik(request.getNik());
        patient.setBirthDate(request.getBirthDate());
        patient.setGender(request.getGender());
        patient.setPhoneNumber(request.getPhoneNumber());
        patient.setEmail(request.getEmail());
        patient.setAddress(request.getAddress());
        patient.setBloodType(request.getBloodType());
    }

}
