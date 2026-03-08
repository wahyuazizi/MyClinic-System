package com.zeeclinic.clinicmanagementsystem.model.entity;

import com.zeeclinic.clinicmanagementsystem.model.enums.Specialization;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "m_doctor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 100)
    private String fullName;

    @Column(unique = true, nullable = false)
    @NotBlank
    @Size(max = 50)
    private String licenseNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Specialization specialization;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 15)
    @Pattern(regexp = "^(\\+62|0)\\d{7,13}$")
    private String phoneNumber;

    @Column(unique = true)
    @Email
    @Size(max = 100)
    private String email;

    @Column(nullable = false, columnDefinition = "boolean default true")
    @NotNull
    private Boolean isActive = true;
}
