package com.square.services;

import com.square.events.impl.PaymentProcessedEvent;
import com.square.listeners.EventListener;

public class PaymentService implements EventListener<PaymentProcessedEvent> {
    @Override
    public void onEvent(PaymentProcessedEvent event) {
        System.out.println("Payment is processed for "+event.paymentId);
    }
}
