package com.square.listeners;

import com.square.events.Event;

public interface EventListener<T extends Event>{
    void onEvent(T event);
}
