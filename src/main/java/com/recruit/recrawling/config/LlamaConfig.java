package com.recruit.recrawling.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LlamaConfig {

    @Bean
    public ChatClient chatClient(){
        return new ChatClient() {
            @Override
            public ChatClientRequestSpec prompt() {
                return null;
            }

            @Override
            public ChatClientPromptRequestSpec prompt(Prompt prompt) {
                return null;
            }

            @Override
            public Builder mutate() {
                return null;
            }
        };
    }
}
