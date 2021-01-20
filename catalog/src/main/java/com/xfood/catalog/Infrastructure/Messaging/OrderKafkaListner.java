package com.xfood.catalog.Infrastructure.Messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfood.catalog.Application.Commands.DecrementAmoutOfMeal;
import com.xfood.catalog.Application.Listener.IOrderMessageListner;
import com.xfood.catalog.Application.Services.IMealService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderKafkaListner implements IOrderMessageListner {
    private static final String GROUP_ID = "catalog";
    private static final String TOPIC = "xfood-order-created";

    private final ObjectMapper objectMapper;
    private final IMealService mealService;

    @Override
    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void getMessage(final String message){
        final DecrementAmoutOfMeal command = convertMessage(message);
        System.out.println(command.toString());
        mealService.decrementAmountOfMeal(command);
    }

    private DecrementAmoutOfMeal convertMessage(String message) {
        try {
            return objectMapper.readValue(message,DecrementAmoutOfMeal.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
