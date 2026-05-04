package com.tsukuyomi.shiori.repository;

import com.tsukuyomi.shiori.entity.CurrentRead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrentReadRepository extends JpaRepository<CurrentRead, Long> {
    Optional<CurrentRead> findByBookId(Long bookId);
    boolean existsByBookId(Long bookId);
}