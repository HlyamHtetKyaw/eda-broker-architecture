package com.square.services.impl;

import com.square.brokers.EventBroker;
import com.square.events.impl.OrderFulfilledEvent;
import com.square.events.impl.PaymentAppliedEvent;
import com.square.services.EventListener;

public class OrderFulfillmentService implements EventListener<PaymentAppliedEvent> {
    private EventBroker broker;
    public OrderFulfillmentService(EventBroker broker){
        this.broker = broker;
    }
    @Override
    public void onEvent(PaymentAppliedEvent event) {
        System.out.println("Order fulfilled for "+event.productId);
        broker.publish(new OrderFulfilledEvent(event.productId));
    }
}
