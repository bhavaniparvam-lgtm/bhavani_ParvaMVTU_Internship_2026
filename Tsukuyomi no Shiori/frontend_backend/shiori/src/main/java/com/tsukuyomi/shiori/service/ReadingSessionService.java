package com.tsukuyomi.shiori.service;

import com.tsukuyomi.shiori.dto.ReadingSessionRequest;
import com.tsukuyomi.shiori.dto.ReadingSessionResponse;
import com.tsukuyomi.shiori.entity.Book;
import com.tsukuyomi.shiori.entity.ReadingSession;
import com.tsukuyomi.shiori.exception.BookNotFoundException;
import com.tsukuyomi.shiori.repository.BookRepository;
import com.tsukuyomi.shiori.repository.ReadingSessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReadingSessionService {

    private final ReadingSessionRepository readingSessionRepository;
    private final BookRepository bookRepository;

    public ReadingSessionService(ReadingSessionRepository readingSessionRepository,
                                 BookRepository bookRepository) {
        this.readingSessionRepository = readingSessionRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public ReadingSessionResponse createReadingSession(ReadingSessionRequest request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + request.getBookId()));

        ReadingSession readingSession = new ReadingSession();
        readingSession.setBook(book);
        readingSession.setSessionDate(request.getSessionDate());
        readingSession.setPagesRead(request.getPagesRead());
        readingSession.setTimeSpentMinutes(request.getTimeSpentMinutes());
        readingSession.setSessionNote(request.getSessionNote());

        ReadingSession saved = readingSessionRepository.save(readingSession);
        return mapToResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<ReadingSessionResponse> getReadingSessionsByBookId(Long bookId) {
        if (!bookRepository.existsById(bookId)) {
            throw new BookNotFoundException("Book not found with id: " + bookId);
        }

        return readingSessionRepository.findByBook_IdOrderBySessionDateDescCreatedAtDesc(bookId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ReadingSessionResponse mapToResponse(ReadingSession session) {
        return new ReadingSessionResponse(
                session.getId(),
                session.getBook().getId(),
                session.getBook().getTitle(),
                session.getSessionDate(),
                session.getPagesRead(),
                session.getTimeSpentMinutes(),
                session.getSessionNote(),
                session.getCreatedAt(),
                session.getUpdatedAt()
        );
    }
}