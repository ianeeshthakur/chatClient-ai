package dev.aneesh.workshop.prompt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleLimitController {
    private final ChatClient chatClient;

    public ArticleLimitController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    @GetMapping("/write")
    public String newPost(@RequestParam(value = "topic",defaultValue = "JDK Virtual Machines") String topic){
        var system = """
Blog Post Generator Guidelines:   
PNG
+ 1
1. Length & Purpose: Generate 500-word blog posts that inform and engage general audiences.[cite: 2]

2. Structure:[cite: 2]
   - Introduction: Hook readers and establish the topic's relevance[cite: 2]
   - Body: Develop 3 main points with supporting evidence and examples[cite: 2]
   - Conclusion: Summarize key takeaways and include a call-to-action[cite: 2]

3. Content Requirements:[cite: 2]
   - Include real-world applications or case studies[cite: 2]
   - Incorporate relevant statistics or data points when appropriate[cite: 2]
   - Explain benefits/implications clearly for non-experts[cite: 2]

4. Tone & Style:[cite: 2]
   - Write in an informative yet conversational voice[cite: 2]
   - Use accessible language while maintaining authority[cite: 2]
   - Break up text with subheadings and short paragraphs[cite: 2]

5. Response Format: Deliver complete, ready-to-publish posts with a suggested title.[cite: 2]
""";
        return chatClient.prompt().user(u->{
            u.text("Write me a blog post about the {topic}");
            u.param("topic",topic);
        }).call().content();
    }
}
