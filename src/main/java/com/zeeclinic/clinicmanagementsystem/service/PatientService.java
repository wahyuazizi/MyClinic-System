package com.zeeclinic.clinicmanagementsystem.service;

import com.zeeclinic.clinicmanagementsystem.model.entity.Patient;

import java.util.UUID;

public interface PatientService {
    Patient findByNik(String nik);
    void delete(UUID id);
}
