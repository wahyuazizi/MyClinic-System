package com.zeeclinic.clinicmanagementsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "t_medical_record")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalRecord extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    @NotNull
    private Appointment appointment;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 500)
    private String diagnosis;

    @Size(max = 1000)
    private String prescription;

    @Size(max = 1000)
    private String treatment;

    @DecimalMin(value = "1.0")
    @DecimalMax(value = "500.0")
    private Double weight;

    @DecimalMin(value = "30.0")
    @DecimalMax(value = "300.0")
    private Double height;

    @Size(max = 20)
    private String bloodPressure;

    @Future
    private LocalDate nextVisitDate;

}
