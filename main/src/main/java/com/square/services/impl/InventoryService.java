package com.square.services.impl;

import com.square.events.impl.InventoryUpdatedEvent;
import com.square.events.impl.OrderCreatedEvent;
import com.square.services.EventListener;

public class InventoryService implements EventListener<OrderCreatedEvent> {
    @Override
    public void onEvent(OrderCreatedEvent event) {
        System.out.println("Inventory is updated with "+event.orderId);
    }
}
