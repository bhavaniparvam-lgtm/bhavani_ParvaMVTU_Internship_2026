package com.tsukuyomi.shiori.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "photo_gallery")
public class PhotoGallery extends BaseEntity {

    private String imageUrl;

    private String caption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    public PhotoGallery() {
    }

    public PhotoGallery(String imageUrl, String caption, Book book) {
        this.imageUrl = imageUrl;
        this.caption = caption;
        this.book = book;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCaption() {
        return caption;
    }

    public Book getBook() {
        return book;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}