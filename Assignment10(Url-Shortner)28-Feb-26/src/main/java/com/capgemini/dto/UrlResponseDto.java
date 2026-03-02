package com.capgemini.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UrlResponseDto {

    private String shortCode;
    private String shortUrl;
    private String originalUrl;
    private Long clickCount;
    private LocalDateTime createdAt;
}
