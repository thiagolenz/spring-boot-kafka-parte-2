package com.masterdev.consumidor.kafka2.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterdev.consumidor.kafka2.dto.ChatMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChatKafka2Consumer {
    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(
        topics = "${topicos.chat.request.topic}",
        groupId = "chat-consumer-unico"
    )
    public void consume(String message) throws JsonProcessingException {
        System.out.println("KAFKA CONS 2 ==================" + new Date());
        ChatMessageDTO messageDTO = objectMapper.readValue(message, ChatMessageDTO.class);
        String messageTemplate = "DE: %s, PARA: %s \nTÍTULO: %s\nCONTEÚDO: %s";
        System.out.printf(
                messageTemplate,
                messageDTO.getDe(),
                messageDTO.getPara(),
                messageDTO.getTitulo(),
                messageDTO.getConteudo()
            );
        System.out.println("\n==================");
    }
}
