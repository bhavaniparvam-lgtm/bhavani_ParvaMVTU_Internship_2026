package com.tsukuyomi.shiori.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class QuoteEntryRequestDto {

    @NotBlank(message = "Quote text is required")
    private String quoteText;

    @Size(max = 150, message = "Author cannot exceed 150 characters")
    private String author;

    @Size(max = 200, message = "Source cannot exceed 200 characters")
    private String source;

    public QuoteEntryRequestDto() {
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}