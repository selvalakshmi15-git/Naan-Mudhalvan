package com.example.order.application.port.out;

import com.example.order.Order;

import java.util.Optional;

public interface OrderRepository {

    void save(String orderId, Order order);

    Optional<Order> findById(String orderId);
}
