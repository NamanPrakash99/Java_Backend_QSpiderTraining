package com.capgemini.dto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponseDto {

    private LocalDateTime timestamp;
    private int status;
    private String message;
}