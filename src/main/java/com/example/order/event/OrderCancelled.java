package com.example.order.event;

public record OrderCancelled(String orderId) implements DomainEvent {
}
