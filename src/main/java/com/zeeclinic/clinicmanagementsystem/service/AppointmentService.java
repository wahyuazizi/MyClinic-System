package com.zeeclinic.clinicmanagementsystem.service;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.AppointmentRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.AppointmentResponse;
import com.zeeclinic.clinicmanagementsystem.model.enums.Status;

import java.util.List;
import java.util.UUID;

public interface AppointmentService extends CrudService<AppointmentRequest, AppointmentResponse> {
    List<AppointmentResponse> findByPatientId(UUID id);
    List<AppointmentResponse> findByDoctorId(UUID id);
    AppointmentResponse setStatus(UUID id, Status status);
    void delete(UUID id);
}
