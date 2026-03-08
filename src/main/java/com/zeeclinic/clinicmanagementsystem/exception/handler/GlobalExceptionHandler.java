package com.zeeclinic.clinicmanagementsystem.exception.handler;

import com.zeeclinic.clinicmanagementsystem.exception.BusinessException;
import com.zeeclinic.clinicmanagementsystem.exception.ConflictException;
import com.zeeclinic.clinicmanagementsystem.exception.DuplicateException;
import com.zeeclinic.clinicmanagementsystem.model.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> handnleConflict(ConflictException e){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                e.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.UNPROCESSABLE_CONTENT.value(),
                e.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(errorResponse);
    }

}
