package com.square.services.impl;

import com.square.brokers.EventBroker;
import com.square.events.Event;
import com.square.events.impl.OrderCreatedEvent;
import com.square.events.impl.PaymentAppliedEvent;
import com.square.events.impl.PaymentDeniedEvent;
import com.square.services.EventListener;

public class PaymentService implements EventListener<OrderCreatedEvent> {
    private EventBroker broker;
    boolean success = false;
    public PaymentService(EventBroker broker){
        this.broker = broker;
    }
    @Override
    public void onEvent(OrderCreatedEvent event) {
        System.out.println("Processing payment for order " + event.orderId);
        if(success){
            System.out.println("**** Payment succeed ****");
            broker.publish(new PaymentAppliedEvent(event.orderId));
        }else{
            System.out.println("**** Payment failed ****");
            success = true;
            broker.publish(new OrderCreatedEvent(event.orderId,event.productName));
            broker.publish(new PaymentDeniedEvent(event.orderId));
        }
    }
}
