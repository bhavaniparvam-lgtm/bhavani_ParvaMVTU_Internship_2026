package com.example.librarymanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librarymanagement.dto.BookRequestDto;
import com.example.librarymanagement.entity.Author;
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.exception.ResourceNotFoundException;
import com.example.librarymanagement.repository.AuthorRepository;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book createBook(BookRequestDto bookRequestDto) {
        Author author = authorRepository.findById(bookRequestDto.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Author not found with id: " + bookRequestDto.getAuthorId()));

        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setGenre(bookRequestDto.getGenre());
        book.setPrice(bookRequestDto.getPrice());
        book.setPages(bookRequestDto.getPages());
        book.setPublishedDate(bookRequestDto.getPublishedDate());
        book.setAvailable(bookRequestDto.getAvailable());
        book.setDescription(bookRequestDto.getDescription());
        book.setAuthor(author);

        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));
    }

    @Override
    public Book updateBook(Long bookId, BookRequestDto bookRequestDto) {
        Book existingBook = getBookById(bookId);

        Author author = authorRepository.findById(bookRequestDto.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Author not found with id: " + bookRequestDto.getAuthorId()));

        existingBook.setTitle(bookRequestDto.getTitle());
        existingBook.setGenre(bookRequestDto.getGenre());
        existingBook.setPrice(bookRequestDto.getPrice());
        existingBook.setPages(bookRequestDto.getPages());
        existingBook.setPublishedDate(bookRequestDto.getPublishedDate());
        existingBook.setAvailable(bookRequestDto.getAvailable());
        existingBook.setDescription(bookRequestDto.getDescription());
        existingBook.setAuthor(author);

        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long bookId) {
        Book existingBook = getBookById(bookId);
        bookRepository.delete(existingBook);
    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenreIgnoreCase(genre);
    }

    @Override
    public List<Book> getBooksByAvailability(Boolean available) {
        return bookRepository.findByAvailable(available);
    }

    @Override
    public List<Book> getBooksByAuthorId(Long authorId) {
        return bookRepository.findByAuthorAuthorId(authorId);
    }
}