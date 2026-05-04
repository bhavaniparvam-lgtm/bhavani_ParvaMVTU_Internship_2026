package com.tsukuyomi.shiori.entity;

import com.tsukuyomi.shiori.enums.BookStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 150)
    private String author;

    @Column(name = "cover_image_url", length = 500)
    private String coverImageUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "moon_rating")
    private Integer moonRating;

    @Column(name = "total_pages")
    private Integer totalPages;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private BookStatus status;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "best_liner", columnDefinition = "TEXT")
    private String bestLiner;

    @Column(name = "favourite_chapter", length = 150)
    private String favouriteChapter;

    @Column(name = "spiciest_chapter", length = 150)
    private String spiciestChapter;

    @Column(name = "one_line_reaction", length = 300)
    private String oneLineReaction;

    @Column(name = "emotional_reaction_notes", columnDefinition = "TEXT")
    private String emotionalReactionNotes;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookMood> bookMoods = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Book() {
    }

    public Book(Long id, String title, String author, String coverImageUrl, String description,
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
        this.bookMoods = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<BookMood> getBookMoods() {
        return bookMoods;
    }

    public void setBookMoods(List<BookMood> bookMoods) {
        this.bookMoods = bookMoods;
    }

    public void addBookMood(BookMood bookMood) {
        this.bookMoods.add(bookMood);
        bookMood.setBook(this);
    }

    public void removeBookMood(BookMood bookMood) {
        this.bookMoods.remove(bookMood);
        bookMood.setBook(null);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
