package com.example.order.event;

public record OrderConfirmed(String orderId) implements DomainEvent {
}
