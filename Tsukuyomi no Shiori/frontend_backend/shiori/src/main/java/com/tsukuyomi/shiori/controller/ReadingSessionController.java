package com.tsukuyomi.shiori.controller;

import com.tsukuyomi.shiori.dto.ReadingSessionRequest;
import com.tsukuyomi.shiori.dto.ReadingSessionResponse;
import com.tsukuyomi.shiori.service.ReadingSessionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reading-sessions")
public class ReadingSessionController {

    private final ReadingSessionService readingSessionService;

    public ReadingSessionController(ReadingSessionService readingSessionService) {
        this.readingSessionService = readingSessionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReadingSessionResponse createReadingSession(@Valid @RequestBody ReadingSessionRequest request) {
        return readingSessionService.createReadingSession(request);
    }

    @GetMapping("/book/{bookId}")
    public List<ReadingSessionResponse> getReadingSessionsByBookId(@PathVariable Long bookId) {
        return readingSessionService.getReadingSessionsByBookId(bookId);
    }
}