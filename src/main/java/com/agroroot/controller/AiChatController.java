package com.agroroot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import com.agroroot.service.AiService;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "http://localhost:5173")
public class AiChatController {

    @Autowired
    private AiService aiService;

    @PostMapping("/chat")
    public String chat(@RequestBody Map<String,String> request){

        String message = request.get("message");

        return aiService.askAI(message);
    }
}