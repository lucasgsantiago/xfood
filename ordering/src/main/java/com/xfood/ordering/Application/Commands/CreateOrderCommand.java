package com.xfood.ordering.Application.Commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;
@Data
public class CreateOrderCommand {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String id = UUID.randomUUID().toString();

    public String mealId,title;

    public BigDecimal price;

    public Integer amount;
}
