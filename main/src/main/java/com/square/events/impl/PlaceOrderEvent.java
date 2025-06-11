package com.square.events.impl;

import com.square.eventValidation.ValidatableEvent;
import com.square.eventValidation.ValidationResult;
import com.square.events.Event;

public class PlaceOrderEvent implements ValidatableEvent {
    public final String bookTitle;
    public PlaceOrderEvent(String bookTitle){
        this.bookTitle = bookTitle;
    }

    @Override
    public ValidationResult validate() {
        if(bookTitle==null){
            return ValidationResult.error("BookTitle cannot be null");
        }
        return ValidationResult.success();
    }
}
