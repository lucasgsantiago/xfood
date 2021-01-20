package com.xfood.ordering.Application.Services;

import com.xfood.ordering.Application.Commands.CreateOrderCommand;
import com.xfood.ordering.Application.ReadModels.Results.OrderResult;

import java.util.List;

public interface IOrderService {
    void createOrder(CreateOrderCommand command);
    OrderResult getOrder(String id);
    List<OrderResult> getOrders();
}
