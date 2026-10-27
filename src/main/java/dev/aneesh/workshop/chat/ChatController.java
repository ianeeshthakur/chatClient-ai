package dev.aneesh.workshop.chat;

import com.google.genai.Chat;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController

public class ChatController {
    private final ChatClient chatClient;

    public ChatController(ChatClient chatClient) {
        this.chatClient=chatClient;
    }

    @GetMapping("/chat")
    public String message(){
        return chatClient.prompt().user("tell me something interesting about java").call().content();
    }

    @GetMapping("/stream")
    public Flux<String> stream(){   //
        return chatClient.prompt().user("I am visiting Bhakra Soon tell me 5 places to visit there and who is DR.HArdyal Singh Chandel there ").stream().content();
    }
    @GetMapping("/fact")
    public ChatResponse facts(){
        return chatClient.prompt().user("Tell me some facts about bhakra village").call().
                chatResponse();
    }
}
