package com.example.librarymanagement.service;

import java.util.List;

import com.example.librarymanagement.dto.BookRequestDto;
import com.example.librarymanagement.entity.Book;

public interface BookService {

    Book createBook(BookRequestDto bookRequestDto);

    List<Book> getAllBooks();

    Book getBookById(Long bookId);

    Book updateBook(Long bookId, BookRequestDto bookRequestDto);

    void deleteBook(Long bookId);

    List<Book> searchBooksByTitle(String title);

    List<Book> getBooksByGenre(String genre);

    List<Book> getBooksByAvailability(Boolean available);

    List<Book> getBooksByAuthorId(Long authorId);
}