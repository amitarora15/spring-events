package com.amit.events.async.stock.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class StockServiceTest {

    @Resource
    private StockService stockService;

    @Test
    public void stockUp_priceUp_SellOption_Async(){
        stockService.updateStock("Tesla", 233.33, true);
    }

    @Test
    public void stockUp_priceDown_BuyOption_Async(){
        stockService.updateStock("Cipla", 67.90, false);
    }

}
