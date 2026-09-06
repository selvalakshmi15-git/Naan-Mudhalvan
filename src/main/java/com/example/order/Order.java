package com.example.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private OrderStatus status = OrderStatus.DRAFT;
    private final List<OrderLine> lines = new ArrayList<>();

    public void addLine(OrderLine line) {
        if (status != OrderStatus.DRAFT) {
            throw new IllegalStateException("Lines can be added only in DRAFT");
        }
        lines.add(line);
    }

    public void confirm() {
        if (lines.isEmpty()) {
            throw new IllegalStateException("Order must contain at least one line");
        }
        if (status != OrderStatus.DRAFT) {
            throw new IllegalStateException("Only DRAFT order can be confirmed");
        }
        status = OrderStatus.CONFIRMED;
    }

    public void recordPayment() {
        if (status == OrderStatus.CANCELLED) {
            throw new IllegalStateException("Cancelled order cannot be paid");
        }
        if (status != OrderStatus.CONFIRMED) {
            throw new IllegalStateException("Only CONFIRMED order can be paid");
        }
        status = OrderStatus.PAID;
    }

    public void cancel() {
        if (status == OrderStatus.PAID) {
            throw new IllegalStateException("Paid order cannot be cancelled");
        }
        status = OrderStatus.CANCELLED;
    }

    public OrderStatus status() {
        return status;
    }

    public List<OrderLine> lines() {
        return List.copyOf(lines);
    }

    public BigDecimal total() {
        return lines.stream()
                .map(OrderLine::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
