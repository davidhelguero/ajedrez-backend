package com.example.demo.exceptions;

import com.example.demo.api.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> requestExceptionHandler(MethodArgumentNotValidException e) {
        //Get spring errors
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        //Convert errors to standard string
        StringBuilder errorMessage = new StringBuilder();
        fieldErrors.forEach(f -> errorMessage.append(f.getField()).append(": ").append(f.getDefaultMessage()).append(". "));
        ErrorDTO error = ErrorDTO.builder().code(String.valueOf(ErrorCode.E102)).message(errorMessage.toString()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = com.fasterxml.jackson.databind.exc.MismatchedInputException.class)
    public ResponseEntity<ErrorDTO> InvalidFormatExceptionHandler(com.fasterxml.jackson.databind.exc.MismatchedInputException ex) {
        ErrorDTO error = ErrorDTO.builder().code(String.valueOf(ErrorCode.E103)).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorDTO> ExceptionHandler(Exception ex) {
        ErrorDTO error = ErrorDTO.builder().code(String.valueOf(ErrorCode.E500)).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
