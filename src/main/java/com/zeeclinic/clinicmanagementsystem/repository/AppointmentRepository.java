package com.zeeclinic.clinicmanagementsystem.repository;

import com.zeeclinic.clinicmanagementsystem.model.entity.Appointment;
import com.zeeclinic.clinicmanagementsystem.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {

    List<Appointment> findByPatientId(UUID patientId);
    List<Appointment> findByDoctorId(UUID doctorId);
    Optional<Appointment> updateStatus(UUID id, Status status);


}
