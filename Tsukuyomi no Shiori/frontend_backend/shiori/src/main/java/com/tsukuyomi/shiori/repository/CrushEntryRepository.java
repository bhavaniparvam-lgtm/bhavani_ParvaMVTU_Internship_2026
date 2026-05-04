package com.tsukuyomi.shiori.repository;

import com.tsukuyomi.shiori.entity.CrushEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrushEntryRepository extends JpaRepository<CrushEntry, Long> {
}