package com.tsukuyomi.shiori.dto;

public class PhotoGalleryRequestDto {

    private String caption;
    private Long bookId;

    public PhotoGalleryRequestDto() {
    }

    public PhotoGalleryRequestDto(String caption, Long bookId) {
        this.caption = caption;
        this.bookId = bookId;
    }

    public String getCaption() {
        return caption;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}