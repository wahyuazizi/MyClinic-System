package com.zeeclinic.clinicmanagementsystem.service.implementation;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.AppointmentRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.AppointmentResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.Appointment;
import com.zeeclinic.clinicmanagementsystem.model.enums.Status;
import com.zeeclinic.clinicmanagementsystem.service.AppointmentService;
import com.zeeclinic.clinicmanagementsystem.service.CrudService;

import java.util.List;
import java.util.UUID;

public class AppointmentServiceImpl implements CrudService<AppointmentRequest, AppointmentResponse>, AppointmentService {
    @Override
    public Appointment findByPatientId(UUID id) {
        return null;
    }

    @Override
    public Appointment findByDoctorId(UUID id) {
        return null;
    }

    @Override
    public void setStatus(UUID id, Status status) {

    }

    @Override
    public AppointmentRequest create(AppointmentRequest obj) {
        return null;
    }

    @Override
    public List<AppointmentResponse> findAll() {
        return List.of();
    }

    @Override
    public AppointmentResponse findById(UUID id) {
        return null;
    }

    @Override
    public AppointmentResponse update(UUID id, AppointmentRequest request) {
        return null;
    }
}
