package com.square.services.impl;

import com.square.events.impl.OrderCreatedEvent;
import com.square.events.impl.OrderFulfilledEvent;
import com.square.services.EventListener;

public class ShippingService implements EventListener<OrderFulfilledEvent> {
    @Override
    public void onEvent(OrderFulfilledEvent event) {
        System.out.println("Order is fulfilled for "+event.productId);
    }
}
