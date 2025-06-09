package com.square.services.impl;

import com.square.brokers.EventBroker;
import com.square.events.impl.InventoryResuppliedEvent;
import com.square.events.impl.InventoryUpdatedEvent;
import com.square.events.impl.OrderCreatedEvent;
import com.square.services.EventListener;

public class WarehouseService implements EventListener<InventoryUpdatedEvent> {
    private EventBroker broker;
    public WarehouseService(EventBroker broker){
        this.broker = broker;
    }
    @Override
    public void onEvent(InventoryUpdatedEvent event) {
        System.out.println("Warehouse notified for product: "+event.productId);
        broker.publish(new InventoryResuppliedEvent(event.productId));
    }
}