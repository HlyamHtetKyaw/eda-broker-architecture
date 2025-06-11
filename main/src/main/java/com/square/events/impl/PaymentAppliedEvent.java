package com.square.events.impl;

import com.square.eventValidation.ValidatableEvent;
import com.square.eventValidation.ValidationResult;
import com.square.events.Event;

public class PaymentAppliedEvent implements ValidatableEvent {
    public final Long productId;
    public PaymentAppliedEvent(Long productId){
        this.productId = productId;
    }

    @Override
    public ValidationResult validate() {
        if(productId==null){
            return ValidationResult.error("Payment cannot proceed due to the lack of product id");
        }
        return ValidationResult.success();
    }
}
