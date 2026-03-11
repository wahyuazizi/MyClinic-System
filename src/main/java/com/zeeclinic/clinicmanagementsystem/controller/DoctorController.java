package com.zeeclinic.clinicmanagementsystem.controller;

import com.zeeclinic.clinicmanagementsystem.config.ApiConstant;
import com.zeeclinic.clinicmanagementsystem.model.dto.request.DoctorRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.DoctorResponse;
import com.zeeclinic.clinicmanagementsystem.model.enums.Specialization;
import com.zeeclinic.clinicmanagementsystem.service.DoctorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ApiConstant.DOCTOR)
@RequiredArgsConstructor
@Tag(name = "2. Doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorResponse> createDoctor(@Valid @RequestBody DoctorRequest requestPayload){
        DoctorResponse doctorResponse = doctorService.create(requestPayload);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorResponse);
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponse>> getAllDoctors(){
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponse> getDoctorById(@PathVariable UUID id){
        return ResponseEntity.ok(doctorService.findById(id));
    }

    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<List<DoctorResponse>> getDoctorsBySpecialization(@PathVariable Specialization specialization){
        return ResponseEntity.ok(doctorService.findBySpecialization(specialization));
    }

    @GetMapping("/{licenseNumber}")
    public ResponseEntity<DoctorResponse> getDoctorByLicenseNumber(@PathVariable String licenseNumber){
        return ResponseEntity.ok(doctorService.findByLicenseNumber(licenseNumber));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponse> updateDoctor(@PathVariable UUID id, @Valid @RequestBody DoctorRequest requestPayload){
        return ResponseEntity.ok(doctorService.update(id, requestPayload));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<DoctorResponse> deactivateDoctor(@PathVariable UUID id, @RequestParam boolean status){
        return ResponseEntity.ok(doctorService.setStatus(id, status));
    }
}
