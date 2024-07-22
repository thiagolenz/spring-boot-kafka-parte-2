package com.masterdev.produtor.kafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.masterdev.produtor.kafka.dto.ChatMessageDTO;
import com.masterdev.produtor.kafka.producer.ChatRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired private ChatRequestProducer chatRequestProducer;

    public String integrarPagamento (ChatMessageDTO chatMessage) {
        try {
            return chatRequestProducer.sendMessage(chatMessage);
        } catch (JsonProcessingException e) {
            return "Houve um erro ao solicitar pagamento "+ e.getMessage();
        }
    }
}
