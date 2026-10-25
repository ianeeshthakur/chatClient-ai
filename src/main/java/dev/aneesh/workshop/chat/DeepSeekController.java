//package dev.aneesh.workshop.chat;
//
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class DeepSeekController {
//    private final ChatClient chatClient;
//
//    public DeepSeekController(@Qualifier("deepSeekChatClient") ChatClient chatClient) {
//        this.chatClient = chatClient;
//    }
//    @GetMapping("/deepchat")
//    public String message(){
//        return chatClient.prompt().user("tell me something interesting about java").call().content();
//    }
//}
