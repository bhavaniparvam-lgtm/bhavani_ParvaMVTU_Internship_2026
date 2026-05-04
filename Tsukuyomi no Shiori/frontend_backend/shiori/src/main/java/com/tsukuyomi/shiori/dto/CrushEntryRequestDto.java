package com.tsukuyomi.shiori.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CrushEntryRequestDto {

    @NotBlank(message = "Character name is required")
    @Size(max = 150, message = "Character name must not exceed 150 characters")
    private String characterName;

    private Long bookId;

    @Size(max = 500, message = "Image URL must not exceed 500 characters")
    private String imageUrl;

    @Size(max = 150, message = "Trope must not exceed 150 characters")
    private String trope;

    private String redFlagGreenFlagNote;

    private String favouriteQuote;

    private String reasonForLikingCharacter;

    private String whyImDownBadNote;

    public CrushEntryRequestDto() {
    }

    public CrushEntryRequestDto(String characterName, Long bookId, String imageUrl, String trope,
                                String redFlagGreenFlagNote, String favouriteQuote,
                                String reasonForLikingCharacter, String whyImDownBadNote) {
        this.characterName = characterName;
        this.bookId = bookId;
        this.imageUrl = imageUrl;
        this.trope = trope;
        this.redFlagGreenFlagNote = redFlagGreenFlagNote;
        this.favouriteQuote = favouriteQuote;
        this.reasonForLikingCharacter = reasonForLikingCharacter;
        this.whyImDownBadNote = whyImDownBadNote;
    }

    public String getCharacterName() {
        return characterName;
    }

    public Long getBookId() {
        return bookId;
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

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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
}