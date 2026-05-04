package com.tsukuyomi.shiori.dto;

import java.time.LocalDateTime;

public class CrushEntryResponseDto {

    private Long id;
    private String characterName;
    private Long bookId;
    private String bookTitle;
    private String imageUrl;
    private String trope;
    private String redFlagGreenFlagNote;
    private String favouriteQuote;
    private String reasonForLikingCharacter;
    private String whyImDownBadNote;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CrushEntryResponseDto() {
    }

    public CrushEntryResponseDto(Long id, String characterName, Long bookId, String bookTitle, String imageUrl,
                                 String trope, String redFlagGreenFlagNote, String favouriteQuote,
                                 String reasonForLikingCharacter, String whyImDownBadNote,
                                 LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.characterName = characterName;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.imageUrl = imageUrl;
        this.trope = trope;
        this.redFlagGreenFlagNote = redFlagGreenFlagNote;
        this.favouriteQuote = favouriteQuote;
        this.reasonForLikingCharacter = reasonForLikingCharacter;
        this.whyImDownBadNote = whyImDownBadNote;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTrope() {
        return trope;
    }

    public String getRedFlagGreenFlagNote() {
        return redFlagGreenFlagNote;
    }

    public String getFavouriteQuote() {
        return favouriteQuote;
    }

    public String getReasonForLikingCharacter() {
        return reasonForLikingCharacter;
    }

    public String getWhyImDownBadNote() {
        return whyImDownBadNote;
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

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTrope(String trope) {
        this.trope = trope;
    }

    public void setRedFlagGreenFlagNote(String redFlagGreenFlagNote) {
        this.redFlagGreenFlagNote = redFlagGreenFlagNote;
    }

    public void setFavouriteQuote(String favouriteQuote) {
        this.favouriteQuote = favouriteQuote;
    }

    public void setReasonForLikingCharacter(String reasonForLikingCharacter) {
        this.reasonForLikingCharacter = reasonForLikingCharacter;
    }

    public void setWhyImDownBadNote(String whyImDownBadNote) {
        this.whyImDownBadNote = whyImDownBadNote;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}