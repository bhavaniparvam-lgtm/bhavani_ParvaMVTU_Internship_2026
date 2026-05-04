package com.tsukuyomi.shiori.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsukuyomi.shiori.dto.DailyPromptRequestDto;
import com.tsukuyomi.shiori.dto.DailyPromptResponseDto;
import com.tsukuyomi.shiori.entity.DailyPrompt;
import com.tsukuyomi.shiori.repository.DailyPromptRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class DailyPromptService {

    private final DailyPromptRepository dailyPromptRepository;
    private final ObjectMapper objectMapper;

    public DailyPromptService(DailyPromptRepository dailyPromptRepository, ObjectMapper objectMapper) {
        this.dailyPromptRepository = dailyPromptRepository;
        this.objectMapper = objectMapper;
    }

    public DailyPromptResponseDto createDailyPrompt(DailyPromptRequestDto requestDto) {
        DailyPrompt dailyPrompt = new DailyPrompt();
        dailyPrompt.setPromptText(requestDto.getPromptText());
        dailyPrompt.setPromptDate(requestDto.getPromptDate());
        dailyPrompt.setIsActive(requestDto.getIsActive());

        DailyPrompt savedDailyPrompt = dailyPromptRepository.save(dailyPrompt);
        return mapToResponseDto(savedDailyPrompt);
    }

    public List<DailyPromptResponseDto> getAllDailyPrompts() {
        return dailyPromptRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    public DailyPromptResponseDto getTodayPrompt() {
        LocalDate today = LocalDate.now();

        return dailyPromptRepository.findByPromptDate(today)
                .map(this::mapToResponseDto)
                .orElseGet(() -> {
                    String promptText = getRandomPromptFromFile();

                    DailyPrompt dailyPrompt = new DailyPrompt();
                    dailyPrompt.setPromptText(promptText);
                    dailyPrompt.setPromptDate(today);
                    dailyPrompt.setIsActive(true);

                    DailyPrompt savedDailyPrompt = dailyPromptRepository.save(dailyPrompt);
                    return mapToResponseDto(savedDailyPrompt);
                });
    }

    private String getRandomPromptFromFile() {
        try {
            ClassPathResource resource = new ClassPathResource("daily-prompts.json");
            InputStream inputStream = resource.getInputStream();

            List<String> prompts = objectMapper.readValue(inputStream, new TypeReference<List<String>>() {});

            if (prompts == null || prompts.isEmpty()) {
                throw new RuntimeException("No prompts found in daily-prompts.json");
            }

            int randomIndex = ThreadLocalRandom.current().nextInt(prompts.size());
            return prompts.get(randomIndex);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load daily prompts from file", e);
        }
    }

    private DailyPromptResponseDto mapToResponseDto(DailyPrompt dailyPrompt) {
        return new DailyPromptResponseDto(
                dailyPrompt.getId(),
                dailyPrompt.getPromptText(),
                dailyPrompt.getPromptDate(),
                dailyPrompt.getIsActive()
        );
    }
}