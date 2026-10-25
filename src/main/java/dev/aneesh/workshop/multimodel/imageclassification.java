package dev.aneesh.workshop.multimodel;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.Resource;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class imageclassification {
    private final ChatClient chatClient;
    @Value("classpath:/images/photo.png")
    Resource sampleimage;
    public imageclassification(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    @GetMapping("/image-to-text")
    public String imageToText(){
        return chatClient.prompt().user(u->{
            u.text("Can you please describe what you see in the image");
            u.media(MimeTypeUtils.IMAGE_PNG,sampleimage);
        }).call().content();
    }
}
