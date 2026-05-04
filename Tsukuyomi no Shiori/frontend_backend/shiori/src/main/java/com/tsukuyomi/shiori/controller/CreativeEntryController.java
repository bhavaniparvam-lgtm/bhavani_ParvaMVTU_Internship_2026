package com.tsukuyomi.shiori.controller;

import com.tsukuyomi.shiori.dto.CreativeEntryRequestDto;
import com.tsukuyomi.shiori.dto.CreativeEntryResponseDto;
import com.tsukuyomi.shiori.service.CreativeEntryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creative-entries")
public class CreativeEntryController {

    private final CreativeEntryService creativeEntryService;

    public CreativeEntryController(CreativeEntryService creativeEntryService) {
        this.creativeEntryService = creativeEntryService;
    }

    @PostMapping
    public ResponseEntity<CreativeEntryResponseDto> createCreativeEntry(
            @Valid @RequestBody CreativeEntryRequestDto requestDto) {
        CreativeEntryResponseDto createdCreativeEntry = creativeEntryService.createCreativeEntry(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCreativeEntry);
    }

    @GetMapping
    public ResponseEntity<List<CreativeEntryResponseDto>> getAllCreativeEntries() {
        return ResponseEntity.ok(creativeEntryService.getAllCreativeEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreativeEntryResponseDto> getCreativeEntryById(@PathVariable Long id) {
        return ResponseEntity.ok(creativeEntryService.getCreativeEntryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreativeEntryResponseDto> updateCreativeEntry(
            @PathVariable Long id,
            @Valid @RequestBody CreativeEntryRequestDto requestDto) {
        CreativeEntryResponseDto updatedCreativeEntry = creativeEntryService.updateCreativeEntry(id, requestDto);
        return ResponseEntity.ok(updatedCreativeEntry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreativeEntry(@PathVariable Long id) {
        creativeEntryService.deleteCreativeEntry(id);
        return ResponseEntity.noContent().build();
    }
}