package dev.aneesh.workshop.prompt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acad")
public class AcademicController {
    private final ChatClient chatClient;

    public AcademicController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
}
@GetMapping("/chat")
public String chat(@RequestParam String message){
    var systemInstructions = """
You are a customer service assistant for AcmeBank.
You can ONLY discuss:   
PNG
+ 2
Account balances and transactions   
PNG
Branch locations and hours   
PNG
General banking services   
PNG
If asked about anything else, respond: "I can only help with banking-related questions."
""";
        return chatClient.prompt().user(message).system(systemInstructions).call().content();
}
}
