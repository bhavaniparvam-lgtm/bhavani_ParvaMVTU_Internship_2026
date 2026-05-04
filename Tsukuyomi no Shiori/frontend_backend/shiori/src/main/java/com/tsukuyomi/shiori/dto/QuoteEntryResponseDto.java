package com.tsukuyomi.shiori.dto;

import java.time.LocalDateTime;

public class QuoteEntryResponseDto {

    private Long id;
    private String quoteText;
    private String author;
    private String source;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public QuoteEntryResponseDto() {
    }

    public QuoteEntryResponseDto(Long id, String quoteText, String author, String source,
                                 LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.quoteText = quoteText;
        this.author = author;
        this.source = source;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public String getAuthor() {
        return author;
    }

    public String getSource() {
        return source;
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

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}