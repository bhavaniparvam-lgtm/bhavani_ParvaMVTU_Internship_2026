package com.tsukuyomi.shiori.dto;

import java.time.LocalDateTime;

public class ReminderResponseDto {

    private Long id;
    private String title;
    private LocalDateTime reminderDateTime;
    private String note;

    public ReminderResponseDto() {
    }

    public ReminderResponseDto(Long id, String title, LocalDateTime reminderDateTime, String note) {
        this.id = id;
        this.title = title;
        this.reminderDateTime = reminderDateTime;
        this.note = note;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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