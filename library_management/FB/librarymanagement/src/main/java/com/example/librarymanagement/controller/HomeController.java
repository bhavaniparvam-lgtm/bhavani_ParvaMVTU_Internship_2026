package com.example.librarymanagement.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, String> home() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Library Management System API is running successfully");
        response.put("port", "8083");
        response.put("authorsApi", "http://localhost:8083/api/authors");
        response.put("booksApi", "http://localhost:8083/api/books");
        response.put("usersApi", "http://localhost:8083/api/users");
        return response;
    }
}