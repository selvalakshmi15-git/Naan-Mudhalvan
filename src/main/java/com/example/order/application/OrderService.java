package com.example.order.application;

import com.example.order.Order;
import com.example.order.application.port.out.OrderRepository;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(String orderId, Order order) {
        orderRepository.save(orderId, order);
    }

    public Order getOrder(String orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    public void confirmOrder(String orderId) {
        Order order = getOrder(orderId);
        order.confirm();
        orderRepository.save(orderId, order);
    }

    public void recordPayment(String orderId) {
        Order order = getOrder(orderId);
        order.recordPayment();
        orderRepository.save(orderId, order);
    }

    public void cancelOrder(String orderId) {
        Order order = getOrder(orderId);
        order.cancel();
        orderRepository.save(orderId, order);
    }
}
