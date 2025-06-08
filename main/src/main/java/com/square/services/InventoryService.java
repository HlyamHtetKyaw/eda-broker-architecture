package com.square.services;

import com.square.events.impl.InventoryUpdatedEvent;
import com.square.listeners.EventListener;

public class InventoryService implements EventListener<InventoryUpdatedEvent> {
    @Override
    public void onEvent(InventoryUpdatedEvent event) {
        System.out.println("Inventory is updated with "+event.productId);
    }
}
