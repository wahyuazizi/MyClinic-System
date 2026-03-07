package com.zeeclinic.clinicmanagementsystem.service;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.AppointmentRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.AppointmentResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.Appointment;
import com.zeeclinic.clinicmanagementsystem.model.enums.Status;

import java.util.UUID;

public interface AppointmentService extends CrudService<AppointmentRequest, AppointmentResponse> {
    Appointment findByPatientId(UUID id);
    Appointment findByDoctorId(UUID id);
    void setStatus(UUID id, Status status);
}
