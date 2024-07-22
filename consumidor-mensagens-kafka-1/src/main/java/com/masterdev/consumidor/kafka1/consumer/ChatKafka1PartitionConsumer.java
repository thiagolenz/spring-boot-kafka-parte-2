package com.masterdev.consumidor.kafka1.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ChatKafka1PartitionConsumer {
    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOG = LoggerFactory
        .getLogger(ChatKafka1PartitionConsumer.class);

    @KafkaListener(
        topics = "${topicos.chat.request.topic2}",
        groupId = "chat-consumer-1",
        concurrency = "2"
    )
    public void consume(ConsumerRecord<?, String> consumerRecord) {
        System.out.println("\n");
        LOG.info("particao = " + consumerRecord.partition());
        LOG.info(consumerRecord.value());
    }
}
