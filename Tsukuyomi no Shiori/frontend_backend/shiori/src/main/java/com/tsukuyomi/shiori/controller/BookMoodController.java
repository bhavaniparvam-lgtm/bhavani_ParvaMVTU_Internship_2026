package com.tsukuyomi.shiori.controller;

import com.tsukuyomi.shiori.dto.BookMoodRequestDto;
import com.tsukuyomi.shiori.dto.BookMoodResponseDto;
import com.tsukuyomi.shiori.service.BookMoodService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books/{bookId}/moods")
public class BookMoodController {

    private final BookMoodService bookMoodService;

    public BookMoodController(BookMoodService bookMoodService) {
        this.bookMoodService = bookMoodService;
    }

    @PostMapping
    public ResponseEntity<List<BookMoodResponseDto>> assignMoodToBook(
            @PathVariable Long bookId,
            @Valid @RequestBody BookMoodRequestDto requestDto) {
        return ResponseEntity.ok(
                bookMoodService.assignMoodToBook(
                        bookId,
                        requestDto.getMoodTagId(),
                        requestDto.getIntensity(),
                        requestDto.getNote()
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<BookMoodResponseDto>> getMoodsByBookId(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookMoodService.getMoodsByBookId(bookId));
    }

    @DeleteMapping
    public ResponseEntity<Void> clearMoodsByBookId(@PathVariable Long bookId) {
        bookMoodService.clearMoodsByBookId(bookId);
        return ResponseEntity.noContent().build();
    }
}