package com.zeeclinic.clinicmanagementsystem.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class MedicalRecordRequest {

    @NotNull(message = "appointment id is required")
    private UUID appointmentId;

    @NotBlank(message = "diagnosis is required")
    @Size(max = 500, message = "diagnosis must be less than 500 characters")
    private String diagnosis;

    @Size(max = 1000, message = "prescription must be less than 1000 characters")
    private String prescription;

    @Size(max = 1000, message = "treatment must be less than 1000 characters")
    private String treatment;

    @DecimalMin(value = "1.0", message = "weight must be greater than or equal to 1.0")
    @DecimalMax(value = "500.0", message = "weight must be less than or equal to 500.0")
    private Double weight;

    @DecimalMin(value = "30.0", message = "height must be greater than or equal to 30.0")
    @DecimalMax(value = "300.0", message = "height must be less than or equal to 300.0")
    private Double height;

    @Pattern(regexp = "^\\d{2,3}/\\d{2,3}$", message = "Blood pressure format must be like 120/80")
    @Size(max = 7, message = "Blood pressure max 7 characters")
    private String bloodPressure;

    @Future(message = "next visit date must be in the future")
    private LocalDate nextVisitDate;

}
