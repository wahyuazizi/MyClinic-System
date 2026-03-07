package com.zeeclinic.clinicmanagementsystem.service.implementation;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.AppointmentRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.AppointmentResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.Appointment;
import com.zeeclinic.clinicmanagementsystem.model.enums.Status;
import com.zeeclinic.clinicmanagementsystem.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {
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
    public AppointmentResponse create(AppointmentRequest requestPayload) {
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
