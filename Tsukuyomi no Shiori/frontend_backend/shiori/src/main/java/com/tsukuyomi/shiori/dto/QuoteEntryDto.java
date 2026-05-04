package com.tsukuyomi.shiori.dto;

import java.time.LocalDateTime;

public class QuoteEntryDto {

    private Long id;
    private String quoteText;
    private String sourceName;
    private String sourceAuthor;
    private String characterName;
    private String contextNote;
    private Boolean isFavourite;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public QuoteEntryDto() {
    }

    public QuoteEntryDto(Long id, String quoteText, String sourceName, String sourceAuthor,
                         String characterName, String contextNote, Boolean isFavourite,
                         LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.quoteText = quoteText;
        this.sourceName = sourceName;
        this.sourceAuthor = sourceAuthor;
        this.characterName = characterName;
        this.contextNote = contextNote;
        this.isFavourite = isFavourite;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getSourceAuthor() {
        return sourceAuthor;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getContextNote() {
        return contextNote;
    }

    public Boolean getIsFavourite() {
        return isFavourite;
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

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public void setSourceAuthor(String sourceAuthor) {
        this.sourceAuthor = sourceAuthor;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setContextNote(String contextNote) {
        this.contextNote = contextNote;
    }

    public void setIsFavourite(Boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}