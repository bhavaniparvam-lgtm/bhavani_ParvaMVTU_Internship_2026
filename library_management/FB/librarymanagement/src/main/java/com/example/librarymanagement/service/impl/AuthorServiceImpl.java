package com.example.librarymanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librarymanagement.dto.AuthorRequestDto;
import com.example.librarymanagement.entity.Author;
import com.example.librarymanagement.exception.ResourceNotFoundException;
import com.example.librarymanagement.repository.AuthorRepository;
import com.example.librarymanagement.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        author.setEmail(authorRequestDto.getEmail());
        author.setSpecialization(authorRequestDto.getSpecialization());
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
    }

    @Override
    public Author updateAuthor(Long authorId, AuthorRequestDto authorRequestDto) {
        Author existingAuthor = getAuthorById(authorId);
        existingAuthor.setName(authorRequestDto.getName());
        existingAuthor.setEmail(authorRequestDto.getEmail());
        existingAuthor.setSpecialization(authorRequestDto.getSpecialization());
        return authorRepository.save(existingAuthor);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        Author existingAuthor = getAuthorById(authorId);
        authorRepository.delete(existingAuthor);
    }

    @Override
    public List<Author> searchAuthorsByName(String name) {
        return authorRepository.findByNameContainingIgnoreCase(name);
    }
}