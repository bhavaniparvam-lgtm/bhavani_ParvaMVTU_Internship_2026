package com.tsukuyomi.shiori.dto;

import com.tsukuyomi.shiori.enums.BookStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BookRequestDto {

    @NotBlank(message = "Title is required")
    @Size(max = 200, message = "Title cannot exceed 200 characters")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(max = 150, message = "Author cannot exceed 150 characters")
    private String author;

    @Size(max = 500, message = "Cover image URL cannot exceed 500 characters")
    private String coverImageUrl;

    private String description;

    @Min(value = 1, message = "Moon rating must be at least 1")
    @Max(value = 5, message = "Moon rating cannot exceed 5")
    private Integer moonRating;

    @Min(value = 1, message = "Total pages must be at least 1")
    private Integer totalPages;

    @NotNull(message = "Book status is required")
    private BookStatus status;

    private String notes;
    private String bestLiner;
    private String favouriteChapter;
    private String spiciestChapter;

    @Size(max = 300, message = "One-line reaction cannot exceed 300 characters")
    private String oneLineReaction;

    private String emotionalReactionNotes;

    public BookRequestDto() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMoonRating() {
        return moonRating;
    }

    public void setMoonRating(Integer moonRating) {
        this.moonRating = moonRating;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBestLiner() {
        return bestLiner;
    }

    public void setBestLiner(String bestLiner) {
        this.bestLiner = bestLiner;
    }

    public String getFavouriteChapter() {
        return favouriteChapter;
    }

    public void setFavouriteChapter(String favouriteChapter) {
        this.favouriteChapter = favouriteChapter;
    }

    public String getSpiciestChapter() {
        return spiciestChapter;
    }

    public void setSpiciestChapter(String spiciestChapter) {
        this.spiciestChapter = spiciestChapter;
    }

    public String getOneLineReaction() {
        return oneLineReaction;
    }

    public void setOneLineReaction(String oneLineReaction) {
        this.oneLineReaction = oneLineReaction;
    }

    public String getEmotionalReactionNotes() {
        return emotionalReactionNotes;
    }

    public void setEmotionalReactionNotes(String emotionalReactionNotes) {
        this.emotionalReactionNotes = emotionalReactionNotes;
    }
}