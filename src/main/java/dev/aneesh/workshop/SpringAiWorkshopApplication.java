package dev.aneesh.workshop;

import org.springframework.ai.chat.client.ChatClient;

import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiWorkshopApplication.class, args);

	}
//@Bean
//	public ChatClient googlegenaiChatClient(GoogleGenAiChatModel chatModel){
//		return ChatClient.create(chatModel);
//}
//@Bean
//public ChatClient deepSeekChatClient(DeepSeekChatModel chatModel){
//		return ChatClient.create(chatModel);

}
