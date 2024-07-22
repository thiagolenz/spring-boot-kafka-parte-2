package com.masterdev.produtor.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterdev.produtor.kafka.dto.ChatMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatRequestProducer {
    @Value("${topicos.chat.request.topic}")
    private String topicoChatRequest;

    @Value("${topicos.chat.request.topic2}")
    private String topicoChatRequest2;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String sendMessage(ChatMessageDTO chatMessage) throws JsonProcessingException {
        String conteudo = objectMapper.writeValueAsString(chatMessage);
//        kafkaTemplate.send(topicoChatRequest, conteudo);
        kafkaTemplate.send(topicoChatRequest2, conteudo);
        return "Mensagem enviado para processamento";
    }
}
