package com.amit.events.async.stock.listener;

import com.amit.events.async.stock.type.StockUpdateEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SellOptionListener {

    @Async
    @EventListener
    public void onStockUpdateEvent(StockUpdateEvent event){
        if(event.getIsUp())
            System.out.println(Thread.currentThread().getName() + ":Sell Option - " + event);
    }
}
