package com.amit.events.async.stock.publisher;

import com.amit.events.async.stock.type.StockUpdateEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockUpdatePublisher {

    private final ApplicationEventPublisher eventPublisher;

    public void publishStockUpdate(String name, Double price, Boolean isUp){
        StockUpdateEvent event = new StockUpdateEvent(name, price, isUp);
        eventPublisher.publishEvent(event);
        System.out.println("Event Publish complete in async way");
    }

}
