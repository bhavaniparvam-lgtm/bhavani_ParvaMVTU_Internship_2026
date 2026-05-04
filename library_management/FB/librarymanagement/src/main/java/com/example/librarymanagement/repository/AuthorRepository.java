package com.example.librarymanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librarymanagement.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByEmail(String email);

    java.util.List<Author> findByNameContainingIgnoreCase(String name);
}