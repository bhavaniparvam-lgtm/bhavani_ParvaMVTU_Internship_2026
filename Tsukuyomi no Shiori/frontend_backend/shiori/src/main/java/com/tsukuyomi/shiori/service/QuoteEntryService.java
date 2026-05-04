package com.tsukuyomi.shiori.service;

import com.tsukuyomi.shiori.dto.QuoteEntryRequestDto;
import com.tsukuyomi.shiori.dto.QuoteEntryResponseDto;
import com.tsukuyomi.shiori.entity.QuoteEntry;
import com.tsukuyomi.shiori.exception.QuoteEntryNotFoundException;
import com.tsukuyomi.shiori.repository.QuoteEntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class QuoteEntryService {

    private final QuoteEntryRepository quoteEntryRepository;

    public QuoteEntryService(QuoteEntryRepository quoteEntryRepository) {
        this.quoteEntryRepository = quoteEntryRepository;
    }

    public QuoteEntryResponseDto createQuoteEntry(QuoteEntryRequestDto requestDto) {
        QuoteEntry quoteEntry = new QuoteEntry();
        quoteEntry.setQuoteText(requestDto.getQuoteText());
        quoteEntry.setAuthor(requestDto.getAuthor());
        quoteEntry.setSource(requestDto.getSource());

        QuoteEntry saved = quoteEntryRepository.save(quoteEntry);
        return mapToResponseDto(saved);
    }

    public QuoteEntryResponseDto getQuoteEntryById(Long id) {
        QuoteEntry quoteEntry = quoteEntryRepository.findById(id)
                .orElseThrow(() -> new QuoteEntryNotFoundException("Quote entry not found with id " + id));
        return mapToResponseDto(quoteEntry);
    }

    public List<QuoteEntryResponseDto> getAllQuoteEntries() {
        return quoteEntryRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    public QuoteEntryResponseDto updateQuoteEntry(Long id, QuoteEntryRequestDto requestDto) {
        QuoteEntry quoteEntry = quoteEntryRepository.findById(id)
                .orElseThrow(() -> new QuoteEntryNotFoundException("Quote entry not found with id " + id));

        quoteEntry.setQuoteText(requestDto.getQuoteText());
        quoteEntry.setAuthor(requestDto.getAuthor());
        quoteEntry.setSource(requestDto.getSource());

        QuoteEntry updated = quoteEntryRepository.save(quoteEntry);
        return mapToResponseDto(updated);
    }

    public void deleteQuoteEntry(Long id) {
        QuoteEntry quoteEntry = quoteEntryRepository.findById(id)
                .orElseThrow(() -> new QuoteEntryNotFoundException("Quote entry not found with id " + id));
        quoteEntryRepository.delete(quoteEntry);
    }

    private QuoteEntryResponseDto mapToResponseDto(QuoteEntry quoteEntry) {
        return new QuoteEntryResponseDto(
                quoteEntry.getId(),
                quoteEntry.getQuoteText(),
                quoteEntry.getAuthor(),
                quoteEntry.getSource(),
                quoteEntry.getCreatedAt(),
                quoteEntry.getUpdatedAt()
        );
    }
}