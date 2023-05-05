package com.example.ecrf.controller;

import com.example.ecrf.service.impl.ChatServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    private final Demo demo;
    private final ChatServiceImpl chatService;

    @GetMapping("/chat-text")
    public String chat(@RequestParam(name = "search", required = false) String search) throws InterruptedException {
        chatService.write(search);

        return chatService.read();
    }
}
