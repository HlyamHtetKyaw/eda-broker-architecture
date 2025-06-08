package com.square.services;

import com.square.events.impl.UserRegisterEvent;
import com.square.listeners.EventListener;

public class EmailService implements EventListener<UserRegisterEvent> {

    @Override
    public void onEvent(UserRegisterEvent event) {
        System.out.println("Sending welcome message to "+event.username);
    }
}
