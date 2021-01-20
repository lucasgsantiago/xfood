package com.xfood.ordering.Presentation.Controllers;

import com.xfood.ordering.Application.Commands.CreateOrderCommand;
import com.xfood.ordering.Application.ReadModels.Results.OrderResult;
import com.xfood.ordering.Application.Services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping
    public List<OrderResult> getOrders(){
        return this.orderService.getOrders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderCommand command){
        this.orderService.createOrder(command);
        return ResponseEntity.ok().body(command);
    }

    @GetMapping("{id}")
    public OrderResult getOrder(@PathVariable String id){
        return this.orderService.getOrder(id);
    }
}
