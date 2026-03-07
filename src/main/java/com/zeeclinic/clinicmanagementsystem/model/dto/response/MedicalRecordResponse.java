package com.zeeclinic.clinicmanagementsystem.model.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record MedicalRecordResponse(
        UUID id,
        UUID appointmentId,
        String patientName,
        String doctorName,
        String diagnosis,
        String prescription,
        String treatment,
        Double weight,
        Double height,
        String bloodPressure,
        LocalDate nextVisitDate,
        LocalDateTime createdAt
) {
}
