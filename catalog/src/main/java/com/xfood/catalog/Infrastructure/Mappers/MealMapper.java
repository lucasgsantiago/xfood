package com.xfood.catalog.Infrastructure.Mappers;


import com.xfood.catalog.Application.Commands.CreateMealCommand;
import com.xfood.catalog.Application.ReadModels.Results.MealResult;
import com.xfood.catalog.Domain.Meal;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MealMapper {

    MealMapper INSTANCE = Mappers.getMapper(MealMapper.class);

    Meal toDomain(CreateMealCommand command);
    MealResult toResult(Meal model);
    @IterableMapping(elementTargetType = MealResult.class)
    List<MealResult> toResult(List<Meal> list);
}
