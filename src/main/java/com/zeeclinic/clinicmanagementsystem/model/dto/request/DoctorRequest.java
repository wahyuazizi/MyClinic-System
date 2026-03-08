package com.zeeclinic.clinicmanagementsystem.model.dto.request;

import com.zeeclinic.clinicmanagementsystem.model.enums.Specialization;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "^(\\+62|0)\\d{7,13}$", message = "Invalid phone number format")
    private String phoneNumber;

    @Email(message = "email must be valid")
    private String email;

}
