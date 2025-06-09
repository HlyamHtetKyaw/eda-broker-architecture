package com.square.services.impl;

import com.square.events.impl.PaymentAppliedEvent;
import com.square.services.EventListener;

public class OrderFulfillmentService implements EventListener<PaymentAppliedEvent> {

    @Override
    public void onEvent(PaymentAppliedEvent event) {
        System.out.println("Order fulfilled for "+event.productId);
    }
}
