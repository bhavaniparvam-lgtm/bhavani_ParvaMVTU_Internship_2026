package com.tsukuyomi.shiori.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BookMoodRequestDto {

    @NotNull(message = "Mood tag id is required")
    private Long moodTagId;

    @NotNull(message = "Intensity is required")
    @Min(value = 1, message = "Intensity must be at least 1")
    @Max(value = 5, message = "Intensity must be at most 5")
    private Integer intensity;

    @Size(max = 500, message = "Note must be at most 500 characters")
    private String note;

    public BookMoodRequestDto() {
    }

    public Long getMoodTagId() {
        return moodTagId;
    }

    public void setMoodTagId(Long moodTagId) {
        this.moodTagId = moodTagId;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public void setIntensity(Integer intensity) {
        this.intensity = intensity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}