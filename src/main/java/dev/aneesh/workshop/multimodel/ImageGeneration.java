//package dev.aneesh.workshop.multimodel;
//
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.ai.google.genai.image.GoogleGenAiImageModel;
//import org.springframework.ai.google.genai.image.GoogleGenAiImageOptions;
//import org.springframework.ai.image.ImageOptions;
//import org.springframework.ai.image.ImagePrompt;
//import org.springframework.ai.image.ImageResponse;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//public class ImageGeneration {
//    private final ChatClient chatClient;
//private final GoogleGenAiImageModel imageModel;
//    public ImageGeneration(ChatClient.Builder builder, GoogleGenAiImageModel imageModel) {
//        this.chatClient = builder.build();
//        this.imageModel = imageModel;
//    }
//    @GetMapping("/generate")
//    public ResponseEntity<Map<String, Object>> generateimage(@RequestParam(defaultValue = "A Beautiful sunset over mountains")String prompt){
//        ImageOptions options=GoogleGenAiImageOptions.builder().model("gemini-3.1-flash-lite-image").build();
//        ImagePrompt prompt1=new ImagePrompt(prompt,options);
//        ImageResponse response=imageModel.call(prompt1);
//        String url=response.getResult().getOutput().getUrl();
//        return ResponseEntity.ok(Map.of("prompt",prompt1,
//                "imageurl",url));
//    }
//}
//
