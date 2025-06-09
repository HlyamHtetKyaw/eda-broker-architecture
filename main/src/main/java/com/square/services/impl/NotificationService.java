package com.square.services.impl;

import com.square.events.Event;
import com.square.events.impl.*;
import com.square.services.EventListener;

public class NotificationService implements EventListener<Event> {
    @Override
    public void onEvent(Event event) {
        switch (event){
            case OrderCreatedEvent e-> System.out.println("**Notify** Order no. "+e.orderId+" is processing");
            case PaymentAppliedEvent e-> System.out.println("**Notify** Order no."+e.productId+" is applied");
            case PaymentDeniedEvent e-> System.out.println("**Notify** Order no."+e.productId+" is denied");
            case OrderFulfilledEvent e -> System.out.println("**Notify** Order no. "+e.productId+" is prepared");
            case OrderShippedEvent e-> System.out.println("**Notify** Your order no. "+e.productId+" is shipped");
            default -> System.out.println("Unhandled event");
        }
    }
}
