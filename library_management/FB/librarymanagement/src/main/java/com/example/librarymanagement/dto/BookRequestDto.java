package com.example.librarymanagement.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class BookRequestDto {

    @NotBlank(message = "Book title is required")
    private String title;

    @NotBlank(message = "Genre is required")
    private String genre;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price cannot be negative")
    private Double price;

    @NotNull(message = "Pages are required")
    @Positive(message = "Pages must be greater than 0")
    private Integer pages;

    @NotNull(message = "Published date is required")
    private LocalDate publishedDate;

    @NotNull(message = "Availability is required")
    private Boolean available;

    private String description;

    @NotNull(message = "Author ID is required")
    private Long authorId;

    public BookRequestDto() {
    }

    public BookRequestDto(String title, String genre, Double price, Integer pages, LocalDate publishedDate,
            Boolean available, String description, Long authorId) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.pages = pages;
        this.publishedDate = publishedDate;
        this.available = available;
        this.description = description;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}