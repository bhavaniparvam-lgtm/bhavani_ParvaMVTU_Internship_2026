package com.tsukuyomi.shiori.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${app.mail.from}")
    private String fromEmail;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendReminderEmail(String toEmail, String title, String note) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject("A gentle reminder from Tsukuyomi no Shiori");

        String body = buildReminderBody(title, note);
        message.setText(body);

        mailSender.send(message);
    }

    private String buildReminderBody(String title, String note) {
        StringBuilder body = new StringBuilder();
        body.append("Hello love,\n\n");
        body.append("You have been away from Tsukuyomi no Shiori for a little while, so here is a quiet reminder waiting for you.\n\n");
        body.append("Reminder: ").append(title).append("\n");

        if (note != null && !note.isBlank()) {
            body.append("Note: ").append(note).append("\n");
        }

        body.append("\nCome back when your heart is ready.\n");
        body.append("Tsukuyomi no Shiori");
        return body.toString();
    }
}