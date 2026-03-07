package com.zeeclinic.clinicmanagementsystem.repository;

import com.zeeclinic.clinicmanagementsystem.model.entity.Doctor;
import com.zeeclinic.clinicmanagementsystem.model.enums.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    List<Doctor> findBySpecialization(Specialization specialization);

}
