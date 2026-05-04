package com.example.librarymanagement.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import com.example.librarymanagement.dto.UserProfileRequestDto;
import com.example.librarymanagement.entity.UserProfile;
import com.example.librarymanagement.service.UserProfileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public UserProfile createUserProfile(@Valid @RequestBody UserProfileRequestDto userProfileRequestDto) {
        return userProfileService.createUserProfile(userProfileRequestDto);
    }

    @GetMapping
    public List<UserProfile> getAllUserProfiles() {
        return userProfileService.getAllUserProfiles();
    }

    @GetMapping("/{userId}")
    public UserProfile getUserProfileById(@PathVariable Long userId) {
        return userProfileService.getUserProfileById(userId);
    }

    @PutMapping("/{userId}")
    public UserProfile updateUserProfile(@PathVariable Long userId,
            @Valid @RequestBody UserProfileRequestDto userProfileRequestDto) {
        return userProfileService.updateUserProfile(userId, userProfileRequestDto);
    }

    @DeleteMapping("/{userId}")
    public String deleteUserProfile(@PathVariable Long userId) {
        userProfileService.deleteUserProfile(userId);
        return "User profile deleted successfully";
    }
}