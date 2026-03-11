package com.zeeclinic.clinicmanagementsystem.controller;

import com.zeeclinic.clinicmanagementsystem.config.ApiConstant;
import com.zeeclinic.clinicmanagementsystem.model.dto.request.AppointmentRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.AppointmentResponse;
import com.zeeclinic.clinicmanagementsystem.model.enums.Status;
import com.zeeclinic.clinicmanagementsystem.service.AppointmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ApiConstant.APPOINTMENT)
@RequiredArgsConstructor
@Tag(name = "3. Appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentResponse> createAppointment(@Valid @RequestBody AppointmentRequest request){
        AppointmentResponse appointmentResponse = appointmentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentResponse);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments(){
        List<AppointmentResponse> appointmentResponseList = appointmentService.findAll();
        return ResponseEntity.ok(appointmentResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> getAppointmentById(@PathVariable UUID id){
        AppointmentResponse appointmentResponse = appointmentService.findById(id);
        return ResponseEntity.ok(appointmentResponse);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<AppointmentResponse>> getAllAppointmentsByPatientId(@PathVariable UUID patientId){
        List<AppointmentResponse> appointmentResponseList = appointmentService.findByPatientId(patientId);
        return ResponseEntity.ok(appointmentResponseList);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentResponse>> getAllAppointmentsByDoctorId(@PathVariable UUID doctorId){
        List<AppointmentResponse> appointmentResponseList = appointmentService.findByDoctorId(doctorId);
        return ResponseEntity.ok(appointmentResponseList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponse>  updateAppointment(@PathVariable UUID id, @Valid @RequestBody AppointmentRequest requestPayload){
        return ResponseEntity.ok(appointmentService.update(id, requestPayload));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<AppointmentResponse> updateStatus(@PathVariable UUID id, @RequestParam Status status){
        AppointmentResponse appointmentResponse = appointmentService.setStatus(id, status);
        return  ResponseEntity.ok(appointmentResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointmentById(@PathVariable UUID id){
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
