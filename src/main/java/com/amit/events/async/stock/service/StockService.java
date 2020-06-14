package com.amit.events.async.stock.service;

import com.amit.events.async.stock.publisher.StockUpdatePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockUpdatePublisher stockUpdatePublisher;

    public void updateStock(String name, Double price, Boolean isUp){
        stockUpdatePublisher.publishStockUpdate(name, price, isUp);
    }

}
