package com.tsukuyomi.shiori.service;

import com.tsukuyomi.shiori.dto.MoodTagResponseDto;
import com.tsukuyomi.shiori.repository.MoodTagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoodTagService {

    private final MoodTagRepository moodTagRepository;

    public MoodTagService(MoodTagRepository moodTagRepository) {
        this.moodTagRepository = moodTagRepository;
    }

    public List<MoodTagResponseDto> getAllMoodTags() {
        return moodTagRepository.findAll()
                .stream()
                .map(moodTag -> new MoodTagResponseDto(
                        moodTag.getId(),
                        moodTag.getName()
                ))
                .toList();
    }
}