package com.zeeclinic.clinicmanagementsystem.model;

import com.zeeclinic.clinicmanagementsystem.utils.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "t_appointment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @NotNull
    @FutureOrPresent
    private LocalDate appointmentDate;

    @NotNull
    private LocalTime appointmentTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.PENDING;

    @NotBlank
    @Size(max = 500)
    private String complaint;

    @Size(max = 1000)
    private String notes;
}
