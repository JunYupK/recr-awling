package com.recruit.recrawling.llama;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
public class LlamaController {
    private final OllamaChatModel chatModel;
    private final ChatClient chatClient;


    @Autowired
    LlamaController(OllamaChatModel chatModel, ChatClient chatClient){
        this.chatModel = chatModel;
        this.chatClient = chatClient;
    }


    @GetMapping("/generate")
    public String generateText(@RequestBody String prompt) {
        return "";
    }
}
