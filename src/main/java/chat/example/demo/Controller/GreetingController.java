package chat.example.demo.Controller;

import chat.example.demo.domain.ChatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GreetingController {

    private final SimpMessagingTemplate template;

    @MessageMapping("/chatroom/{id}") // 실제론 메세지 매핑으로 pub/chatroom/{id} 임
    public void sendMessage(@DestinationVariable("id") Long id, ChatDto chatDTO) {
        System.out.println(chatDTO);
        // /sub/chatroom/{id}로 메세지 보냄
        template.convertAndSend("/sub/chatroom/" + chatDTO.getRoomId(), chatDTO);
    }
}
