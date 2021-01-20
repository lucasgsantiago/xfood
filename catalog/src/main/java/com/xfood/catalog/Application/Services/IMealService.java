package com.xfood.catalog.Application.Services;

import com.xfood.catalog.Application.Commands.CreateMealCommand;
import com.xfood.catalog.Application.Commands.DecrementAmoutOfMeal;
import com.xfood.catalog.Application.ReadModels.Results.MealResult;

import java.util.List;

public interface IMealService {
    void createMeal(CreateMealCommand command);
    MealResult getMeal(String id);
    List<MealResult> getMeals();
    void decrementAmountOfMeal(DecrementAmoutOfMeal command);
}
