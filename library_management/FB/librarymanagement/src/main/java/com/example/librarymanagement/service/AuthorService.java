package com.example.librarymanagement.service;

import java.util.List;

import com.example.librarymanagement.dto.AuthorRequestDto;
import com.example.librarymanagement.entity.Author;

public interface AuthorService {

    Author createAuthor(AuthorRequestDto authorRequestDto);

    List<Author> getAllAuthors();

    Author getAuthorById(Long authorId);

    Author updateAuthor(Long authorId, AuthorRequestDto authorRequestDto);

    void deleteAuthor(Long authorId);

    List<Author> searchAuthorsByName(String name);
}