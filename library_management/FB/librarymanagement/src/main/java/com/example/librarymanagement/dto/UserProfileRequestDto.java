package com.example.librarymanagement.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class UserProfileRequestDto {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @Email(message = "Enter a valid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotNull(message = "Interests are required")
    private List<String> interests;

    @NotBlank(message = "Role is required")
    private String role;

    @NotNull(message = "Membership date is required")
    private LocalDate membershipDate;

    @NotNull(message = "Login time is required")
    private LocalDateTime loginTime;

    @NotNull(message = "Age is required")
    @Positive(message = "Age must be greater than 0")
    private Integer age;

    private String profileFileName;

    public UserProfileRequestDto() {
    }

    public UserProfileRequestDto(String fullName, String email, String password, String gender, List<String> interests,
            String role, LocalDate membershipDate, LocalDateTime loginTime, Integer age, String profileFileName) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.interests = interests;
        this.role = role;
        this.membershipDate = membershipDate;
        this.loginTime = loginTime;
        this.age = age;
        this.profileFileName = profileFileName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProfileFileName() {
        return profileFileName;
    }

    public void setProfileFileName(String profileFileName) {
        this.profileFileName = profileFileName;
    }
}