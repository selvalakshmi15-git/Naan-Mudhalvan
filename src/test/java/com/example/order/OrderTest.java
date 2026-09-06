package com.example.order;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void orderCanBeConfirmedWhenItHasLines() {
        Order order = new Order();
        order.addLine(new OrderLine("Book", 2, BigDecimal.valueOf(100)));

        order.confirm();

        assertEquals(OrderStatus.CONFIRMED, order.status());
    }

    @Test
    void emptyOrderCannotBeConfirmed() {
        Order order = new Order();

        assertThrows(IllegalStateException.class, order::confirm);
    }

    @Test
    void cancelledOrderCannotBePaid() {
        Order order = new Order();
        order.addLine(new OrderLine("Book", 1, BigDecimal.valueOf(100)));
        order.cancel();

        assertThrows(IllegalStateException.class, order::recordPayment);
    }

    @Test
    void totalIsCalculatedFromLines() {
        Order order = new Order();
        order.addLine(new OrderLine("Book", 2, BigDecimal.valueOf(100)));
        order.addLine(new OrderLine("Pen", 3, BigDecimal.valueOf(20)));

        assertEquals(BigDecimal.valueOf(260), order.total());
    }
}
