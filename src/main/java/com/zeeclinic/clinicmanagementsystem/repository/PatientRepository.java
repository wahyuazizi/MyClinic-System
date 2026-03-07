package com.zeeclinic.clinicmanagementsystem.repository;

import com.zeeclinic.clinicmanagementsystem.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    Optional<Patient> findByNik(String nik);
}
