package com.tsukuyomi.shiori.service;

import com.tsukuyomi.shiori.dto.CurrentVoyageResponse;
import com.tsukuyomi.shiori.entity.Book;
import com.tsukuyomi.shiori.entity.ReadingSession;
import com.tsukuyomi.shiori.enums.BookStatus;
import com.tsukuyomi.shiori.repository.BookRepository;
import com.tsukuyomi.shiori.repository.ReadingSessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CurrentVoyageService {

    private final BookRepository bookRepository;
    private final ReadingSessionRepository readingSessionRepository;

    public CurrentVoyageService(BookRepository bookRepository, ReadingSessionRepository readingSessionRepository) {
        this.bookRepository = bookRepository;
        this.readingSessionRepository = readingSessionRepository;
    }

    @Transactional(readOnly = true)
    public CurrentVoyageResponse getCurrentVoyage() {
    	Optional<Book> currentBookOpt = bookRepository.findFirstByStatus(BookStatus.READING);

        if (currentBookOpt.isEmpty()) {
            return null;
        }

        Book currentBook = currentBookOpt.get();
        Optional<ReadingSession> latestSessionOpt = readingSessionRepository
                .findTopByBook_IdOrderBySessionDateDescCreatedAtDesc(currentBook.getId());
        ReadingSession latestSession = latestSessionOpt.orElse(null);

        Integer pagesRead = latestSession != null ? latestSession.getPagesRead() : null;
        Integer readingTimeMinutes = latestSession != null ? latestSession.getTimeSpentMinutes() : null;
        String latestSessionNote = latestSession != null ? latestSession.getSessionNote() : null;
        LocalDate latestReadingDate = latestSession != null ? latestSession.getSessionDate() : null;
        LocalDateTime latestSessionCreatedAt = latestSession != null ? latestSession.getCreatedAt() : null;

        Integer progressPercentage = null;
        if (pagesRead != null && currentBook.getTotalPages() != null && currentBook.getTotalPages() > 0) {
            int progress = (int) Math.round((pagesRead * 100.0) / currentBook.getTotalPages());
            progressPercentage = Math.min(progress, 100);
        }

        return new CurrentVoyageResponse(
                currentBook.getId(),
                currentBook.getTitle(),
                currentBook.getAuthor(),
                currentBook.getCoverImageUrl(),
                currentBook.getStatus().name(),
                currentBook.getTotalPages(),
                pagesRead,
                progressPercentage,
                readingTimeMinutes,
                currentBook.getNotes(),
                latestSessionNote,
                latestReadingDate,
                latestSessionCreatedAt
        );
    }
}