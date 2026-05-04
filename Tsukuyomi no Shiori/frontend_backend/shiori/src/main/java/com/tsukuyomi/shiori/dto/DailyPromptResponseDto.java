package com.tsukuyomi.shiori.dto;

import java.time.LocalDate;

public class DailyPromptResponseDto {

    private Long id;
    private String promptText;
    private LocalDate promptDate;
    private Boolean isActive;

    public DailyPromptResponseDto() {
    }

    public DailyPromptResponseDto(Long id, String promptText, LocalDate promptDate, Boolean isActive) {
        this.id = id;
        this.promptText = promptText;
        this.promptDate = promptDate;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getPromptText() {
        return promptText;
    }

    public LocalDate getPromptDate() {
        return promptDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }

    public void setPromptDate(LocalDate promptDate) {
        this.promptDate = promptDate;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}