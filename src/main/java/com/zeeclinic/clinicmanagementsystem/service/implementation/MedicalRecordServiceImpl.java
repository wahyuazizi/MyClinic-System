package com.zeeclinic.clinicmanagementsystem.service.implementation;

import com.zeeclinic.clinicmanagementsystem.mapper.MedicalRecordMapper;
import com.zeeclinic.clinicmanagementsystem.model.dto.request.MedicalRecordRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.MedicalRecordResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.MedicalRecord;
import com.zeeclinic.clinicmanagementsystem.repository.MedicalRecordRepository;
import com.zeeclinic.clinicmanagementsystem.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final MedicalRecordMapper medicalRecordMapper;

    @Override
    public MedicalRecordResponse create(MedicalRecordRequest requestPayload) {
        MedicalRecord medicalRecord = medicalRecordMapper.toEntity(requestPayload);
        medicalRecordRepository.save(medicalRecord);
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
