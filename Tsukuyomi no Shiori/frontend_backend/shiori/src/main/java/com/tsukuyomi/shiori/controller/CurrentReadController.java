package com.tsukuyomi.shiori.controller;

import com.tsukuyomi.shiori.dto.CurrentReadRequest;
import com.tsukuyomi.shiori.dto.CurrentReadResponse;
import com.tsukuyomi.shiori.service.CurrentReadService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/current-read")
public class CurrentReadController {

    private final CurrentReadService currentReadService;

    public CurrentReadController(CurrentReadService currentReadService) {
        this.currentReadService = currentReadService;
    }

    @GetMapping
    public CurrentReadResponse getCurrentRead() {
        return currentReadService.getCurrentRead();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CurrentReadResponse saveOrUpdateCurrentRead(@Valid @RequestBody CurrentReadRequest request) {
        return currentReadService.saveOrUpdateCurrentRead(request);
    }
}