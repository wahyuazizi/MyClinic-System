package com.zeeclinic.clinicmanagementsystem.service;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.MedicalRecordRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.MedicalRecordResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.MedicalRecord;

import java.util.List;
import java.util.UUID;

public interface MedicalRecordService extends CrudService<MedicalRecordRequest, MedicalRecordResponse> {

    List<MedicalRecordResponse> findByPatientId(UUID id);

}
