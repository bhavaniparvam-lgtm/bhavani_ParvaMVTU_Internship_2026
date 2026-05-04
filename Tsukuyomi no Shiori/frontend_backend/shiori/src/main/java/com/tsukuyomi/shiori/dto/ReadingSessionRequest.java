package com.tsukuyomi.shiori.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ReadingSessionRequest {

    @NotNull(message = "bookId is required")
    private Long bookId;

    @NotNull(message = "sessionDate is required")
    private LocalDate sessionDate;

    @NotNull(message = "pagesRead is required")
    @Min(value = 1, message = "pagesRead must be at least 1")
    private Integer pagesRead;

    @NotNull(message = "timeSpentMinutes is required")
    @Min(value = 1, message = "timeSpentMinutes must be at least 1")
    private Integer timeSpentMinutes;

    @Size(max = 2000, message = "sessionNote must not exceed 2000 characters")
    private String sessionNote;

    public ReadingSessionRequest() {
    }

    public Long getBookId() {
        return bookId;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public Integer getPagesRead() {
        return pagesRead;
    }

    public Integer getTimeSpentMinutes() {
        return timeSpentMinutes;
    }

    public String getSessionNote() {
        return sessionNote;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public void setPagesRead(Integer pagesRead) {
        this.pagesRead = pagesRead;
    }

    public void setTimeSpentMinutes(Integer timeSpentMinutes) {
        this.timeSpentMinutes = timeSpentMinutes;
    }

    public void setSessionNote(String sessionNote) {
        this.sessionNote = sessionNote;
    }
}