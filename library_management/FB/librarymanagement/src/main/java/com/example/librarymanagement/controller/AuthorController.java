package com.example.librarymanagement.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import com.example.librarymanagement.dto.AuthorRequestDto;
import com.example.librarymanagement.entity.Author;
import com.example.librarymanagement.service.AuthorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/authors")
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public Author createAuthor(@Valid @RequestBody AuthorRequestDto authorRequestDto) {
        return authorService.createAuthor(authorRequestDto);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable Long authorId) {
        return authorService.getAuthorById(authorId);
    }

    @PutMapping("/{authorId}")
    public Author updateAuthor(@PathVariable Long authorId, @Valid @RequestBody AuthorRequestDto authorRequestDto) {
        return authorService.updateAuthor(authorId, authorRequestDto);
    }

    @DeleteMapping("/{authorId}")
    public String deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
        return "Author deleted successfully";
    }

    @GetMapping("/search")
    public List<Author> searchAuthorsByName(@RequestParam String name) {
        return authorService.searchAuthorsByName(name);
    }
}