package com.square.services;

import com.square.events.impl.OrderPlacedEvent;
import com.square.events.impl.UserRegisterEvent;
import com.square.listeners.EventListener;

public class OrderService implements EventListener<OrderPlacedEvent> {

    @Override
    public void onEvent(OrderPlacedEvent event) {
        System.out.println("Placing order"+event.orderId);
    }
}
