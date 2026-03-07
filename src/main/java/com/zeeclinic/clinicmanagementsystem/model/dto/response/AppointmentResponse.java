package com.zeeclinic.clinicmanagementsystem.model.dto.response;

import com.zeeclinic.clinicmanagementsystem.model.enums.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentResponse(
        UUID id,
        String patientName,
        String doctorName,
        LocalDateTime appointmentDateTime,
        Status status,
        String complaint,
        String notes,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
