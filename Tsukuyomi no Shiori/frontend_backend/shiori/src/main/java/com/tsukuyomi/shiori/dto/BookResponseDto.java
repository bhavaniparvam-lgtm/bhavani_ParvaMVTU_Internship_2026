package com.tsukuyomi.shiori.dto;

import com.tsukuyomi.shiori.enums.BookStatus;

import java.time.LocalDateTime;

public class BookResponseDto {

    private Long id;
    private String title;
    private String author;
    private String coverImageUrl;
    private String description;
    private Integer moonRating;
    private Integer totalPages;
    private BookStatus status;
    private String notes;
    private String bestLiner;
    private String favouriteChapter;
    private String spiciestChapter;
    private String oneLineReaction;
    private String emotionalReactionNotes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BookResponseDto() {
    }

    public BookResponseDto(Long id, String title, String author, String coverImageUrl, String description,
                           Integer moonRating, Integer totalPages, BookStatus status, String notes, String bestLiner,
                           String favouriteChapter, String spiciestChapter, String oneLineReaction,
                           String emotionalReactionNotes, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.coverImageUrl = coverImageUrl;
        this.description = description;
        this.moonRating = moonRating;
        this.totalPages = totalPages;
        this.status = status;
        this.notes = notes;
        this.bestLiner = bestLiner;
        this.favouriteChapter = favouriteChapter;
        this.spiciestChapter = spiciestChapter;
        this.oneLineReaction = oneLineReaction;
        this.emotionalReactionNotes = emotionalReactionNotes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public Integer getMoonRating() {
        return moonRating;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public BookStatus getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public String getBestLiner() {
        return bestLiner;
    }

    public String getFavouriteChapter() {
        return favouriteChapter;
    }

    public String getSpiciestChapter() {
        return spiciestChapter;
    }

    public String getOneLineReaction() {
        return oneLineReaction;
    }

    public String getEmotionalReactionNotes() {
        return emotionalReactionNotes;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMoonRating(Integer moonRating) {
        this.moonRating = moonRating;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setBestLiner(String bestLiner) {
        this.bestLiner = bestLiner;
    }

    public void setFavouriteChapter(String favouriteChapter) {
        this.favouriteChapter = favouriteChapter;
    }

    public void setSpiciestChapter(String spiciestChapter) {
        this.spiciestChapter = spiciestChapter;
    }

    public void setOneLineReaction(String oneLineReaction) {
        this.oneLineReaction = oneLineReaction;
    }

    public void setEmotionalReactionNotes(String emotionalReactionNotes) {
        this.emotionalReactionNotes = emotionalReactionNotes;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}