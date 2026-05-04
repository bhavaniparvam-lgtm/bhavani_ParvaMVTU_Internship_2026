package com.tsukuyomi.shiori.repository;

import com.tsukuyomi.shiori.entity.MoodTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoodTagRepository extends JpaRepository<MoodTag, Long> {
    Optional<MoodTag> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
}