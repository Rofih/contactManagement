package com.byteBuilder.contactManagement.utils;

import jakarta.validation.ValidationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralException {

    @ExceptionHandler(RuntimeException.class)
    public String runtimeException(RuntimeException e) {
        return e.getMessage();
    }

    @ExceptionHandler(ValidationException.class)
    public String validationException(ValidationException e) {
        return e.getMessage();
    }
}
