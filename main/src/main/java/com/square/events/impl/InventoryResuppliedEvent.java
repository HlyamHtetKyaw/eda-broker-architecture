package com.square.events.impl;

import com.square.events.Event;

public class InventoryResuppliedEvent implements Event {
    public final Long productId;
    public InventoryResuppliedEvent(Long productId){
        this.productId = productId;
    }
}
