package com.zeeclinic.clinicmanagementsystem.model.dto.request;

import com.zeeclinic.clinicmanagementsystem.model.enums.BloodType;
import com.zeeclinic.clinicmanagementsystem.model.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PatientRequest {

    @NotBlank(message = "full name is required")
    private String fullName;

    @NotBlank(message = "nik is required")
    @Size(min = 16, max = 16, message = "nik must be 16 characters")
    private String nik;

    @NotNull(message = "birth date is required")
    @Past(message = "birth date must be in the past")
    private LocalDate birthDate;

    @NotBlank(message = "phone number is required")
    private String phoneNumber;

    private Gender gender;

    @Email(message = "email must be valid")
    private String email;

    private String address;

    private BloodType bloodType;
}
