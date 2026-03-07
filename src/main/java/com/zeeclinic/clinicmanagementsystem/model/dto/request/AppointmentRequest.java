package com.zeeclinic.clinicmanagementsystem.model.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentRequest {

    @NotNull(message = "patient id is required")
    private UUID patientId;

    @NotNull(message = "doctor id is required")
    private UUID doctorId;

    @NotNull(message = "appointment date time is required")
    @FutureOrPresent(message = "appointment date time must be in the future or present")
    private LocalDateTime appointmentDateTime;

    @NotBlank(message = "complaint is required")
    @Size(max = 500, message = "complaint must be less than 500 characters")
    private String complaint;

    @Size(max = 1000, message = "notes must be less than 1000 characters")
    private String notes;


}
