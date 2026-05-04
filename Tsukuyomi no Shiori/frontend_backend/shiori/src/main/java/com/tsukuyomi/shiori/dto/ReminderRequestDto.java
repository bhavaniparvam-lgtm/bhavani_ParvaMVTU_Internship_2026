package com.tsukuyomi.shiori.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ReminderRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Reminder date time is required")
    private LocalDateTime reminderDateTime;

    private String note;

    public ReminderRequestDto() {
    }

    public ReminderRequestDto(String title, LocalDateTime reminderDateTime, String note) {
        this.title = title;
        this.reminderDateTime = reminderDateTime;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getReminderDateTime() {
        return reminderDateTime;
    }

    public String getNote() {
        return note;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReminderDateTime(LocalDateTime reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }

    public void setNote(String note) {
        this.note = note;
    }
}