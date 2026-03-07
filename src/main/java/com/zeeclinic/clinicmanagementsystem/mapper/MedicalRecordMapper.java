package com.zeeclinic.clinicmanagementsystem.mapper;

import com.zeeclinic.clinicmanagementsystem.model.dto.request.MedicalRecordRequest;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.MedicalRecordResponse;
import com.zeeclinic.clinicmanagementsystem.model.entity.Appointment;
import com.zeeclinic.clinicmanagementsystem.model.entity.MedicalRecord;
import com.zeeclinic.clinicmanagementsystem.repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MedicalRecordMapper {

    private final AppointmentRepository appointmentRepository;

    public MedicalRecord toEntity(MedicalRecordRequest request){
        Appointment appointment = appointmentRepository.findById(request.getAppointmentId()).orElseThrow(()->new EntityNotFoundException("appointment not found"));

        return MedicalRecord.builder()
                .appointment(appointment)
                .diagnosis(request.getDiagnosis())
                .prescription(request.getPrescription())
                .treatment(request.getTreatment())
                .weight(request.getWeight())
                .height(request.getHeight())
                .bloodPressure(request.getBloodPressure())
                .nextVisitDate(request.getNextVisitDate())
                .build();
    }

    public MedicalRecordResponse toResponse(MedicalRecord medicalRecord){
        return new MedicalRecordResponse(
                medicalRecord.getId(),
                medicalRecord.getAppointment().getId(),
                medicalRecord.getAppointment().getPatient().getFullName(),
                medicalRecord.getAppointment().getDoctor().getFullName(),
                medicalRecord.getDiagnosis(),
                medicalRecord.getPrescription(),
                medicalRecord.getTreatment(),
                medicalRecord.getWeight(),
                medicalRecord.getHeight(),
                medicalRecord.getBloodPressure(),
                medicalRecord.getNextVisitDate(),
                medicalRecord.getCreatedAt()
        );
    }

    public void updateEntity(MedicalRecordRequest request, MedicalRecord entity){
        entity.setDiagnosis(request.getDiagnosis());
        entity.setPrescription(request.getPrescription());
        entity.setTreatment(request.getTreatment());
        entity.setWeight(request.getWeight());
        entity.setHeight(request.getHeight());
        entity.setBloodPressure(request.getBloodPressure());
        entity.setNextVisitDate(request.getNextVisitDate());
    }

}
