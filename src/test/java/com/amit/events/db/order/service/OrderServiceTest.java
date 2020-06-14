package com.amit.events.db.order.service;

import com.amit.events.db.order.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("test")
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderServiceUnderTest;

    @Test
    public void createOrder_success_withGoodies() {
        Order order = orderServiceUnderTest.placeOrder("Amit", 90L);
        assertEquals("Amit", order.getUser());
        assertEquals(true, order.getHasGoodiesAdded());
    }

    @Test
    public void createOrder_Fail_withGoodies() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderServiceUnderTest.placeOrder("Amit", 110L);
        });

    }
}
