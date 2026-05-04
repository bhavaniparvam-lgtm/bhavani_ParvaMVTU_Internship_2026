package com.tsukuyomi.shiori.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreativeEntryRequestDto {

    @NotBlank(message = "Entry text is required")
    private String entryText;

    @NotBlank(message = "Entry type is required")
    @Size(max = 100, message = "Entry type must not exceed 100 characters")
    private String entryType;

    private Long bookId;

    public CreativeEntryRequestDto() {
    }

    public CreativeEntryRequestDto(String entryText, String entryType, Long bookId) {
        this.entryText = entryText;
        this.entryType = entryType;
        this.bookId = bookId;
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

    public void setEntryText(String entryText) {
        this.entryText = entryText;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}