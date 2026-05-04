package com.tsukuyomi.shiori.repository;

import com.tsukuyomi.shiori.entity.Book;
import com.tsukuyomi.shiori.enums.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByTitleIgnoreCaseAndAuthorIgnoreCase(String title, String author);

    List<Book> findByStatus(BookStatus status);

    Optional<Book> findFirstByStatus(BookStatus status);

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByAuthorContainingIgnoreCase(String author);
}