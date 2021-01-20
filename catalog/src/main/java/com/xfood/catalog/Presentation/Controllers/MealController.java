package com.xfood.catalog.Presentation.Controllers;

import com.xfood.catalog.Application.Commands.CreateMealCommand;
import com.xfood.catalog.Application.ReadModels.Results.MealResult;
import com.xfood.catalog.Application.Services.IMealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/meals")
@RequiredArgsConstructor
public class MealController {

    private final IMealService mealService;

    @GetMapping
    public List<MealResult> getMeals(){
        return this.mealService.getMeals();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> createMeal(@RequestBody CreateMealCommand command){
        this.mealService.createMeal(command);
        return ResponseEntity.ok().body(command.id);
    }

    @GetMapping("{id}")
    public MealResult getMeal(@PathVariable String id){
        return this.mealService.getMeal(id);
    }
}
