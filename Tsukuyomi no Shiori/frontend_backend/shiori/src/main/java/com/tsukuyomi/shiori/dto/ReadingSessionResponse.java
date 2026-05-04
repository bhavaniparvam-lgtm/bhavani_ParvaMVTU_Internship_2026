package com.tsukuyomi.shiori.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReadingSessionResponse {

    private Long id;
    private Long bookId;
    private String bookTitle;
    private LocalDate sessionDate;
    private Integer pagesRead;
    private Integer timeSpentMinutes;
    private String sessionNote;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ReadingSessionResponse() {
    }

    public ReadingSessionResponse(Long id, Long bookId, String bookTitle, LocalDate sessionDate,
                                  Integer pagesRead, Integer timeSpentMinutes, String sessionNote,
                                  LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.sessionDate = sessionDate;
        this.pagesRead = pagesRead;
        this.timeSpentMinutes = timeSpentMinutes;
        this.sessionNote = sessionNote;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}