package com.agroroot.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AiService {

    // ✅ Apni real Groq API key yaha daalo
    private final String API_KEY = "GROQ_API-KEY";

    public String askAI(String message) {

        if (message == null || message.trim().isEmpty()) {
            return "Please enter a valid agriculture-related question.";
        }

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.groq.com/openai/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String safeMessage = message.replace("\"", "\\\"").replace("\n", " ");

        String body = """
        {
          "model": "llama-3.1-8b-instant",
          "messages": [
            {
              "role": "system",
              "content": "You are AgroRoot AI, an agriculture expert assistant for Indian farmers. Give practical, simple, and useful farming advice."
            },
            {
              "role": "user",
              "content": "%s"
            }
          ],
          "temperature": 0.7,
          "max_tokens": 500
        }
        """.formatted(safeMessage);

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response =
                    restTemplate.postForEntity(url, request, String.class);

            String responseBody = response.getBody();

            if (responseBody == null || responseBody.isEmpty()) {
                return "AI service returned an empty response.";
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseBody);

            JsonNode choices = root.path("choices");

            if (!choices.isArray() || choices.isEmpty()) {
                return "AI service could not generate a valid response right now.";
            }

            String aiReply = choices
                    .get(0)
                    .path("message")
                    .path("content")
                    .asText();

            if (aiReply == null || aiReply.trim().isEmpty()) {
                return "AI service returned no meaningful answer.";
            }

            return aiReply.trim();

        } catch (HttpClientErrorException e) {
            return "Groq API Error: " + e.getResponseBodyAsString();
        } catch (Exception e) {
            return "AI service failed: " + e.getMessage();
        }
    }
}