package com.zeeclinic.clinicmanagementsystem.service;

import com.zeeclinic.clinicmanagementsystem.model.entity.MedicalRecord;

import java.util.UUID;

public interface MedicalRecordService {

    MedicalRecord findByPatientId(UUID id);

}
