package com.tsukuyomi.shiori.service;

import com.tsukuyomi.shiori.config.OpenAiProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class OpenAiPromptService implements AiPromptService {

    private final RestClient restClient;
    private final OpenAiProperties openAiProperties;

    public OpenAiPromptService(RestClient restClient, OpenAiProperties openAiProperties) {
        this.restClient = restClient;
        this.openAiProperties = openAiProperties;
    }

    @Override
    public String generateDailySanctuaryPrompt(String displayName) {
        String safeName = (displayName == null || displayName.isBlank()) ? "love" : displayName;

        Map<String, Object> requestBody = Map.of(
                "model", openAiProperties.getModel(),
                "messages", List.of(
                        Map.of(
                                "role", "system",
                                "content", """
                                        You are writing for Tsukuyomi no Shiori, a private single-user emotional book journal.
                                        Write like a soft, caring, slightly flirty boyfriend welcoming the user into her reading sanctuary.
                                        Keep it intimate, poetic, comforting, and emotionally intelligent.
                                        Make it feel like a welcome back message for today's login.
                                        Keep it under 70 words.
                                        Do not use emojis.
                                        Do not sound corporate, robotic, or generic.
                                        """
                        ),
                        Map.of(
                                "role", "user",
                                "content", "Write today's sanctuary welcome for " + safeName + "."
                        )
                ),
                "temperature", 0.9
        );

        OpenAiChatResponse response = restClient.post()
                .uri(openAiProperties.getChatUrl())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + openAiProperties.getApiKey())
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestBody)
                .retrieve()
                .body(OpenAiChatResponse.class);

        if (response == null
                || response.getChoices() == null
                || response.getChoices().isEmpty()
                || response.getChoices().get(0).getMessage() == null
                || response.getChoices().get(0).getMessage().getContent() == null
                || response.getChoices().get(0).getMessage().getContent().isBlank()) {
            throw new IllegalStateException("AI response was empty");
        }

        return response.getChoices().get(0).getMessage().getContent().trim();
    }

    public static class OpenAiChatResponse {
        private List<Choice> choices;

        public List<Choice> getChoices() {
            return choices;
        }

        public void setChoices(List<Choice> choices) {
            this.choices = choices;
        }
    }

    public static class Choice {
        private Message message;

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }
    }

    public static class Message {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}