package com.tsukuyomi.shiori.dto;

import java.time.LocalDateTime;

public class CurrentReadResponse {

    private Long id;
    private Long bookId;
    private String bookTitle;
    private String bookAuthor;
    private Integer pagesRead;
    private Integer totalPages;
    private Integer progressPercentage;
    private Integer readingTimeMinutes;
    private String currentMoodNote;
    private String obsessionNote;
    private LocalDateTime lastReadAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CurrentReadResponse() {
    }

    public CurrentReadResponse(Long id, Long bookId, String bookTitle, String bookAuthor,
                               Integer pagesRead, Integer totalPages, Integer progressPercentage,
                               Integer readingTimeMinutes, String currentMoodNote, String obsessionNote,
                               LocalDateTime lastReadAt, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.pagesRead = pagesRead;
        this.totalPages = totalPages;
        this.progressPercentage = progressPercentage;
        this.readingTimeMinutes = readingTimeMinutes;
        this.currentMoodNote = currentMoodNote;
        this.obsessionNote = obsessionNote;
        this.lastReadAt = lastReadAt;
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

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Integer getPagesRead() {
        return pagesRead;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getProgressPercentage() {
        return progressPercentage;
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

    public LocalDateTime getLastReadAt() {
        return lastReadAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}