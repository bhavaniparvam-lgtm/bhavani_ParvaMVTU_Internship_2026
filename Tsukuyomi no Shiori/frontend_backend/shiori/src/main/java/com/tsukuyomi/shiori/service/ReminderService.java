package com.tsukuyomi.shiori.service;

import com.tsukuyomi.shiori.dto.ReminderRequestDto;
import com.tsukuyomi.shiori.dto.ReminderResponseDto;
import com.tsukuyomi.shiori.entity.Reminder;
import com.tsukuyomi.shiori.repository.ReminderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReminderService {

    private final ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    public ReminderResponseDto createReminder(ReminderRequestDto requestDto) {
        Reminder reminder = new Reminder();
        reminder.setTitle(requestDto.getTitle());
        reminder.setReminderDateTime(requestDto.getReminderDateTime());
        reminder.setNote(requestDto.getNote());

        Reminder savedReminder = reminderRepository.save(reminder);
        return mapToResponseDto(savedReminder);
    }

    public List<ReminderResponseDto> getAllReminders() {
        return reminderRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    private ReminderResponseDto mapToResponseDto(Reminder reminder) {
        return new ReminderResponseDto(
                reminder.getId(),
                reminder.getTitle(),
                reminder.getReminderDateTime(),
                reminder.getNote()
        );
    }
}