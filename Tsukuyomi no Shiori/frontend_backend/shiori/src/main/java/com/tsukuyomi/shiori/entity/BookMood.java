package com.tsukuyomi.shiori.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "bookmoods",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"book_id", "mood_tag_id"})
        }
)
public class BookMood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(optional = false)
    @JoinColumn(name = "mood_tag_id", nullable = false)
    private MoodTag moodTag;

    @Column(nullable = false)
    private Integer intensity;

    @Column(length = 500)
    private String note;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public BookMood() {
    }

    public BookMood(Long id, Book book, MoodTag moodTag, Integer intensity, String note, LocalDateTime createdAt) {
        this.id = id;
        this.book = book;
        this.moodTag = moodTag;
        this.intensity = intensity;
        this.note = note;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        if (this.intensity == null) {
            this.intensity = 3;
        }
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public MoodTag getMoodTag() {
        return moodTag;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public String getNote() {
        return note;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setMoodTag(MoodTag moodTag) {
        this.moodTag = moodTag;
    }

    public void setIntensity(Integer intensity) {
        this.intensity = intensity;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
