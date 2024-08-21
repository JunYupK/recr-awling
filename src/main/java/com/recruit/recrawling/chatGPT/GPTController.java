package com.recruit.recrawling.chatGPT;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RequestMapping("/ai")
@RestController
@Slf4j
public class GPTController {
    //private final OpenAiChatModel openAiChatModel;
//    private final VertexAiGeminiChatModel vertexAiGeminiChatModel;
//
//    public GPTController(OpenAiChatModel openAiChatModel, VertexAiGeminiChatModel vertexAiGeminiChatModel) {
//        this.openAiChatModel = openAiChatModel;
//        this.vertexAiGeminiChatModel = vertexAiGeminiChatModel;
//    }

//    @GetMapping("/openai")
//    public Map<String, String> openAI(@RequestBody String msg){
//        Map<String, String> response = new HashMap<>();
//        log.info("질의 : " + msg);
//        String openAiResponse = openAiChatModel.call(msg);
//        response.put("openai(chatGPT) 응답", openAiResponse);
//        log.info("chatGPT 답변 : " + openAiResponse);
//        return response;
//    }
//    @GetMapping("/ollama")
//    public void ollamaTest(@RequestBody String msg){
//
//    }
}
