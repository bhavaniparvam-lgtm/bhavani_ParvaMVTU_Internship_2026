package com.tsukuyomi.shiori.repository;

import com.tsukuyomi.shiori.entity.BookMood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookMoodRepository extends JpaRepository<BookMood, Long> {

    List<BookMood> findByBook_IdOrderByCreatedAtDesc(Long bookId);

    Optional<BookMood> findByBook_IdAndMoodTag_Id(Long bookId, Long moodTagId);

    void deleteByBookId(Long bookId);
}