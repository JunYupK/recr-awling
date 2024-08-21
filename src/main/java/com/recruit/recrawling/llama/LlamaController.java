package com.recruit.recrawling.llama;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.bedrock.llama.BedrockLlamaChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LlamaController {
    //private final ChatClient chatClient;
    private final BedrockLlamaChatModel chatModel;

    @Autowired
    public LlamaController(BedrockLlamaChatModel chatModel){
        //this.chatClient = chatClientBuilder.build();
        this.chatModel = chatModel;
    }


    @GetMapping("/generate")
    public String generateText(@RequestBody String prompt) {
//        return this.chatClient.prompt()
//                .user(prompt)
//                .call()
//                .content();
        return "";
    }
}
