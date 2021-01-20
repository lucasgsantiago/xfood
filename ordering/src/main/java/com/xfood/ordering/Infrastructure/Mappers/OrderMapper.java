package com.xfood.ordering.Infrastructure.Mappers;


import com.xfood.ordering.Application.Commands.CreateOrderCommand;
import com.xfood.ordering.Application.ReadModels.Results.OrderResult;
import com.xfood.ordering.Domain.Order;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toDomain(CreateOrderCommand command);
    OrderResult toResult(Order model);
    @IterableMapping(elementTargetType = OrderResult.class)
    List<OrderResult> toResult(List<Order> list);
}
