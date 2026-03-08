package com.zeeclinic.clinicmanagementsystem.service.implementation;

import com.zeeclinic.clinicmanagementsystem.exception.ConflictException;
import com.zeeclinic.clinicmanagementsystem.mapper.DoctorMapper;
import com.zeeclinic.clinicmanagementsystem.model.dto.request.DoctorRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.DoctorResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.Doctor;
import com.zeeclinic.clinicmanagementsystem.model.enums.Specialization;
import com.zeeclinic.clinicmanagementsystem.model.enums.Status;
import com.zeeclinic.clinicmanagementsystem.repository.DoctorRepository;
import com.zeeclinic.clinicmanagementsystem.service.DoctorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public DoctorResponse create(DoctorRequest requestPayload) {
        if(doctorRepository.existsByLicenseNumber(requestPayload.getLicenseNumber())){
            throw new ConflictException("Doctor already exists");
        }
        Doctor doctor = doctorMapper.toEntity(requestPayload);
        return doctorMapper.toResponse(doctorRepository.save(doctor));
    }

    @Override
    public List<DoctorResponse> findAll() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(doctorMapper::toResponse).toList();
    }

    @Override
    public DoctorResponse findById(UUID id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Doctor not found"));
        return doctorMapper.toResponse(doctor);
    }

    @Override
    public DoctorResponse update(UUID id, DoctorRequest request) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Doctor not found"));
        doctorMapper.updateEntity(request,doctor);
        return doctorMapper.toResponse(doctorRepository.save(doctor));
    }

    @Override
    public DoctorResponse findByLicenseNumber(String licenseNumber) {
        Doctor doctor = doctorRepository.findByLicenseNumber(licenseNumber).orElseThrow(()-> new EntityNotFoundException("Doctor not found"));
        return doctorMapper.toResponse(doctor);
    }

    @Override
    public List<DoctorResponse> findBySpecialization(Specialization specialization) {
        return doctorRepository.findBySpecialization(specialization).stream().map(doctorMapper::toResponse).toList();
    }

    @Override
    public DoctorResponse setStatus(UUID id, boolean status) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Doctor not found"));
        doctor.setIsActive(status);
        return doctorMapper.toResponse(doctorRepository.save(doctor));
    }
}
