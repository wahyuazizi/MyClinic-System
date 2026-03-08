package com.zeeclinic.clinicmanagementsystem.controller;

import com.zeeclinic.clinicmanagementsystem.config.ApiConstant;
import com.zeeclinic.clinicmanagementsystem.model.dto.request.PatientRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.PatientResponse;
import com.zeeclinic.clinicmanagementsystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstant.PATIENT)
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponse> createPatient(@RequestBody PatientRequest requestPayload){
        patientService.create(requestPayload);
        return ResponseEntity.status(HttpStatus.OK).body(patientService.create(requestPayload));
    }


}
