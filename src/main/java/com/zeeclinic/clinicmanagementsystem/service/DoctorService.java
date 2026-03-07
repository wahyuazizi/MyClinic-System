package com.zeeclinic.clinicmanagementsystem.service;

import com.zeeclinic.clinicmanagementsystem.model.entity.Doctor;

import java.util.UUID;

public interface DoctorService {
    Doctor findByLicenseNumber(String licenseNumber);
    void setStatus(UUID id, boolean status);
}
