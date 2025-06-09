package com.square.services.impl;

import com.square.events.impl.PlaceOrderEvent;
import com.square.services.EventListener;

public class OrderPlacementService implements EventListener<PlaceOrderEvent> {

    @Override
    public void onEvent(PlaceOrderEvent event) {
        System.out.println("Order placed for "+event.bookTitle);
    }
}
