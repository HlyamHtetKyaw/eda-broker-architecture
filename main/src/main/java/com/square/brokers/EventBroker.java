package com.square.brokers;

import com.square.eventValidation.ValidatableEvent;
import com.square.events.impl.PaymentAppliedEvent;
import com.square.events.impl.PaymentDeniedEvent;
import com.square.processor.WorkflowProcessor;
import com.square.services.EventListener;
import com.square.events.Event;

import java.util.*;

public class EventBroker {
    private final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listeners = new HashMap<>();
    private final WorkflowProcessor processor;
    public EventBroker(WorkflowProcessor processor){
        this.processor = processor;
    }
    public <T extends Event> void subscribe(Class<T> eventType,EventListener<? super T> listener){
        listeners.computeIfAbsent(eventType,k -> new ArrayList<>()).add(listener);
    }

    public<T extends Event> void publish(T event){
        if(event instanceof ValidatableEvent){
            processor.onEvent((ValidatableEvent) event);
        }else{
            dispatch(event);
        }
    }
    @SuppressWarnings("unchecked")
    public <T extends Event> void dispatch(T event){
        List<EventListener<? extends Event>> eventListeners = listeners.getOrDefault(event.getClass(),Collections.emptyList());
        for(EventListener<? extends Event> listener : eventListeners){
            ((EventListener<T>) listener).onEvent(event);
        }
    }
}
