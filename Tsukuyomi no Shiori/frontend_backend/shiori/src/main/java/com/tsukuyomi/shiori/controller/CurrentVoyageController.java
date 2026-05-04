package com.tsukuyomi.shiori.controller;

import com.tsukuyomi.shiori.dto.CurrentVoyageResponse;
import com.tsukuyomi.shiori.service.CurrentVoyageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/current-voyage")
public class CurrentVoyageController {

    private final CurrentVoyageService currentVoyageService;

    public CurrentVoyageController(CurrentVoyageService currentVoyageService) {
        this.currentVoyageService = currentVoyageService;
    }

    @GetMapping
    public CurrentVoyageResponse getCurrentVoyage() {
        return currentVoyageService.getCurrentVoyage();
    }
}