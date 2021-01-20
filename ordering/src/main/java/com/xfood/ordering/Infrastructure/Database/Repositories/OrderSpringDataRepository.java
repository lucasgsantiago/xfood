package com.xfood.ordering.Infrastructure.Database.Repositories;

import com.xfood.ordering.Domain.IOrderRespository;
import com.xfood.ordering.Domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderSpringDataRepository implements IOrderRespository {

    @Autowired
    private IOrderRepositoryMongo dao;

    @Override
    public Order save(Order model) {
        return this.dao.save(model);
    }

    @Override
    public List<Order> getAll() {
        return this.dao.findAll();
    }
}
