package com.zeeclinic.clinicmanagementsystem.model;

import com.zeeclinic.clinicmanagementsystem.utils.enums.BloodType;
import com.zeeclinic.clinicmanagementsystem.utils.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "m_patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient extends Base {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @NotBlank
    @Size(max = 100)
    private String fullName;

    @Column(unique = true)
    @Size(min = 16, max = 16)
    private String nik;

    @NotNull
    @Past
    private LocalDate birthDate;

    private Gender gender;
    @NotBlank
    @Size(max = 15)
    private String phoneNumber;

    @Email
    private String email;

    @Size(max = 255)
    private String address;

    private BloodType bloodType;
}
