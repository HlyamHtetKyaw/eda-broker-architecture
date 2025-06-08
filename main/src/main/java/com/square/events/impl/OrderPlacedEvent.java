package com.square.events.impl;

import com.square.events.Event;

public class OrderPlacedEvent implements Event {
    public final String orderId;
    public OrderPlacedEvent(String orderId){
        this.orderId = orderId;
    }
}
