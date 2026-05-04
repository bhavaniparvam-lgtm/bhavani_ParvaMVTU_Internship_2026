package com.tsukuyomi.shiori.service;

import com.tsukuyomi.shiori.dto.AuthRequest;
import com.tsukuyomi.shiori.dto.AuthResponse;
import com.tsukuyomi.shiori.dto.LoginStepResponse;
import com.tsukuyomi.shiori.dto.RegisterRequest;
import com.tsukuyomi.shiori.dto.SecretAnswerVerificationRequest;
import com.tsukuyomi.shiori.entity.User;
import com.tsukuyomi.shiori.enums.UserRole;
import com.tsukuyomi.shiori.repository.UserRepository;
import com.tsukuyomi.shiori.security.JwtService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User();
        user.setDisplayName(request.getDisplayName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setSecretQuestion(request.getSecretQuestion());
        user.setSecretAnswer(passwordEncoder.encode(request.getSecretAnswer()));
        user.setRole(UserRole.USER);
        user.setLastActiveAt(LocalDateTime.now());
        user.setLastReminderEmailSentAt(null);

        User savedUser = userRepository.save(user);

        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(savedUser.getEmail())
                .password(savedUser.getPassword())
                .authorities(Collections.emptyList())
                .build();

        String token = jwtService.generateToken(userDetails);

        return new AuthResponse(
                token,
                "Bearer",
                savedUser.getId(),
                savedUser.getDisplayName(),
                savedUser.getEmail()
        );
    }

    public LoginStepResponse login(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Invalid login credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid login credentials");
        }

        return new LoginStepResponse(
                user.getId(),
                user.getDisplayName(),
                user.getEmail(),
                user.getSecretQuestion(),
                true
        );
    }

    public AuthResponse verifySecretAnswer(SecretAnswerVerificationRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Invalid secret answer"));

        if (!passwordEncoder.matches(request.getSecretAnswer(), user.getSecretAnswer())) {
            throw new BadCredentialsException("Invalid secret answer");
        }

        user.setLastActiveAt(LocalDateTime.now());
        user.setLastReminderEmailSentAt(null);
        userRepository.save(user);

        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(Collections.emptyList())
                .build();

        String token = jwtService.generateToken(userDetails);

        return new AuthResponse(
                token,
                "Bearer",
                user.getId(),
                user.getDisplayName(),
                user.getEmail()
        );
    }
}