package com.square.events.impl;

import com.square.eventValidation.ValidatableEvent;
import com.square.eventValidation.ValidationResult;
import com.square.events.Event;

public class EmailSentEvent implements ValidatableEvent {
    public final String receipient;
    public EmailSentEvent(String receipient){
        this.receipient = receipient;
    }

    @Override
    public ValidationResult validate() {
        if(receipient==null){
            return ValidationResult.error("Receipient cannot be null");
        }
        return ValidationResult.success();
    }
}
