package com.tsukuyomi.shiori.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CurrentReadRequest {

    @NotNull(message = "bookId is required")
    private Long bookId;

    @Min(value = 0, message = "pagesRead must be 0 or more")
    private Integer pagesRead;

    @Min(value = 1, message = "totalPages must be at least 1")
    private Integer totalPages;

    @Min(value = 0, message = "readingTimeMinutes must be 0 or more")
    private Integer readingTimeMinutes;

    @Size(max = 2000, message = "currentMoodNote must not exceed 2000 characters")
    private String currentMoodNote;

    @Size(max = 2000, message = "obsessionNote must not exceed 2000 characters")
    private String obsessionNote;

    public CurrentReadRequest() {
    }

    public Long getBookId() {
        return bookId;
    }

    public Integer getPagesRead() {
        return pagesRead;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getReadingTimeMinutes() {
        return readingTimeMinutes;
    }

    public String getCurrentMoodNote() {
        return currentMoodNote;
    }

    public String getObsessionNote() {
        return obsessionNote;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setPagesRead(Integer pagesRead) {
        this.pagesRead = pagesRead;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void setReadingTimeMinutes(Integer readingTimeMinutes) {
        this.readingTimeMinutes = readingTimeMinutes;
    }

    public void setCurrentMoodNote(String currentMoodNote) {
        this.currentMoodNote = currentMoodNote;
    }

    public void setObsessionNote(String obsessionNote) {
        this.obsessionNote = obsessionNote;
    }
}