package com.zeeclinic.clinicmanagementsystem.model.dto.request;

import com.zeeclinic.clinicmanagementsystem.model.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PatientRequest {

    @NotNull(message = "id is required")
    private UUID id;

    @NotBlank(message = "full name is required")
    private String fullName;

    @NotBlank(message = "nik is required")
    private String nik;

    @NotNull(message = "birth date is required")
    private LocalDate birthDate;

    @NotBlank(message = "phone number is required")
    private String phoneNumber;

    private Gender gender;

    private String email;

    private String address;

    private String bloodType;
}
