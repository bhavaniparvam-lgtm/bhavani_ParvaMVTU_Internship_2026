package com.tsukuyomi.shiori.repository;

import com.tsukuyomi.shiori.entity.ReadingSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReadingSessionRepository extends JpaRepository<ReadingSession, Long> {

    List<ReadingSession> findByBook_IdOrderBySessionDateDescCreatedAtDesc(Long bookId);

    Optional<ReadingSession> findTopByBook_IdOrderBySessionDateDescCreatedAtDesc(Long bookId);
}