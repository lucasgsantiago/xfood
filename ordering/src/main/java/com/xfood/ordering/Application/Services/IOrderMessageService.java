package com.xfood.ordering.Application.Services;

import com.xfood.ordering.Application.ReadModels.Results.OrderResult;

public interface IOrderMessageService {
    void sendOrderCreated(OrderResult order);
}
