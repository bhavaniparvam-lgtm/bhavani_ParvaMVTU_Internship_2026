package com.tsukuyomi.shiori.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CurrentVoyageResponse {

    private Long bookId;
    private String title;
    private String author;
    private String coverImageUrl;
    private String status;
    private Integer totalPages;
    private Integer pagesRead;
    private Integer progressPercentage;
    private Integer readingTimeMinutes;
    private String currentMoodNote;
    private String latestSessionNote;
    private LocalDate latestReadingDate;
    private LocalDateTime latestSessionCreatedAt;

    public CurrentVoyageResponse() {
    }

    public CurrentVoyageResponse(Long bookId, String title, String author, String coverImageUrl, String status,
                                 Integer totalPages, Integer pagesRead, Integer progressPercentage,
                                 Integer readingTimeMinutes, String currentMoodNote, String latestSessionNote,
                                 LocalDate latestReadingDate, LocalDateTime latestSessionCreatedAt) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.coverImageUrl = coverImageUrl;
        this.status = status;
        this.totalPages = totalPages;
        this.pagesRead = pagesRead;
        this.progressPercentage = progressPercentage;
        this.readingTimeMinutes = readingTimeMinutes;
        this.currentMoodNote = currentMoodNote;
        this.latestSessionNote = latestSessionNote;
        this.latestReadingDate = latestReadingDate;
        this.latestSessionCreatedAt = latestSessionCreatedAt;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(Integer pagesRead) {
        this.pagesRead = pagesRead;
    }

    public Integer getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(Integer progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public Integer getReadingTimeMinutes() {
        return readingTimeMinutes;
    }

    public void setReadingTimeMinutes(Integer readingTimeMinutes) {
        this.readingTimeMinutes = readingTimeMinutes;
    }

    public String getCurrentMoodNote() {
        return currentMoodNote;
    }

    public void setCurrentMoodNote(String currentMoodNote) {
        this.currentMoodNote = currentMoodNote;
    }

    public String getLatestSessionNote() {
        return latestSessionNote;
    }

    public void setLatestSessionNote(String latestSessionNote) {
        this.latestSessionNote = latestSessionNote;
    }

    public LocalDate getLatestReadingDate() {
        return latestReadingDate;
    }

    public void setLatestReadingDate(LocalDate latestReadingDate) {
        this.latestReadingDate = latestReadingDate;
    }

    public LocalDateTime getLatestSessionCreatedAt() {
        return latestSessionCreatedAt;
    }

    public void setLatestSessionCreatedAt(LocalDateTime latestSessionCreatedAt) {
        this.latestSessionCreatedAt = latestSessionCreatedAt;
    }
}