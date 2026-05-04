package com.tsukuyomi.shiori.exception;

public class BookDeletionNotAllowedException extends RuntimeException {

    public BookDeletionNotAllowedException(String message) {
        super(message);
    }
}