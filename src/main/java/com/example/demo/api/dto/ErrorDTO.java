package com.example.demo.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private final String code;
    private final String message;
}
