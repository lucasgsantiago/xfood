package com.xfood.ordering.Application.Services;

import com.xfood.ordering.Application.Commands.CreateOrderCommand;
import com.xfood.ordering.Application.ReadModels.Results.OrderResult;
import com.xfood.ordering.Domain.IOrderRespository;
import com.xfood.ordering.Infrastructure.Mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final IOrderRespository respository;
    private final IOrderMessageService messageService;
    private OrderMapper mapper = OrderMapper.INSTANCE;

    @Override
    public void createOrder(CreateOrderCommand command) {
        var createdOrder = this.respository.save(mapper.toDomain(command));
        this.messageService.sendOrderCreated(mapper.toResult(createdOrder));
    }

    @Override
    public OrderResult getOrder(String id) {
        return null;
    }

    @Override
    public List<OrderResult> getOrders() {
        return mapper.toResult(this.respository.getAll());
    }


}
