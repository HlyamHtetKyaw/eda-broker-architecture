package com.square.events.impl;

import com.square.events.Event;

public class EmailSentEvent implements Event {
    public final String receipient;
    public EmailSentEvent(String receipient){
        this.receipient = receipient;
    }
}
