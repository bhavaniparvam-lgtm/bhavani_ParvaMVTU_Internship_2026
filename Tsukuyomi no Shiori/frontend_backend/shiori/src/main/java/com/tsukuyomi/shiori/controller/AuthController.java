package com.tsukuyomi.shiori.controller;

import com.tsukuyomi.shiori.dto.AuthRequest;
import com.tsukuyomi.shiori.dto.AuthResponse;
import com.tsukuyomi.shiori.dto.LoginStepResponse;
import com.tsukuyomi.shiori.dto.RegisterRequest;
import com.tsukuyomi.shiori.dto.SecretAnswerVerificationRequest;
import com.tsukuyomi.shiori.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginStepResponse> login(@Valid @RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/verify-secret-answer")
    public ResponseEntity<AuthResponse> verifySecretAnswer(
            @Valid @RequestBody SecretAnswerVerificationRequest request
    ) {
        return ResponseEntity.ok(authService.verifySecretAnswer(request));
    }
}