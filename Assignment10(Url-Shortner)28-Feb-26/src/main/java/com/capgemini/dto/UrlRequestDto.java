package com.capgemini.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UrlRequestDto {

    @NotBlank(message = "Original URL must not be blank")
    private String originalUrl;

    private String customAlias;
}