package com.zeeclinic.clinicmanagementsystem.service;

import com.zeeclinic.clinicmanagementsystem.model.entity.Appointment;
import com.zeeclinic.clinicmanagementsystem.model.enums.Status;

import java.util.UUID;

public interface AppointmentService {
    Appointment findByPatientId(UUID id);
    Appointment findByDoctorId(UUID id);
    void setStatus(UUID id, Status status);
}
