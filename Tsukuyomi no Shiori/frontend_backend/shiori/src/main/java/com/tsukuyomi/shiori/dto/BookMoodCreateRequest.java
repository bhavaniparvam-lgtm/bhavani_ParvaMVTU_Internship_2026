package com.tsukuyomi.shiori.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BookMoodCreateRequest {

    @NotNull(message = "moodTagId is required")
    private Long moodTagId;

    @Size(max = 255, message = "note must not exceed 255 characters")
    private String note;

    @NotNull(message = "intensity is required")
    @Min(value = 1, message = "intensity must be at least 1")
    @Max(value = 5, message = "intensity must not exceed 5")
    private Integer intensity;

    public BookMoodCreateRequest() {
    }

    public Long getMoodTagId() {
        return moodTagId;
    }

    public void setMoodTagId(Long moodTagId) {
        this.moodTagId = moodTagId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public void setIntensity(Integer intensity) {
        this.intensity = intensity;
    }
}