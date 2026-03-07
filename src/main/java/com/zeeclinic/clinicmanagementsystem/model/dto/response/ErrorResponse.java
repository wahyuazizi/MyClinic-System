package com.zeeclinic.clinicmanagementsystem.model.dto.response;

public record ErrorResponse(
        int status,
        String message,
        Object data
) {
}
