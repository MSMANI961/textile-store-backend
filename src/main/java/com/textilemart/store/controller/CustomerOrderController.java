package com.textilemart.store.controller;
import com.textilemart.store.entity.CustomerOrder;
import com.textilemart.store.service.CustomerOrderService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerOrderController {
    private final CustomerOrderService orderService;

    public CustomerOrderController(
            CustomerOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<CustomerOrder> createOrder(
            @RequestBody CustomerOrder order) {

        CustomerOrder savedOrder =
                orderService.createOrder(order);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedOrder);
    }
}
