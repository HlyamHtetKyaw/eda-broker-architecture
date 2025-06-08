package com.square.events.impl;

import com.square.events.Event;

public class UserRegisterEvent implements Event {
    public final String username;
    public UserRegisterEvent(String username){
        this.username = username;
    }

}
