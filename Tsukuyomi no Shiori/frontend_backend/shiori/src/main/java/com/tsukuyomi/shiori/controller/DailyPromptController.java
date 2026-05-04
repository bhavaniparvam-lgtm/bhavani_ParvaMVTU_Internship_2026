package com.tsukuyomi.shiori.controller;

import com.tsukuyomi.shiori.dto.DailyPromptRequestDto;
import com.tsukuyomi.shiori.dto.DailyPromptResponseDto;
import com.tsukuyomi.shiori.service.DailyPromptService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/daily-prompts")
public class DailyPromptController {

    private final DailyPromptService dailyPromptService;

    public DailyPromptController(DailyPromptService dailyPromptService) {
        this.dailyPromptService = dailyPromptService;
    }

    @PostMapping
    public ResponseEntity<DailyPromptResponseDto> createDailyPrompt(
            @Valid @RequestBody DailyPromptRequestDto requestDto) {
        DailyPromptResponseDto createdDailyPrompt = dailyPromptService.createDailyPrompt(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDailyPrompt);
    }

    @GetMapping
    public ResponseEntity<List<DailyPromptResponseDto>> getAllDailyPrompts() {
        return ResponseEntity.ok(dailyPromptService.getAllDailyPrompts());
    }

    @GetMapping("/today")
    public ResponseEntity<DailyPromptResponseDto> getTodayPrompt() {
        return ResponseEntity.ok(dailyPromptService.getTodayPrompt());
    }
}