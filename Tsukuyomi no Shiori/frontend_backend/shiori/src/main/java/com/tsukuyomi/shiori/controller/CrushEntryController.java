package com.tsukuyomi.shiori.controller;

import com.tsukuyomi.shiori.dto.CrushEntryRequestDto;
import com.tsukuyomi.shiori.dto.CrushEntryResponseDto;
import com.tsukuyomi.shiori.service.CrushEntryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crush-entries")
public class CrushEntryController {

    private final CrushEntryService crushEntryService;

    public CrushEntryController(CrushEntryService crushEntryService) {
        this.crushEntryService = crushEntryService;
    }

    @PostMapping
    public ResponseEntity<CrushEntryResponseDto> createCrushEntry(@Valid @RequestBody CrushEntryRequestDto requestDto) {
        CrushEntryResponseDto createdCrushEntry = crushEntryService.createCrushEntry(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCrushEntry);
    }

    @GetMapping
    public ResponseEntity<List<CrushEntryResponseDto>> getAllCrushEntries() {
        return ResponseEntity.ok(crushEntryService.getAllCrushEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrushEntryResponseDto> getCrushEntryById(@PathVariable Long id) {
        return ResponseEntity.ok(crushEntryService.getCrushEntryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CrushEntryResponseDto> updateCrushEntry(@PathVariable Long id,
                                                                  @Valid @RequestBody CrushEntryRequestDto requestDto) {
        CrushEntryResponseDto updatedCrushEntry = crushEntryService.updateCrushEntry(id, requestDto);
        return ResponseEntity.ok(updatedCrushEntry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrushEntry(@PathVariable Long id) {
        crushEntryService.deleteCrushEntry(id);
        return ResponseEntity.noContent().build();
    }
}