package com.capgemini.controller;

import org.springframework.http.HttpHeaders;
import java.util.List;	

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dto.StatsDto;
import com.capgemini.dto.UrlRequestDto;
import com.capgemini.dto.UrlResponseDto;
import com.capgemini.service.UrlMappingService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UrlMappingController {

    private final UrlMappingService service;

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponseDto> create(
            @Valid @RequestBody UrlRequestDto request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createShortUrl(request));
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        String originalUrl = service.resolveUrl(shortCode);

        return ResponseEntity.status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, originalUrl)
                .build();
    }

    @GetMapping("/stats/{shortCode}")
    public ResponseEntity<StatsDto> stats(@PathVariable String shortCode) {

        return ResponseEntity.ok(service.getStats(shortCode));
    }

    @GetMapping("/urls")
    public ResponseEntity<Page<UrlResponseDto>> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(service.getAllUrls(page, size));
    }

    @DeleteMapping("/{shortCode}")
    public ResponseEntity<Void> delete(@PathVariable String shortCode) {

        service.deleteByShortCode(shortCode);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/top")
    public ResponseEntity<List<UrlResponseDto>> top() {

        return ResponseEntity.ok(service.getTop5());
    }
}