package com.example.librarymanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librarymanagement.dto.UserProfileRequestDto;
import com.example.librarymanagement.entity.UserProfile;
import com.example.librarymanagement.exception.ResourceNotFoundException;
import com.example.librarymanagement.repository.UserProfileRepository;
import com.example.librarymanagement.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserProfile createUserProfile(UserProfileRequestDto userProfileRequestDto) {
        UserProfile userProfile = new UserProfile();
        userProfile.setFullName(userProfileRequestDto.getFullName());
        userProfile.setEmail(userProfileRequestDto.getEmail());
        userProfile.setPassword(userProfileRequestDto.getPassword());
        userProfile.setGender(userProfileRequestDto.getGender());
        userProfile.setInterests(userProfileRequestDto.getInterests());
        userProfile.setRole(userProfileRequestDto.getRole());
        userProfile.setMembershipDate(userProfileRequestDto.getMembershipDate());
        userProfile.setLoginTime(userProfileRequestDto.getLoginTime());
        userProfile.setAge(userProfileRequestDto.getAge());
        userProfile.setProfileFileName(userProfileRequestDto.getProfileFileName());

        return userProfileRepository.save(userProfile);
    }

    @Override
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile getUserProfileById(Long userId) {
        return userProfileRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User profile not found with id: " + userId));
    }

    @Override
    public UserProfile updateUserProfile(Long userId, UserProfileRequestDto userProfileRequestDto) {
        UserProfile existingUserProfile = getUserProfileById(userId);

        existingUserProfile.setFullName(userProfileRequestDto.getFullName());
        existingUserProfile.setEmail(userProfileRequestDto.getEmail());
        existingUserProfile.setPassword(userProfileRequestDto.getPassword());
        existingUserProfile.setGender(userProfileRequestDto.getGender());
        existingUserProfile.setInterests(userProfileRequestDto.getInterests());
        existingUserProfile.setRole(userProfileRequestDto.getRole());
        existingUserProfile.setMembershipDate(userProfileRequestDto.getMembershipDate());
        existingUserProfile.setLoginTime(userProfileRequestDto.getLoginTime());
        existingUserProfile.setAge(userProfileRequestDto.getAge());
        existingUserProfile.setProfileFileName(userProfileRequestDto.getProfileFileName());

        return userProfileRepository.save(existingUserProfile);
    }

    @Override
    public void deleteUserProfile(Long userId) {
        UserProfile existingUserProfile = getUserProfileById(userId);
        userProfileRepository.delete(existingUserProfile);
    }
}