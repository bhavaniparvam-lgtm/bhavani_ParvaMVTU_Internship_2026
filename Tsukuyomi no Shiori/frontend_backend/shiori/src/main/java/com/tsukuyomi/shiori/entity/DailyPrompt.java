package com.tsukuyomi.shiori.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "daily_prompt")
public class DailyPrompt extends BaseEntity {

    private String promptText;

    private LocalDate promptDate;

    private Boolean isActive;

    public DailyPrompt() {
    }

    public DailyPrompt(String promptText, LocalDate promptDate, Boolean isActive) {
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