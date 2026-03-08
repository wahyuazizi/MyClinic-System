package com.zeeclinic.clinicmanagementsystem.service.implementation;

import com.zeeclinic.clinicmanagementsystem.exception.BusinessException;
import com.zeeclinic.clinicmanagementsystem.exception.ConflictException;
import com.zeeclinic.clinicmanagementsystem.mapper.PatientMapper;
import com.zeeclinic.clinicmanagementsystem.model.dto.request.PatientRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.PatientResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.Patient;
import com.zeeclinic.clinicmanagementsystem.model.enums.Status;
import com.zeeclinic.clinicmanagementsystem.repository.AppointmentRepository;
import com.zeeclinic.clinicmanagementsystem.repository.PatientRepository;
import com.zeeclinic.clinicmanagementsystem.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final AppointmentRepository appointmentRepository;

    @Override
    public PatientResponse create(PatientRequest requestPayload) {
        Optional<Patient> checkPatient = patientRepository.findByNikAndDeletedAtIsNull(requestPayload.getNik());

        if (checkPatient.isPresent()) throw new ConflictException("Patient already exists");

        Patient patient = patientMapper.toEntity(requestPayload);

        return patientMapper.toResponse(patientRepository.save(patient));
    }

    @Override
    public List<PatientResponse> findAll() {
        List<Patient> patients = patientRepository.findAllByDeletedAtIsNull();
        return patients.stream().map(patientMapper::toResponse).toList();
    }

    @Override
    public PatientResponse findById(UUID id) {
        Patient patient = patientRepository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        return patientMapper.toResponse(patient);
    }

    @Override
    public PatientResponse update(UUID id, PatientRequest request) {

        Patient patient = patientRepository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        patientMapper.updateEntity(request, patient);
        return patientMapper.toResponse(patientRepository.save(patient));
    }

    @Override
    public void delete(UUID id) {
        Patient patient = patientRepository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        boolean hasActiveAppointment = appointmentRepository.findByPatientId(id)
                .stream()
                .anyMatch(a->a.getStatus() == Status.PENDING || a.getStatus() == Status.CONFIRMED);

        if(hasActiveAppointment){
            throw new BusinessException("Patient has an active appointment, cannot be deleted");
        }
        patient.setDeletedAt(LocalDateTime.now());
        patientRepository.save(patient);
    }

    @Override
    public PatientResponse findByNik(String nik) {
        Patient patient = patientRepository.findByNikAndDeletedAtIsNull(nik).orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        return patientMapper.toResponse(patient);
    }
}
