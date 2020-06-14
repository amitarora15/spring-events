package com.amit.events.db.order.service;

import com.amit.events.db.order.entity.Order;
import com.amit.events.db.order.publisher.OrderEventPublisher;
import com.amit.events.db.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderEventPublisher orderEventPublisher;

    private final OrderRepository orderRepository;

    @Transactional
    public Order placeOrder(String user, Long price){
        Order order = new Order(price, user);
        orderEventPublisher.publishOrderEvent(order);
        if(price < 100)
            return orderRepository.save(order);
        else
            throw new IllegalArgumentException();
    }

}
