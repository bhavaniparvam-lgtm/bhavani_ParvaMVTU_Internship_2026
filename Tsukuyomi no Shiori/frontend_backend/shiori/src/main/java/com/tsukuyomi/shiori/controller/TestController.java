package com.tsukuyomi.shiori.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/secure")
    public Map<String, Object> secureEndpoint() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "The moonlit gate opened successfully.");
        response.put("status", "authenticated");
        response.put("module", "Authentication Protected Route Test");
        return response;
    }
}