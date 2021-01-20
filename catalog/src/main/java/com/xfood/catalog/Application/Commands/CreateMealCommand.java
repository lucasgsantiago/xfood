package com.xfood.catalog.Application.Commands;

import java.math.BigDecimal;
import java.util.UUID;

public class CreateMealCommand {
    public String id = UUID.randomUUID().toString();
    public String title;
    public String description;
    public BigDecimal price;
    public Integer preparationTime;
    public Integer amount;
}
