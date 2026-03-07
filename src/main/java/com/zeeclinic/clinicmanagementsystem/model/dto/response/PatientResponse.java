package com.zeeclinic.clinicmanagementsystem.model.dto.response;

import com.zeeclinic.clinicmanagementsystem.model.enums.BloodType;
import com.zeeclinic.clinicmanagementsystem.model.enums.Gender;

import java.time.LocalDate;
import java.util.UUID;

public record PatientResponse(
        UUID id,
        String fullName,
        String nik,
        LocalDate birthDate,
        Gender gender,
        String phoneNumber,
        String email,
        String address,
        BloodType bloodType
) {
}
