package com.tsukuyomi.shiori.service;

import com.tsukuyomi.shiori.dto.CrushEntryRequestDto;
import com.tsukuyomi.shiori.dto.CrushEntryResponseDto;
import com.tsukuyomi.shiori.entity.Book;
import com.tsukuyomi.shiori.entity.CrushEntry;
import com.tsukuyomi.shiori.exception.BookNotFoundException;
import com.tsukuyomi.shiori.exception.CrushEntryNotFoundException;
import com.tsukuyomi.shiori.repository.BookRepository;
import com.tsukuyomi.shiori.repository.CrushEntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CrushEntryService {

    private final CrushEntryRepository crushEntryRepository;
    private final BookRepository bookRepository;

    public CrushEntryService(CrushEntryRepository crushEntryRepository, BookRepository bookRepository) {
        this.crushEntryRepository = crushEntryRepository;
        this.bookRepository = bookRepository;
    }

    public CrushEntryResponseDto createCrushEntry(CrushEntryRequestDto requestDto) {
        CrushEntry crushEntry = new CrushEntry();
        applyCrushEntryRequestToEntity(crushEntry, requestDto);

        CrushEntry savedCrushEntry = crushEntryRepository.save(crushEntry);
        return mapToResponseDto(savedCrushEntry);
    }

    public List<CrushEntryResponseDto> getAllCrushEntries() {
        return crushEntryRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    public CrushEntryResponseDto getCrushEntryById(Long id) {
        CrushEntry crushEntry = crushEntryRepository.findById(id)
                .orElseThrow(() -> new CrushEntryNotFoundException("Crush entry not found with id: " + id));

        return mapToResponseDto(crushEntry);
    }

    public CrushEntryResponseDto updateCrushEntry(Long id, CrushEntryRequestDto requestDto) {
        CrushEntry existingCrushEntry = crushEntryRepository.findById(id)
                .orElseThrow(() -> new CrushEntryNotFoundException("Crush entry not found with id: " + id));

        applyCrushEntryRequestToEntity(existingCrushEntry, requestDto);

        CrushEntry updatedCrushEntry = crushEntryRepository.save(existingCrushEntry);
        return mapToResponseDto(updatedCrushEntry);
    }

    public void deleteCrushEntry(Long id) {
        CrushEntry existingCrushEntry = crushEntryRepository.findById(id)
                .orElseThrow(() -> new CrushEntryNotFoundException("Crush entry not found with id: " + id));

        crushEntryRepository.delete(existingCrushEntry);
    }

    private void applyCrushEntryRequestToEntity(CrushEntry crushEntry, CrushEntryRequestDto requestDto) {
        crushEntry.setCharacterName(requestDto.getCharacterName());
        crushEntry.setImageUrl(requestDto.getImageUrl());
        crushEntry.setTrope(requestDto.getTrope());
        crushEntry.setRedFlagGreenFlagNote(requestDto.getRedFlagGreenFlagNote());
        crushEntry.setFavouriteQuote(requestDto.getFavouriteQuote());
        crushEntry.setReasonForLikingCharacter(requestDto.getReasonForLikingCharacter());
        crushEntry.setWhyImDownBadNote(requestDto.getWhyImDownBadNote());

        if (requestDto.getBookId() != null) {
            Book book = bookRepository.findById(requestDto.getBookId())
                    .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + requestDto.getBookId()));
            crushEntry.setBook(book);
        } else {
            crushEntry.setBook(null);
        }
    }

    private CrushEntryResponseDto mapToResponseDto(CrushEntry crushEntry) {
        Long bookId = crushEntry.getBook() != null ? crushEntry.getBook().getId() : null;
        String bookTitle = crushEntry.getBook() != null ? crushEntry.getBook().getTitle() : null;

        return new CrushEntryResponseDto(
                crushEntry.getId(),
                crushEntry.getCharacterName(),
                bookId,
                bookTitle,
                crushEntry.getImageUrl(),
                crushEntry.getTrope(),
                crushEntry.getRedFlagGreenFlagNote(),
                crushEntry.getFavouriteQuote(),
                crushEntry.getReasonForLikingCharacter(),
                crushEntry.getWhyImDownBadNote(),
                crushEntry.getCreatedAt(),
                crushEntry.getUpdatedAt()
        );
    }
}