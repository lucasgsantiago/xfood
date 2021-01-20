package com.xfood.catalog.Infrastructure.Database.Repositories;

import com.xfood.catalog.Domain.IMealRespository;
import com.xfood.catalog.Domain.Meal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MealSpringDataRepository implements IMealRespository {

    private final IMealRepositoryMongo dao;

    @Override
    public void save(Meal model) {
        this.dao.save(model);
    }

    @Override
    public List<Meal> getAll() {
        return this.dao.findAll();
    }

    @Override
    public Optional<Meal> getById(String id) {
        return this.dao.findById(id);
    }
}
