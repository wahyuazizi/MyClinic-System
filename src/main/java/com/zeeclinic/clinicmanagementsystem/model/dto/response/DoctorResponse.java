package com.zeeclinic.clinicmanagementsystem.model.dto.response;

import com.zeeclinic.clinicmanagementsystem.model.enums.Specialization;

import java.util.UUID;

public record DoctorResponse(
        UUID id,
        String fullName,
        String licenseNumber,
        Specialization specialization,
        String phoneNumber,
        String email,
        Boolean isActive
) {
}
