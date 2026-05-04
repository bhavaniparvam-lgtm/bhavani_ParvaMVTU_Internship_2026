package com.tsukuyomi.shiori.controller;

import com.tsukuyomi.shiori.dto.ReminderRequestDto;
import com.tsukuyomi.shiori.dto.ReminderResponseDto;
import com.tsukuyomi.shiori.service.ReminderEmailScheduler;
import com.tsukuyomi.shiori.service.ReminderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    private final ReminderService reminderService;
    private final ReminderEmailScheduler reminderEmailScheduler;

    public ReminderController(ReminderService reminderService,
                              ReminderEmailScheduler reminderEmailScheduler) {
        this.reminderService = reminderService;
        this.reminderEmailScheduler = reminderEmailScheduler;
    }

    @PostMapping
    public ResponseEntity<ReminderResponseDto> createReminder(
            @Valid @RequestBody ReminderRequestDto requestDto) {
        ReminderResponseDto createdReminder = reminderService.createReminder(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReminder);
    }

    @GetMapping
    public ResponseEntity<List<ReminderResponseDto>> getAllReminders() {
        return ResponseEntity.ok(reminderService.getAllReminders());
    }

    @PostMapping("/trigger-inactivity-email")
    public ResponseEntity<String> triggerInactivityEmail() {
        reminderEmailScheduler.processInactivityReminderEmails();
        return ResponseEntity.ok("Inactivity reminder email process triggered successfully.");
    }
}