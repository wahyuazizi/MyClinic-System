package com.zeeclinic.clinicmanagementsystem.mapper;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.DoctorRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.DoctorResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.Doctor;
import org.springframework.stereotype.Component;


@Component
public class DoctorMapper {

    public Doctor toEntity(DoctorRequest request){
        return Doctor.builder()
                .fullName(request.getFullName())
                .licenseNumber(request.getLicenseNumber())
                .specialization(request.getSpecialization())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .build();
    }

    public DoctorResponse toResponse(Doctor doctor){
        return new DoctorResponse(
                doctor.getId(),
                doctor.getFullName(),
                doctor.getLicenseNumber(),
                doctor.getSpecialization(),
                doctor.getPhoneNumber(),
                doctor.getEmail(),
                doctor.getIsActive()
        );
    }

    public void updateEntity(DoctorRequest request, Doctor doctor){
        doctor.setFullName(request.getFullName());
        doctor.setLicenseNumber(request.getLicenseNumber());
        doctor.setSpecialization(request.getSpecialization());
        doctor.setPhoneNumber(request.getPhoneNumber());
        doctor.setEmail(request.getEmail());
    }

}
