package com.square.events.impl;

import com.square.events.Event;

public class OrderFulfilledEvent implements Event {
    public final Long productId;
    public OrderFulfilledEvent(Long productId){
        this.productId = productId;
    }
}
