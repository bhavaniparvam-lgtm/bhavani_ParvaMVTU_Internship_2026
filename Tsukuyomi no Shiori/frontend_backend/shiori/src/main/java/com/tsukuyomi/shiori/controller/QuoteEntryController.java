package com.tsukuyomi.shiori.controller;

import com.tsukuyomi.shiori.dto.QuoteEntryRequestDto;
import com.tsukuyomi.shiori.dto.QuoteEntryResponseDto;
import com.tsukuyomi.shiori.service.QuoteEntryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteEntryController {

    private final QuoteEntryService quoteEntryService;

    public QuoteEntryController(QuoteEntryService quoteEntryService) {
        this.quoteEntryService = quoteEntryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuoteEntryResponseDto createQuoteEntry(@Valid @RequestBody QuoteEntryRequestDto requestDto) {
        return quoteEntryService.createQuoteEntry(requestDto);
    }

    @GetMapping("/{id}")
    public QuoteEntryResponseDto getQuoteEntryById(@PathVariable Long id) {
        return quoteEntryService.getQuoteEntryById(id);
    }

    @GetMapping
    public List<QuoteEntryResponseDto> getAllQuoteEntries() {
        return quoteEntryService.getAllQuoteEntries();
    }

    @PutMapping("/{id}")
    public QuoteEntryResponseDto updateQuoteEntry(@PathVariable Long id,
                                                  @Valid @RequestBody QuoteEntryRequestDto requestDto) {
        return quoteEntryService.updateQuoteEntry(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuoteEntry(@PathVariable Long id) {
        quoteEntryService.deleteQuoteEntry(id);
    }
}