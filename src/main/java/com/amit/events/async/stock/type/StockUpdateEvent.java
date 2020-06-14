package com.amit.events.async.stock.type;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockUpdateEvent {

    private String name;

    private Double price;

    private Boolean isUp;

}
