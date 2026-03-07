package com.zeeclinic.clinicmanagementsystem.service.implementation;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.DoctorRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.DoctorResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.Doctor;
import com.zeeclinic.clinicmanagementsystem.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Override
    public DoctorResponse create(DoctorRequest requestPayload) {
        return null;
    }

    @Override
    public List<DoctorResponse> findAll() {
        return List.of();
    }

    @Override
    public DoctorResponse findById(UUID id) {
        return null;
    }

    @Override
    public DoctorResponse update(UUID id, DoctorRequest request) {
        return null;
    }

    @Override
    public Doctor findByLicenseNumber(String licenseNumber) {
        return null;
    }

    @Override
    public void setStatus(UUID id, boolean status) {

    }
}
