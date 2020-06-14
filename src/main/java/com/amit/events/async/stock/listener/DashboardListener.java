package com.amit.events.async.stock.listener;

import com.amit.events.async.stock.type.StockUpdateEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class DashboardListener {

    @Async
    @EventListener
    public void onStockUpdateEvent(StockUpdateEvent event){
        System.out.println(Thread.currentThread().getName() + ":Dashboard Update - " + event);
    }
}
