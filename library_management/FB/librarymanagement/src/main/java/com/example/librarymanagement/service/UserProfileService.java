package com.example.librarymanagement.service;

import java.util.List;

import com.example.librarymanagement.dto.UserProfileRequestDto;
import com.example.librarymanagement.entity.UserProfile;

public interface UserProfileService {

    UserProfile createUserProfile(UserProfileRequestDto userProfileRequestDto);

    List<UserProfile> getAllUserProfiles();

    UserProfile getUserProfileById(Long userId);

    UserProfile updateUserProfile(Long userId, UserProfileRequestDto userProfileRequestDto);

    void deleteUserProfile(Long userId);
}