package com.tsukuyomi.shiori.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class DailyPromptRequestDto {

    @NotBlank(message = "Prompt text is required")
    private String promptText;

    @NotNull(message = "Prompt date is required")
    private LocalDate promptDate;

    @NotNull(message = "Is active is required")
    private Boolean isActive;

    public DailyPromptRequestDto() {
    }

    public DailyPromptRequestDto(String promptText, LocalDate promptDate, Boolean isActive) {
        this.promptText = promptText;
        this.promptDate = promptDate;
        this.isActive = isActive;
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