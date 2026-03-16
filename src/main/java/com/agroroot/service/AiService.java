package com.agroroot.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AiService {

    private final String API_KEY = "YOUR_GROQ_API_KEY";

    public String askAI(String message) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.groq.com/openai/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String body = """
        {
          "model": "llama3-8b-8192",
          "messages": [
            {
              "role": "system",
              "content": "You are an agriculture expert helping farmers."
            },
            {
              "role": "user",
              "content": "%s"
            }
          ]
        }
        """.formatted(message);

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(url, request, String.class);

        try {

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());

            return root
                    .path("choices")
                    .get(0)
                    .path("message")
                    .path("content")
                    .asText();

        } catch (Exception e) {
            return "AI response error";
        }
    }
}