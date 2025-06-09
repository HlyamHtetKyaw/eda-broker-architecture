package com.square.services.impl;

import com.square.brokers.EventBroker;
import com.square.events.impl.InventoryUpdatedEvent;
import com.square.events.impl.OrderCreatedEvent;
import com.square.services.EventListener;

public class InventoryService implements EventListener<OrderCreatedEvent> {
    private EventBroker broker;
    public InventoryService(EventBroker broker){
        this.broker = broker;
    }
    @Override
    public void onEvent(OrderCreatedEvent event) {
        System.out.println("Inventory is updated with "+event.orderId);
        broker.publish(new InventoryUpdatedEvent(event.orderId));
    }
}
