package com.zeeclinic.clinicmanagementsystem.controller;

import com.zeeclinic.clinicmanagementsystem.config.ApiConstant;
import com.zeeclinic.clinicmanagementsystem.model.dto.request.MedicalRecordRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.MedicalRecordResponse;
import com.zeeclinic.clinicmanagementsystem.service.MedicalRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ApiConstant.MEDICAL_RECORD)
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @PostMapping
    public ResponseEntity<MedicalRecordResponse> create(@Valid @RequestBody MedicalRecordRequest medicalRecordRequest) {
        MedicalRecordResponse medicalRecordResponse = medicalRecordService.create(medicalRecordRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalRecordResponse);
    }

    @GetMapping
    public ResponseEntity<List<MedicalRecordResponse>> findAll() {
        List<MedicalRecordResponse> medicalRecordResponseList = medicalRecordService.findAll();
        return ResponseEntity.ok(medicalRecordResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecordResponse> getMedicalRecordById(@PathVariable UUID id){
        MedicalRecordResponse medicalRecordResponse = medicalRecordService.findById(id);
        return ResponseEntity.ok(medicalRecordResponse);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalRecordResponse>> getMedicalRecordByPatientId(@PathVariable UUID patientId){
        List<MedicalRecordResponse> medicalRecordResponsesList = medicalRecordService.findByPatientId(patientId);
        return ResponseEntity.ok(medicalRecordResponsesList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecordResponse> updateMedicalRecord(@PathVariable UUID id, @Valid @RequestBody MedicalRecordRequest medicalRecordRequest){
        MedicalRecordResponse medicalRecordResponse = medicalRecordService.update(id, medicalRecordRequest);
        return ResponseEntity.ok(medicalRecordResponse);
    }

}
