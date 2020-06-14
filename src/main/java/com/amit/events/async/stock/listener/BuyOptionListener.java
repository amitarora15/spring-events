package com.amit.events.async.stock.listener;

import com.amit.events.async.stock.type.StockUpdateEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class BuyOptionListener {

    @Async
    @EventListener(condition = "#event.isUp == false")
    public void onStockUpdateEvent(StockUpdateEvent event){
        System.out.println(Thread.currentThread().getName() + ":Buy Option - " + event);
    }

}
