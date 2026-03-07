package com.zeeclinic.clinicmanagementsystem.service;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.DoctorRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.DoctorResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.Doctor;

import java.util.UUID;

public interface DoctorService extends CrudService<DoctorRequest, DoctorResponse> {
    Doctor findByLicenseNumber(String licenseNumber);
    void setStatus(UUID id, boolean status);
}
