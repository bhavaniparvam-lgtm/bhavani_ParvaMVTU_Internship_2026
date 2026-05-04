package com.tsukuyomi.shiori.dto;

import java.time.LocalDateTime;

public class CreativeEntryResponseDto {

    private Long id;
    private String entryText;
    private String entryType;
    private Long bookId;
    private String bookTitle;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CreativeEntryResponseDto() {
    }

    public CreativeEntryResponseDto(Long id, String entryText, String entryType, Long bookId,
                                    String bookTitle, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.entryText = entryText;
        this.entryType = entryType;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getEntryText() {
        return entryText;
    }

    public String getEntryType() {
        return entryType;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEntryText(String entryText) {
        this.entryText = entryText;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}