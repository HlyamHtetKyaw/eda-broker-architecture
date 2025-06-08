package com.square.events.impl;

import com.square.events.Event;

public class InventoryUpdatedEvent implements Event {
    public final String productId;
    public InventoryUpdatedEvent(String productId){
        this.productId = productId;
    }
}
