package com.tsukuyomi.shiori.repository;

import com.tsukuyomi.shiori.entity.CreativeEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreativeEntryRepository extends JpaRepository<CreativeEntry, Long> {

    boolean existsByBook_Id(Long bookId);
}