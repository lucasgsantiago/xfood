package com.xfood.catalog.Application.Commands;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DecrementAmoutOfMeal {
    public String mealId;
    public Integer amount;
}
