package com.example.order.event;

public record PaymentRecorded(String orderId) implements DomainEvent {
}
