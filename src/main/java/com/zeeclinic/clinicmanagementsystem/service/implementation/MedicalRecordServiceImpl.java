package com.zeeclinic.clinicmanagementsystem.service.implementation;

import com.zeeclinic.clinicmanagementsystem.exception.ConflictException;
import com.zeeclinic.clinicmanagementsystem.mapper.MedicalRecordMapper;
import com.zeeclinic.clinicmanagementsystem.model.dto.request.MedicalRecordRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.MedicalRecordResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.Appointment;
import com.zeeclinic.clinicmanagementsystem.model.entity.MedicalRecord;
import com.zeeclinic.clinicmanagementsystem.model.enums.Status;
import com.zeeclinic.clinicmanagementsystem.repository.AppointmentRepository;
import com.zeeclinic.clinicmanagementsystem.repository.MedicalRecordRepository;
import com.zeeclinic.clinicmanagementsystem.service.MedicalRecordService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final MedicalRecordMapper medicalRecordMapper;
    private final AppointmentRepository appointmentRepository;

    @Override
    public MedicalRecordResponse create(MedicalRecordRequest requestPayload) {
        UUID appointmentId = requestPayload.getAppointmentId();
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(()->new EntityNotFoundException("Appointment not found"));
        if (medicalRecordRepository.existsByAppointmentId(appointmentId)){
            throw new ConflictException("Medical Record already exists for this appointment");
        }
        if (!appointment.getStatus().equals(Status.IN_PROGRESS) && !appointment.getStatus().equals(Status.DONE)){
            throw new ConflictException("Can't Create Medical Record for this appointment");
        }
        MedicalRecord medicalRecord = medicalRecordMapper.toEntity(requestPayload);
        appointment.setStatus(Status.DONE);
        appointmentRepository.save(appointment);
        return medicalRecordMapper.toResponse(medicalRecordRepository.save(medicalRecord));
    }

    @Override
    public List<MedicalRecordResponse> findAll() {
        return medicalRecordRepository.findAll().stream().map(medicalRecordMapper::toResponse).toList();
    }

    @Override
    public MedicalRecordResponse findById(UUID id) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Medical Record not found"));
        return medicalRecordMapper.toResponse(medicalRecord);
    }

    @Override
    public MedicalRecordResponse update(UUID id, MedicalRecordRequest request) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Medical Record not found"));
        medicalRecordMapper.updateEntity(request, medicalRecord);
        return medicalRecordMapper.toResponse(medicalRecordRepository.save(medicalRecord));
    }

    @Override
    public List<MedicalRecordResponse> findByPatientId(UUID id) {
        List<MedicalRecord> medicalRecordList = medicalRecordRepository.findByAppointment_Patient_Id(id);
        return medicalRecordList.stream()
                .map(medicalRecordMapper::toResponse).toList();
    }
}
