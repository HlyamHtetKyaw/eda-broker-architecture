package com.square.events.impl;

import com.square.eventValidation.ValidatableEvent;
import com.square.eventValidation.ValidationResult;
import com.square.events.Event;

public class OrderShippedEvent implements ValidatableEvent {
    public final Long productId;
    public OrderShippedEvent(Long productId){
        this.productId = productId;
    }
    @Override
    public ValidationResult validate() {
        if(productId==null){
            return ValidationResult.error("ProductId cannot be null");
        }
        return ValidationResult.success();
    }
}
