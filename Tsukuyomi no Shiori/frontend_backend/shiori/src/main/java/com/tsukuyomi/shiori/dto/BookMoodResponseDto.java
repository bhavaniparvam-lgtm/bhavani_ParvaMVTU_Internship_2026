package com.tsukuyomi.shiori.dto;

import java.time.LocalDateTime;

public class BookMoodResponseDto {

    private Long id;
    private Long moodTagId;
    private String moodName;
    private Integer intensity;
    private String note;
    private LocalDateTime createdAt;

    public BookMoodResponseDto() {
    }

    public BookMoodResponseDto(Long id, Long moodTagId, String moodName, Integer intensity, String note, LocalDateTime createdAt) {
        this.id = id;
        this.moodTagId = moodTagId;
        this.moodName = moodName;
        this.intensity = intensity;
        this.note = note;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getMoodTagId() {
        return moodTagId;
    }

    public String getMoodName() {
        return moodName;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public String getNote() {
        return note;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMoodTagId(Long moodTagId) {
        this.moodTagId = moodTagId;
    }

    public void setMoodName(String moodName) {
        this.moodName = moodName;
    }

    public void setIntensity(Integer intensity) {
        this.intensity = intensity;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}