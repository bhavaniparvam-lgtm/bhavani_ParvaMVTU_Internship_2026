package com.tsukuyomi.shiori.service;

import com.tsukuyomi.shiori.dto.CreativeEntryRequestDto;
import com.tsukuyomi.shiori.dto.CreativeEntryResponseDto;
import com.tsukuyomi.shiori.entity.Book;
import com.tsukuyomi.shiori.entity.CreativeEntry;
import com.tsukuyomi.shiori.exception.BookNotFoundException;
import com.tsukuyomi.shiori.exception.CreativeEntryNotFoundException;
import com.tsukuyomi.shiori.repository.BookRepository;
import com.tsukuyomi.shiori.repository.CreativeEntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CreativeEntryService {

    private final CreativeEntryRepository creativeEntryRepository;
    private final BookRepository bookRepository;

    public CreativeEntryService(CreativeEntryRepository creativeEntryRepository, BookRepository bookRepository) {
        this.creativeEntryRepository = creativeEntryRepository;
        this.bookRepository = bookRepository;
    }

    public CreativeEntryResponseDto createCreativeEntry(CreativeEntryRequestDto requestDto) {
        CreativeEntry creativeEntry = new CreativeEntry();
        applyCreativeEntryRequestToEntity(creativeEntry, requestDto);

        CreativeEntry savedCreativeEntry = creativeEntryRepository.save(creativeEntry);
        return mapToResponseDto(savedCreativeEntry);
    }

    public List<CreativeEntryResponseDto> getAllCreativeEntries() {
        return creativeEntryRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    public CreativeEntryResponseDto getCreativeEntryById(Long id) {
        CreativeEntry creativeEntry = creativeEntryRepository.findById(id)
                .orElseThrow(() -> new CreativeEntryNotFoundException("Creative entry not found with id: " + id));

        return mapToResponseDto(creativeEntry);
    }

    public CreativeEntryResponseDto updateCreativeEntry(Long id, CreativeEntryRequestDto requestDto) {
        CreativeEntry existingCreativeEntry = creativeEntryRepository.findById(id)
                .orElseThrow(() -> new CreativeEntryNotFoundException("Creative entry not found with id: " + id));

        applyCreativeEntryRequestToEntity(existingCreativeEntry, requestDto);

        CreativeEntry updatedCreativeEntry = creativeEntryRepository.save(existingCreativeEntry);
        return mapToResponseDto(updatedCreativeEntry);
    }

    public void deleteCreativeEntry(Long id) {
        CreativeEntry existingCreativeEntry = creativeEntryRepository.findById(id)
                .orElseThrow(() -> new CreativeEntryNotFoundException("Creative entry not found with id: " + id));

        creativeEntryRepository.delete(existingCreativeEntry);
    }

    private void applyCreativeEntryRequestToEntity(CreativeEntry creativeEntry, CreativeEntryRequestDto requestDto) {
        creativeEntry.setEntryText(requestDto.getEntryText());
        creativeEntry.setEntryType(requestDto.getEntryType());

        if (requestDto.getBookId() != null) {
            Book book = bookRepository.findById(requestDto.getBookId())
                    .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + requestDto.getBookId()));
            creativeEntry.setBook(book);
        } else {
            creativeEntry.setBook(null);
        }
    }

    private CreativeEntryResponseDto mapToResponseDto(CreativeEntry creativeEntry) {
        Long bookId = creativeEntry.getBook() != null ? creativeEntry.getBook().getId() : null;
        String bookTitle = creativeEntry.getBook() != null ? creativeEntry.getBook().getTitle() : null;

        return new CreativeEntryResponseDto(
                creativeEntry.getId(),
                creativeEntry.getEntryText(),
                creativeEntry.getEntryType(),
                bookId,
                bookTitle,
                creativeEntry.getCreatedAt(),
                creativeEntry.getUpdatedAt()
        );
    }
}