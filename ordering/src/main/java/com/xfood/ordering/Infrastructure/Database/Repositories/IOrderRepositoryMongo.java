package com.xfood.ordering.Infrastructure.Database.Repositories;

import com.xfood.ordering.Domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IOrderRepositoryMongo extends MongoRepository<Order,String> {
}
