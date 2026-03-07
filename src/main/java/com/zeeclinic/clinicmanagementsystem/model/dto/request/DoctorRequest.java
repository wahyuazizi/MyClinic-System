package com.zeeclinic.clinicmanagementsystem.model.dto.request;

import com.zeeclinic.clinicmanagementsystem.model.enums.Specialization;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DoctorRequest {

    @NotBlank(message = "full name is required")
    private String fullName;

    @NotBlank(message = "license number is required")
    private String licenseNumber;

    @NotNull(message = "specialization is required")
    private Specialization specialization;

    @NotBlank(message = "phone number is required")
    private String phoneNumber;

    @Email(message = "email must be valid")
    private String email;

}
