package com.xfood.catalog.Domain;

import java.util.List;
import java.util.Optional;

public interface IMealRespository {
    void save(Meal model);
    List<Meal> getAll();
    Optional<Meal> getById(String id);
}
