package com.zeeclinic.clinicmanagementsystem.service.implementation;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.MedicalRecordRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.MedicalRecordResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.MedicalRecord;
import com.zeeclinic.clinicmanagementsystem.service.MedicalRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Override
    public MedicalRecordResponse create(MedicalRecordRequest requestPayload) {
        return null;
    }

    @Override
    public List<MedicalRecordResponse> findAll() {
        return List.of();
    }

    @Override
    public MedicalRecordResponse findById(UUID id) {
        return null;
    }

    @Override
    public MedicalRecordResponse update(UUID id, MedicalRecordRequest request) {
        return null;
    }

    @Override
    public MedicalRecord findByPatientId(UUID id) {
        return null;
    }
}
