package com.example.order.adapter.out.inmemory;

import com.example.order.Order;
import com.example.order.application.port.out.OrderRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryOrderRepository implements OrderRepository {

    private final Map<String, Order> orders = new HashMap<>();

    @Override
    public void save(String orderId, Order order) {
        orders.put(orderId, order);
    }

    @Override
    public Optional<Order> findById(String orderId) {
        return Optional.ofNullable(orders.get(orderId));
    }
}
