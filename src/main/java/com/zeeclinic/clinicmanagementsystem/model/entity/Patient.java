package com.zeeclinic.clinicmanagementsystem.model.entity;

import com.zeeclinic.clinicmanagementsystem.model.enums.BloodType;
import com.zeeclinic.clinicmanagementsystem.model.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "m_patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 100)
    private String fullName;

    @Column(unique = true, nullable = false)
    @NotBlank
    @Size(min = 16, max = 16)
    private String nik;

    @Column(nullable = false)
    @NotNull
    @Past
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 15)
    private String phoneNumber;

    @Email
    private String email;

    @Size(max = 255)
    private String address;

    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    private LocalDateTime deletedAt;
}
