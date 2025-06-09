package com.square.events.impl;

import com.square.events.Event;

public class PaymentAppliedEvent implements Event {
    public final Long productId;
    public PaymentAppliedEvent(Long productId){
        this.productId = productId;
    }
}
