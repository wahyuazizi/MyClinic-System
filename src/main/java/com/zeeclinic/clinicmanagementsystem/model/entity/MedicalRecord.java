package com.zeeclinic.clinicmanagementsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "t_medical_record")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalRecord {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @NotBlank
    @Size(max = 500)
    private String diagnosis;

    @Size(max = 1000)
    private String prescription;

    @Size(max = 1000)
    private String treatment;

    @Min(1)
    @Max(500)
    private Double weight;

    @Min(30)
    @Max(300)
    private Double height;

    @Size(max = 20)
    private String bloodPressure;

    private LocalDate nextVisiteDate;

}
