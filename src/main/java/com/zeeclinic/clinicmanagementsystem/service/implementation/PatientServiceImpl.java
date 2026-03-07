package com.zeeclinic.clinicmanagementsystem.service.implementation;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.PatientRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.PatientResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.Patient;
import com.zeeclinic.clinicmanagementsystem.service.CrudService;
import com.zeeclinic.clinicmanagementsystem.service.PatientService;

import java.util.List;
import java.util.UUID;

public class PatientServiceImpl implements CrudService<PatientRequest, PatientResponse>, PatientService {
    @Override
    public PatientRequest create(PatientRequest obj) {
        return null;
    }

    @Override
    public List<PatientResponse> findAll() {
        return List.of();
    }

    @Override
    public PatientResponse findById(UUID id) {
        return null;
    }

    @Override
    public PatientResponse update(UUID id, PatientRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public Patient findByNik(String nik) {
        return null;
    }
}
