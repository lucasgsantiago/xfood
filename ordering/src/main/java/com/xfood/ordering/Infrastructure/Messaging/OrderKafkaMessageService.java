package com.xfood.ordering.Infrastructure.Messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfood.ordering.Application.ReadModels.Results.OrderResult;
import com.xfood.ordering.Application.Services.IOrderMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderKafkaMessageService implements IOrderMessageService {

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private static final String TOPIC = "xfood-order-created";

    @Override
    public void sendOrderCreated(OrderResult order) {

        String message = convertToJson(order);
        kafkaTemplate.send(TOPIC, message);

    }

    private String convertToJson(OrderResult order) {
        try {
            return objectMapper.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
