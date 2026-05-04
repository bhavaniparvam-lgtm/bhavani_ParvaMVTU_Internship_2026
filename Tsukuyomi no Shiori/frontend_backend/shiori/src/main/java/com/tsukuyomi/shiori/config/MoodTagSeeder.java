package com.tsukuyomi.shiori.config;

import com.tsukuyomi.shiori.entity.MoodTag;
import com.tsukuyomi.shiori.repository.MoodTagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MoodTagSeeder implements CommandLineRunner {

    private final MoodTagRepository moodTagRepository;

    public MoodTagSeeder(MoodTagRepository moodTagRepository) {
        this.moodTagRepository = moodTagRepository;
    }

    @Override
    public void run(String... args) {
        List<String> defaultMoodTags = List.of(
                "Tender",
                "Devastated",
                "Haunted",
                "Comforting",
                "Obsessed",
                "Feral",
                "Soft",
                "Heartbroken",
                "Melancholic",
                "Euphoric"
        );

        for (String moodName : defaultMoodTags) {
            if (!moodTagRepository.existsByNameIgnoreCase(moodName)) {
                MoodTag moodTag = new MoodTag();
                moodTag.setName(moodName);
                moodTagRepository.save(moodTag);
            }
        }
    }
}