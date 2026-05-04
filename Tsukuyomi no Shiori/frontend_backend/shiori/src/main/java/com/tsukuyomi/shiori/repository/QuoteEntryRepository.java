package com.tsukuyomi.shiori.repository;

import com.tsukuyomi.shiori.entity.QuoteEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteEntryRepository extends JpaRepository<QuoteEntry, Long> {
}