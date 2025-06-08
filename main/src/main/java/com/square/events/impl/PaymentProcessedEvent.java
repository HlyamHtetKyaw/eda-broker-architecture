package com.square.events.impl;

import com.square.events.Event;

public class PaymentProcessedEvent implements Event {
    public final String paymentId;
    public PaymentProcessedEvent(String paymentId){
        this.paymentId = paymentId;
    }
}
