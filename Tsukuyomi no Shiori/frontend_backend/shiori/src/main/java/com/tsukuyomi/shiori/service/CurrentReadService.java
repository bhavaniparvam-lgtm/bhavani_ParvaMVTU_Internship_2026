package com.tsukuyomi.shiori.service;

import com.tsukuyomi.shiori.dto.CurrentReadRequest;
import com.tsukuyomi.shiori.dto.CurrentReadResponse;
import com.tsukuyomi.shiori.entity.Book;
import com.tsukuyomi.shiori.entity.CurrentRead;
import com.tsukuyomi.shiori.exception.BookNotFoundException;
import com.tsukuyomi.shiori.repository.BookRepository;
import com.tsukuyomi.shiori.repository.CurrentReadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class CurrentReadService {

    private final CurrentReadRepository currentReadRepository;
    private final BookRepository bookRepository;

    public CurrentReadService(CurrentReadRepository currentReadRepository, BookRepository bookRepository) {
        this.currentReadRepository = currentReadRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public CurrentReadResponse getCurrentRead() {
        CurrentRead currentRead = currentReadRepository.findAll()
                .stream()
                .findFirst()
                .orElse(null);

        if (currentRead == null) {
            return null;
        }

        return mapToResponse(currentRead);
    }

    @Transactional
    public CurrentReadResponse saveOrUpdateCurrentRead(CurrentReadRequest request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + request.getBookId()));

        CurrentRead currentRead = currentReadRepository.findByBookId(request.getBookId())
                .orElseGet(CurrentRead::new);

        currentRead.setBook(book);
        currentRead.setPagesRead(request.getPagesRead());
        currentRead.setTotalPages(request.getTotalPages());
        currentRead.setReadingTimeMinutes(request.getReadingTimeMinutes());
        currentRead.setCurrentMoodNote(request.getCurrentMoodNote());
        currentRead.setObsessionNote(request.getObsessionNote());
        currentRead.setLastReadAt(LocalDateTime.now());

        if (request.getPagesRead() != null && request.getTotalPages() != null && request.getTotalPages() > 0) {
            int progress = (int) Math.round((request.getPagesRead() * 100.0) / request.getTotalPages());
            currentRead.setProgressPercentage(Math.min(progress, 100));
        }

        CurrentRead saved = currentReadRepository.save(currentRead);
        return mapToResponse(saved);
    }

    private CurrentReadResponse mapToResponse(CurrentRead currentRead) {
        return new CurrentReadResponse(
                currentRead.getId(),
                currentRead.getBook().getId(),
                currentRead.getBook().getTitle(),
                currentRead.getBook().getAuthor(),
                currentRead.getPagesRead(),
                currentRead.getTotalPages(),
                currentRead.getProgressPercentage(),
                currentRead.getReadingTimeMinutes(),
                currentRead.getCurrentMoodNote(),
                currentRead.getObsessionNote(),
                currentRead.getLastReadAt(),
                currentRead.getCreatedAt(),
                currentRead.getUpdatedAt()
        );
    }
}