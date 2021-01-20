package com.xfood.catalog.Infrastructure.Database.Repositories;

import com.xfood.catalog.Domain.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMealRepositoryMongo extends MongoRepository<Meal,String> {
}
