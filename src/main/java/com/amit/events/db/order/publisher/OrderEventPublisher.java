package com.amit.events.db.order.publisher;

import com.amit.events.db.order.entity.Order;
import com.amit.events.db.order.event.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public void publishOrderEvent(Order order){
        System.out.println(Thread.currentThread().getName() + ": Event Publisher");
        eventPublisher.publishEvent(new OrderEvent(order));
    }
}
