package com.capgemini.service;

import java.util.List;
import java.util.Random;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.capgemini.dto.StatsDto;
import com.capgemini.dto.UrlRequestDto;
import com.capgemini.dto.UrlResponseDto;
import com.capgemini.entity.UrlMapping;
import com.capgemini.exception.ShortCodeAlreadyExistsException;
import com.capgemini.exception.ShortCodeNotFoundException;
import com.capgemini.repository.UrlMappingRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlMappingService {

	private final UrlMappingRepository repository;

	private static final String BASE_URL = "http://localhost:8080/api/";
	private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int CODE_LENGTH = 6;

	private String generateCode() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < CODE_LENGTH; i++) {
			sb.append(CHAR_SET.charAt(random.nextInt(CHAR_SET.length())));
		}
		return sb.toString();
	}

	@Transactional
	public UrlResponseDto createShortUrl(UrlRequestDto request) {

		String code = request.getCustomAlias();

		if (code != null && !code.isBlank()) {
			if (repository.existsByShortCode(code)) {
				throw new ShortCodeAlreadyExistsException("Custom alias already exists");
			}
		} else {
			do {
				code = generateCode();
			} while (repository.existsByShortCode(code));
		}

		UrlMapping mapping = UrlMapping.builder().originalUrl(request.getOriginalUrl()).shortCode(code).clickCount(0L)
				.build();

		repository.save(mapping);

		return UrlResponseDto.builder().shortCode(code).shortUrl(BASE_URL + code).originalUrl(mapping.getOriginalUrl())
				.clickCount(mapping.getClickCount()).createdAt(mapping.getCreatedAt()).build();
	}

	@Transactional
	public String resolveUrl(String shortCode) {

		UrlMapping mapping = repository.findByShortCode(shortCode)
				.orElseThrow(() -> new ShortCodeNotFoundException("Short code not found"));

		mapping.setClickCount(mapping.getClickCount() + 1);

		return mapping.getOriginalUrl();
	}

	public StatsDto getStats(String shortCode) {

		UrlMapping mapping = repository.findByShortCode(shortCode)
				.orElseThrow(() -> new ShortCodeNotFoundException("Short code not found"));

		return StatsDto.builder().shortCode(mapping.getShortCode()).originalUrl(mapping.getOriginalUrl())
				.clickCount(mapping.getClickCount()).createdAt(mapping.getCreatedAt()).updatedAt(mapping.getUpdatedAt())
				.build();
	}

	public Page<UrlResponseDto> getAllUrls(int page, int size) {

		Page<UrlMapping> result = repository.findAll(PageRequest.of(page, size));

		return result.map(mapping -> UrlResponseDto.builder().shortCode(mapping.getShortCode())
				.shortUrl(BASE_URL + mapping.getShortCode()).originalUrl(mapping.getOriginalUrl())
				.clickCount(mapping.getClickCount()).createdAt(mapping.getCreatedAt()).build());
	}

	public List<UrlResponseDto> getTop5() {

		List<UrlMapping> top = repository.findTop5ByOrderByClickCountDesc(PageRequest.of(0, 5));

		return top.stream()
				.map(mapping -> UrlResponseDto.builder().shortCode(mapping.getShortCode())
						.shortUrl(BASE_URL + mapping.getShortCode()).originalUrl(mapping.getOriginalUrl())
						.clickCount(mapping.getClickCount()).createdAt(mapping.getCreatedAt()).build())
				.toList();
	}

	@Transactional
	public void deleteByShortCode(String shortCode) {

		UrlMapping mapping = repository.findByShortCode(shortCode)
				.orElseThrow(() -> new ShortCodeNotFoundException("Short code not found"));

		repository.delete(mapping);
	}
}