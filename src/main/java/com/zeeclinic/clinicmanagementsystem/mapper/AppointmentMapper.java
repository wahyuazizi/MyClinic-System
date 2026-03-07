package com.zeeclinic.clinicmanagementsystem.mapper;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.AppointmentRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.AppointmentResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.Appointment;
import com.zeeclinic.clinicmanagementsystem.model.entity.Doctor;
import com.zeeclinic.clinicmanagementsystem.model.entity.Patient;
import com.zeeclinic.clinicmanagementsystem.repository.DoctorRepository;
import com.zeeclinic.clinicmanagementsystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentMapper {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public Appointment toEntity(AppointmentRequest request){

        Patient patient = patientRepository.findById(request.getPatientId()).orElseThrow(
                () -> new EntityNotFoundException("Patient not found")
        );

        Doctor doctor = doctorRepository.findById(request.getDoctorId()).orElseThrow(
                () -> new EntityNotFoundException("Doctor not found")
        );

        return Appointment.builder()
                .patient(patient)
                .doctor(doctor)
                .appointmentDateTime(request.getAppointmentDateTime())
                .complaint(request.getComplaint())
                .notes(request.getNotes())
                .build();
    }

    public AppointmentResponse toResponse(Appointment appointment){
        return new AppointmentResponse(
                appointment.getId(),
                appointment.getPatient().getFullName(),
                appointment.getDoctor().getFullName(),
                appointment.getAppointmentDateTime(),
                appointment.getStatus(),
                appointment.getComplaint(),
                appointment.getNotes(),
                appointment.getCreatedAt(),
                appointment.getUpdatedAt()
        );
    }

}
