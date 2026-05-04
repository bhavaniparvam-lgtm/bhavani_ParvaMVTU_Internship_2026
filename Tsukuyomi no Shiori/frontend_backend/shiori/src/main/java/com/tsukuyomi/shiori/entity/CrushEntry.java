package com.tsukuyomi.shiori.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "crush_entries")
public class CrushEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "character_name", nullable = false, length = 150)
    private String characterName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "trope", length = 150)
    private String trope;

    @Column(name = "red_flag_green_flag_note", columnDefinition = "TEXT")
    private String redFlagGreenFlagNote;

    @Column(name = "favourite_quote", columnDefinition = "TEXT")
    private String favouriteQuote;

    @Column(name = "reason_for_liking_character", columnDefinition = "TEXT")
    private String reasonForLikingCharacter;

    @Column(name = "why_im_down_bad_note", columnDefinition = "TEXT")
    private String whyImDownBadNote;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CrushEntry() {
    }

    public CrushEntry(Long id, String characterName, Book book, String imageUrl, String trope,
                      String redFlagGreenFlagNote, String favouriteQuote,
                      String reasonForLikingCharacter, String whyImDownBadNote,
                      LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.characterName = characterName;
        this.book = book;
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

    public Book getBook() {
        return book;
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

    public void setBook(Book book) {
        this.book = book;
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