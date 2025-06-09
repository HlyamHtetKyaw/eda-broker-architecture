package com.square.services;

import com.square.events.Event;

public interface EventListener<T extends Event>{
    void onEvent(T event);
}
