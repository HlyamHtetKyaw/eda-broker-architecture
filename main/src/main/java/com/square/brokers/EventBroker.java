package com.square.brokers;

import com.square.listeners.EventListener;
import com.square.events.Event;
import java.util.*;

public class EventBroker {
    private final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listeners = new HashMap<>();

    public <T extends Event> void subscribe(Class<T> eventType,EventListener<T> listener){
        listeners.computeIfAbsent(eventType,k -> new ArrayList<>()).add(listener);
    }

    @SuppressWarnings("unchecked")
    public <T extends Event> void publish(T event){
        List<EventListener<? extends Event>> eventListeners = listeners.getOrDefault(event.getClass(),Collections.emptyList());
        for(EventListener<? extends Event> listener : eventListeners){
            ((EventListener<T>) listener).onEvent(event);
        }
    }
}
