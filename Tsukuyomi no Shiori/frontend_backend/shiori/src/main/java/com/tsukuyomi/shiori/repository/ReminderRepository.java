package com.tsukuyomi.shiori.repository;

import com.tsukuyomi.shiori.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
}