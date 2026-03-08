package com.zeeclinic.clinicmanagementsystem.service;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.DoctorRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.DoctorResponse;
import com.zeeclinic.clinicmanagementsystem.model.enums.Specialization;

import java.util.List;
import java.util.UUID;

public interface DoctorService extends CrudService<DoctorRequest, DoctorResponse> {
    DoctorResponse findByLicenseNumber(String licenseNumber);
    List<DoctorResponse> findBySpecialization(Specialization specialization);
    DoctorResponse setStatus(UUID id, boolean status);
}
