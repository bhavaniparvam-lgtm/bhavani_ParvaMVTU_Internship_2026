package com.tsukuyomi.shiori.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reading_sessions")
public class ReadingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "book_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_reading_sessions_book")
    )
    private Book book;

    @Column(name = "session_date", nullable = false)
    private LocalDate sessionDate;

    @Column(name = "pages_read", nullable = false)
    private Integer pagesRead;

    @Column(name = "time_spent_minutes", nullable = false)
    private Integer timeSpentMinutes;

    @Column(name = "session_note", columnDefinition = "TEXT")
    private String sessionNote;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public ReadingSession() {
    }

    public ReadingSession(Long id, Book book, LocalDate sessionDate, Integer pagesRead,
                          Integer timeSpentMinutes, String sessionNote,
                          LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.book = book;
        this.sessionDate = sessionDate;
        this.pagesRead = pagesRead;
        this.timeSpentMinutes = timeSpentMinutes;
        this.sessionNote = sessionNote;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public Integer getPagesRead() {
        return pagesRead;
    }

    public Integer getTimeSpentMinutes() {
        return timeSpentMinutes;
    }

    public String getSessionNote() {
        return sessionNote;
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

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public void setPagesRead(Integer pagesRead) {
        this.pagesRead = pagesRead;
    }

    public void setTimeSpentMinutes(Integer timeSpentMinutes) {
        this.timeSpentMinutes = timeSpentMinutes;
    }

    public void setSessionNote(String sessionNote) {
        this.sessionNote = sessionNote;
    }
}
