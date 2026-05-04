package com.example.librarymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librarymanagement.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByGenreIgnoreCase(String genre);

    List<Book> findByAvailable(Boolean available);

    List<Book> findByAuthorAuthorId(Long authorId);
}