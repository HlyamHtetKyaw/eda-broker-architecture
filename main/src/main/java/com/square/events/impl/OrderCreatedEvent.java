package com.square.events.impl;

import com.square.eventValidation.ValidatableEvent;
import com.square.eventValidation.ValidationResult;
import com.square.events.Event;

public class OrderCreatedEvent implements ValidatableEvent {
    public final Long orderId;
    public final String productName;
    public OrderCreatedEvent(Long productId,String productName){
        this.orderId = productId;
        this.productName = productName;
    }

    @Override
    public ValidationResult validate() {
        if(orderId==null){
            return ValidationResult.error("OrderId cannot be null");
        }
        if(productName == null){
            return ValidationResult.error("Order name cannot be null");
        }
        return ValidationResult.success();
    }
}
