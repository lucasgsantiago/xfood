package com.xfood.catalog.Application.Services;

import com.xfood.catalog.Application.Commands.CreateMealCommand;
import com.xfood.catalog.Application.Commands.DecrementAmoutOfMeal;
import com.xfood.catalog.Application.ReadModels.Results.MealResult;
import com.xfood.catalog.Domain.Exceptions.BusinessException;
import com.xfood.catalog.Domain.Exceptions.MealNotFoundException;
import com.xfood.catalog.Domain.IMealRespository;
import com.xfood.catalog.Domain.Meal;
import com.xfood.catalog.Infrastructure.Mappers.MealMapper;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService implements IMealService{

    private final IMealRespository respository;
    private MealMapper mapper = MealMapper.INSTANCE;

    @Override
    public void createMeal(CreateMealCommand command) {
        this.respository.save(mapper.toDomain(command));
    }

    @Override
    public MealResult getMeal(String id) {
        return null;
    }

    @Override
    public List<MealResult> getMeals() {
        return mapper.toResult(this.respository.getAll());
    }

    @Override
    public void decrementAmountOfMeal(DecrementAmoutOfMeal command){
        try {
            Meal meal = this.checkIfMealExist(command.mealId);
            meal.decrementAmount(command.amount);
            this.respository.save(meal);
        } catch (MealNotFoundException | BusinessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Meal checkIfMealExist(String id) throws MealNotFoundException {
        if(StringHelper.isNullOrEmptyString(id)) throw new IllegalArgumentException("Identificador inválido:" + id);
        return respository.getById(id).orElseThrow(() -> new MealNotFoundException(id));
    }
}
