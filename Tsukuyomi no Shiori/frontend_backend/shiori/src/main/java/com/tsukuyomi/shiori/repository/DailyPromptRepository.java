package com.tsukuyomi.shiori.repository;

import com.tsukuyomi.shiori.entity.DailyPrompt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DailyPromptRepository extends JpaRepository<DailyPrompt, Long> {
    Optional<DailyPrompt> findByPromptDate(LocalDate promptDate);
}