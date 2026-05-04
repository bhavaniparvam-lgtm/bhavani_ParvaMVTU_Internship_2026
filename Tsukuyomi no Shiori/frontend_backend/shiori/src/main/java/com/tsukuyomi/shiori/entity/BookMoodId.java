package com.tsukuyomi.shiori.entity;

import java.io.Serializable;
import java.util.Objects;

public class BookMoodId implements Serializable {

    private Long bookId;
    private Long moodTagId;

    public BookMoodId() {}

    public BookMoodId(Long bookId, Long moodTagId) {
        this.bookId = bookId;
        this.moodTagId = moodTagId;
    }

    // Getters and setters
    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }
    
    public Long getMoodTagId() { return moodTagId; }
    public void setMoodTagId(Long moodTagId) { this.moodTagId = moodTagId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookMoodId that = (BookMoodId) o;
        return Objects.equals(bookId, that.bookId) && 
               Objects.equals(moodTagId, that.moodTagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, moodTagId);
    }
}