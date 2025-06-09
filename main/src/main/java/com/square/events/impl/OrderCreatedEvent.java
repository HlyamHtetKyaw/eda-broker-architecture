package com.square.events.impl;

import com.square.events.Event;

public class OrderCreatedEvent implements Event {
    public final Long orderId;
    public OrderCreatedEvent(Long productId){
        this.orderId = productId;
    }
}
