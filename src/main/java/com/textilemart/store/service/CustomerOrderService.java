package com.textilemart.store.service;
import org.springframework.stereotype.Service;

import com.textilemart.store.entity.CustomerOrder;
import com.textilemart.store.repository.CustomerOrderRepository;
@Service
public class CustomerOrderService {
     private final CustomerOrderRepository orderRepository;

    public CustomerOrderService(
            CustomerOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public CustomerOrder createOrder(CustomerOrder order) {

        // Set initial order status
        order.setStatus("PLACED");

        // Set order date
        order.setOrderDate(
                java.time.LocalDateTime.now()
        );

        // Save the order in PostgreSQL
        return orderRepository.save(order);
    }
}
