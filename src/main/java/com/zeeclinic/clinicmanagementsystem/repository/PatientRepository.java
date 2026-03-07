package com.zeeclinic.clinicmanagementsystem.repository;

import com.zeeclinic.clinicmanagementsystem.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    List<Patient> findAllByDeletedAtIsNull();
    Optional<Patient> findByNikAndDeletedAtIsNull(String nik);
    Optional<Patient> findByIdAndDeletedAtIsNull(UUID id);
}
