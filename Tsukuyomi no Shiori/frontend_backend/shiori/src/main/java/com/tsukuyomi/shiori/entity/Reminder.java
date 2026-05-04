package com.tsukuyomi.shiori.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "reminder")
public class Reminder extends BaseEntity {

    private String title;

    private LocalDateTime reminderDateTime;

    private String note;

    public Reminder() {
    }

    public Reminder(String title, LocalDateTime reminderDateTime, String note) {
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