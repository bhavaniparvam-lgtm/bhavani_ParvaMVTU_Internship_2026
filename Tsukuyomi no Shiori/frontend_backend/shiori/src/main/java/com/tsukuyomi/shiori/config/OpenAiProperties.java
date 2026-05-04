package com.tsukuyomi.shiori.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ai.openai")
public class OpenAiProperties {

    private String apiKey;
    private String chatUrl;
    private String model;

    public String getApiKey() {
        return apiKey;
    }

    public String getChatUrl() {
        return chatUrl;
    }

    public String getModel() {
        return model;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setChatUrl(String chatUrl) {
        this.chatUrl = chatUrl;
    }

    public void setModel(String model) {
        this.model = model;
    }
}