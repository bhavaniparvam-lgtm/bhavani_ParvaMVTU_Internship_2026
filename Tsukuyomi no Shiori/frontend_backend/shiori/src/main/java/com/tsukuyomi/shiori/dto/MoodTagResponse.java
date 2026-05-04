package com.tsukuyomi.shiori.dto;

public class MoodTagResponse {

    private Long id;
    private String name;
    private String displayName;
    private String colorCode;
    private String description;

    public MoodTagResponse() {
    }

    public MoodTagResponse(Long id, String name, String displayName, String colorCode, String description) {
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.colorCode = colorCode;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getColorCode() {
        return colorCode;
    }

    public String getDescription() {
        return description;
    }
}