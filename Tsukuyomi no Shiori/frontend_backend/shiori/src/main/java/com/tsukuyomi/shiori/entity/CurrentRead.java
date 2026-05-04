package com.tsukuyomi.shiori.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "current_reads")
public class CurrentRead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "book_id",
            nullable = false,
            unique = true,
            foreignKey = @ForeignKey(name = "fk_current_reads_book")
    )
    private Book book;

    @Column(name = "pages_read")
    private Integer pagesRead;

    @Column(name = "total_pages")
    private Integer totalPages;

    @Column(name = "progress_percentage")
    private Integer progressPercentage;

    @Column(name = "reading_time_minutes")
    private Integer readingTimeMinutes;

    @Column(name = "current_mood_note", columnDefinition = "TEXT")
    private String currentMoodNote;

    @Column(name = "obsession_note", columnDefinition = "TEXT")
    private String obsessionNote;

    @Column(name = "last_read_at")
    private LocalDateTime lastReadAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CurrentRead() {
    }

    public CurrentRead(Long id, Book book, Integer pagesRead, Integer totalPages, Integer progressPercentage,
                       Integer readingTimeMinutes, String currentMoodNote, String obsessionNote,
                       LocalDateTime lastReadAt, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.book = book;
        this.pagesRead = pagesRead;
        this.totalPages = totalPages;
        this.progressPercentage = progressPercentage;
        this.readingTimeMinutes = readingTimeMinutes;
        this.currentMoodNote = currentMoodNote;
        this.obsessionNote = obsessionNote;
        this.lastReadAt = lastReadAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Integer getPagesRead() {
        return pagesRead;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getProgressPercentage() {
        return progressPercentage;
    }

    public Integer getReadingTimeMinutes() {
        return readingTimeMinutes;
    }

    public String getCurrentMoodNote() {
        return currentMoodNote;
    }

    public String getObsessionNote() {
        return obsessionNote;
    }

    public LocalDateTime getLastReadAt() {
        return lastReadAt;
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

    public void setBook(Book book) {
        this.book = book;
    }

    public void setPagesRead(Integer pagesRead) {
        this.pagesRead = pagesRead;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void setProgressPercentage(Integer progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public void setReadingTimeMinutes(Integer readingTimeMinutes) {
        this.readingTimeMinutes = readingTimeMinutes;
    }

    public void setCurrentMoodNote(String currentMoodNote) {
        this.currentMoodNote = currentMoodNote;
    }

    public void setObsessionNote(String obsessionNote) {
        this.obsessionNote = obsessionNote;
    }

    public void setLastReadAt(LocalDateTime lastReadAt) {
        this.lastReadAt = lastReadAt;
    }
}