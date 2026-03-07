package com.zeeclinic.clinicmanagementsystem.service.implementation;

import com.zeeclinic.clinicmanagementsystem.exception.ConflictException;
import com.zeeclinic.clinicmanagementsystem.mapper.AppointmentMapper;
import com.zeeclinic.clinicmanagementsystem.model.dto.request.AppointmentRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.AppointmentResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.Appointment;
import com.zeeclinic.clinicmanagementsystem.model.enums.Status;
import com.zeeclinic.clinicmanagementsystem.repository.AppointmentRepository;
import com.zeeclinic.clinicmanagementsystem.service.AppointmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private  final AppointmentMapper appointmentMapper;

    @Override
    public List<AppointmentResponse> findByPatientId(UUID id) {
        return appointmentRepository.findByPatientId(id).stream().map(appointmentMapper::toResponse).toList();
    }

    @Override
    public List<AppointmentResponse> findByDoctorId(UUID id) {
        return appointmentRepository.findByDoctorId(id).stream().map(appointmentMapper::toResponse).toList();
    }

    @Override
    public AppointmentResponse setStatus(UUID id, Status status) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Appointment not found"));
        appointment.setStatus(status);
        return appointmentMapper.toResponse(appointmentRepository.save(appointment));
    }

    @Override
    public AppointmentResponse create(AppointmentRequest requestPayload) {
        UUID doctorId = requestPayload.getDoctorId();
        LocalDateTime requestDateTime = requestPayload.getAppointmentDateTime();
        boolean conflict = appointmentRepository.existsByDoctorIdAndAppointmentDateTime(doctorId, requestDateTime);
        if (conflict) {
            throw new ConflictException("Doctor already has an appointment at this time");
        }
        Appointment appointment = appointmentMapper.toEntity(requestPayload);
        return appointmentMapper.toResponse(appointmentRepository.save(appointment));
    }

    @Override
    public List<AppointmentResponse> findAll() {
        return appointmentRepository.findAll().stream().map(appointmentMapper::toResponse).toList();
    }

    @Override
    public AppointmentResponse findById(UUID id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Appointment not found"));
        return appointmentMapper.toResponse(appointment);
    }

    @Override
    public AppointmentResponse update(UUID id, AppointmentRequest request) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Appointment not found"));
        UUID doctorId = appointment.getDoctor().getId();
        LocalDateTime requestDateTime = request.getAppointmentDateTime();
        boolean conflict = appointmentRepository.existsByDoctorIdAndAppointmentDateTimeAndIdNot(doctorId, requestDateTime, id);
        if (conflict) {
            throw new ConflictException("Doctor already has an appointment at this time");
        }
        appointment.setAppointmentDateTime(request.getAppointmentDateTime());
        appointment.setNotes(request.getNotes());
        return appointmentMapper.toResponse(appointmentRepository.save(appointment));
    }
}
