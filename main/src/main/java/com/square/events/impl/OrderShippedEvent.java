package com.square.events.impl;

import com.square.events.Event;

public class OrderShippedEvent implements Event {
    public final Long productId;
    public OrderShippedEvent(Long productId){
        this.productId = productId;
    }
}
