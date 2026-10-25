package dev.aneesh.workshop.output;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plan")
public class StudyPlan {
    private final ChatClient chatClient;

    public StudyPlan(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    @GetMapping("/structured")
    public Itinerary planning(){
        return chatClient.prompt().user("I am thinking to study class 12th chemistry").call().entity(Itinerary.class);
    }
}
