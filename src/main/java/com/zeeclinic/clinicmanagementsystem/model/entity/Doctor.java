package com.zeeclinic.clinicmanagementsystem.model.entity;

import com.zeeclinic.clinicmanagementsystem.model.enums.Specialization;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "m_doctor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @NotBlank
    @Size(max = 100)
    private String fullName;

    @Column(unique = true)
    @NotBlank
    private String licenseNumber;

    @NotNull
    private Specialization specialization;

    @NotBlank
    @Size(max = 15)
    private String phoneNumber;

    @Column(unique = true)
    @Email
    private String email;

    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;
}
