package com.zeeclinic.clinicmanagementsystem.service;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.PatientRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.PatientResponse;

import java.util.UUID;

public interface PatientService extends CrudService<PatientRequest, PatientResponse> {
    PatientResponse findByNik(String nik);
    void delete(UUID id);
}
