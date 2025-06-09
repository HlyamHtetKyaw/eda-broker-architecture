package com.square.events.impl;

import com.square.events.Event;

public class PaymentDeniedEvent implements Event {
    public final Long productId;
    public PaymentDeniedEvent(Long productId){
        this.productId = productId;
    }
}
