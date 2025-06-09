package com.square.services.impl;

import com.square.events.impl.InventoryUpdatedEvent;
import com.square.events.impl.OrderCreatedEvent;
import com.square.services.EventListener;

public class WarehouseService implements EventListener<InventoryUpdatedEvent> {
    @Override
    public void onEvent(InventoryUpdatedEvent event) {
        System.out.println("Warehouse notified for product: "+event.productId);
    }
}