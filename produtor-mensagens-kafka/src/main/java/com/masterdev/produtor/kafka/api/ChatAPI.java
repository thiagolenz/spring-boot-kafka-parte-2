package com.masterdev.produtor.kafka.api;


import com.masterdev.produtor.kafka.dto.ChatMessageDTO;
import com.masterdev.produtor.kafka.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatAPI {
    @Autowired private ChatService chatService;

    @PostMapping
    public String pagar (@RequestBody ChatMessageDTO pagamento) {
        return chatService.integrarPagamento(pagamento);
    }
}
