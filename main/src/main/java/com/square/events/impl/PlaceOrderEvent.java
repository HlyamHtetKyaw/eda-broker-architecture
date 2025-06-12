package com.square.events.impl;

import com.square.eventValidation.ValidatableEvent;
import com.square.eventValidation.ValidationResult;
import com.square.events.Event;

public class PlaceOrderEvent implements ValidatableEvent {
    public final String bookTitle;
    public final Long orderId;
    public PlaceOrderEvent(String bookTitle,Long orderId){
        this.bookTitle = bookTitle;
        this.orderId = orderId;
    }

    @Override
    public ValidationResult validate() {
        if(bookTitle==null){
            return ValidationResult.error("BookTitle cannot be null");
        }
        if(orderId == null){
            return ValidationResult.error("Id cannot be null");
        }
        return ValidationResult.success();
    }
}
