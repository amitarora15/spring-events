package com.amit.events.db.order.event;

import com.amit.events.db.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class OrderEvent {

    private Order order;

}
