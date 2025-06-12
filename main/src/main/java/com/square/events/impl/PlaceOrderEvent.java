package com.square.events.impl;

import com.square.eventValidation.ValidatableEvent;
import com.square.eventValidation.ValidationResult;
import com.square.events.Event;

public class PlaceOrderEvent implements ValidatableEvent {
    private String bookTitle;
    private final Long orderId;
    public PlaceOrderEvent(String bookTitle,Long orderId){
        this.bookTitle = bookTitle;
        this.orderId = orderId;
    }
    public void setBookTitle(String bookTitle){
        this.bookTitle = bookTitle;
    }
    public String getBookTitle(){
        return this.bookTitle;
    }
    public Long getOrderId(){
        return this.orderId;
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
