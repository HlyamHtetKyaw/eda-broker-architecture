package com.square.services.impl;

import com.square.brokers.EventBroker;
import com.square.events.impl.OrderCreatedEvent;
import com.square.events.impl.OrderFulfilledEvent;
import com.square.events.impl.OrderShippedEvent;
import com.square.services.EventListener;

public class ShippingService implements EventListener<OrderFulfilledEvent> {
    private EventBroker broker;
    public ShippingService(EventBroker broker){
        this.broker = broker;
    }
    @Override
    public void onEvent(OrderFulfilledEvent event) {
        System.out.println("Order is shipped, order number: "+event.productId);
        broker.publish(new OrderShippedEvent(event.productId));
    }
}
