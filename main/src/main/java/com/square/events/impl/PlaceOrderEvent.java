package com.square.events.impl;

import com.square.events.Event;

public class PlaceOrderEvent implements Event {
    public final String bookTitle;
    public PlaceOrderEvent(String bookTitle){
        this.bookTitle = bookTitle;
    }
}
