package com.square.services.impl;

import com.square.brokers.EventBroker;
import com.square.events.impl.OrderCreatedEvent;
import com.square.events.impl.PlaceOrderEvent;
import com.square.services.EventListener;

public class OrderPlacementService implements EventListener<PlaceOrderEvent> {
    private EventBroker broker;
    public OrderPlacementService(EventBroker broker){
        this.broker = broker;
    }
    @Override
    public void onEvent(PlaceOrderEvent event) {
        System.out.println("Order placed for "+event.getBookTitle());
        broker.publish(new OrderCreatedEvent(event.getOrderId(),event.getBookTitle()));
    }
}
