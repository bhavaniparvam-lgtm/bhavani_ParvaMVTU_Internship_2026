package com.tsukuyomi.shiori.controller;

import com.tsukuyomi.shiori.dto.MoodTagResponseDto;
import com.tsukuyomi.shiori.service.MoodTagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mood-tags")
public class MoodTagController {

    private final MoodTagService moodTagService;

    public MoodTagController(MoodTagService moodTagService) {
        this.moodTagService = moodTagService;
    }

    @GetMapping
    public List<MoodTagResponseDto> getAllMoodTags() {
        return moodTagService.getAllMoodTags();
    }
}