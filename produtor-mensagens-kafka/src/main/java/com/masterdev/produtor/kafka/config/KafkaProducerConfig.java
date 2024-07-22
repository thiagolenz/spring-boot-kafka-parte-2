package com.masterdev.produtor.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    @Autowired
    private KafkaProperties kafkaProperties;

    @Value("${topicos.chat.request.topic}")
    private String chatRequestTopic;

    @Value("${topicos.chat.request.topic2}")
    private String chatRequestTopic2;

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> properties = kafkaProperties.buildProducerProperties();
        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public NewTopic chatRequestTopicBuilder() {
        return TopicBuilder
            .name(chatRequestTopic)
            .partitions(1)
            .replicas(1)
            .build();
    }

    @Bean
    public NewTopic chatRequestTopic2Builder() {
        return TopicBuilder
            .name(chatRequestTopic2)
            .partitions(2)
            .replicas(1)
            .build();
    }




















}
