package com.tsukuyomi.shiori.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class SecretAnswerVerificationRequest {

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Secret answer is required")
    private String secretAnswer;

    public SecretAnswerVerificationRequest() {
    }

    public SecretAnswerVerificationRequest(String email, String secretAnswer) {
        this.email = email;
        this.secretAnswer = secretAnswer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }
}