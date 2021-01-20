package com.xfood.ordering.Domain;

import java.util.List;

public interface IOrderRespository {

    Order save(Order model);
    List<Order> getAll();

}
