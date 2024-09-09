package com.senpiper.Liv2TrainRegistry.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorResponse {

    private LocalDateTime timestamp;
    private String message;
    private List<String> errors;
}
