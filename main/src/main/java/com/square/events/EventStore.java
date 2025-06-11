package com.square.events;

import com.square.eventValidation.ValidatableEvent;
import com.square.events.impl.OrderCreatedEvent;

import java.util.HashMap;
import java.util.Map;

public class EventStore {
    private final Map<Long,Class<? extends Event>> failedState = new HashMap<>();
    public void markFailed(ValidatableEvent event){
        failedState.put(getEventId(event),event.getClass());
    }

    public void clearFailed(ValidatableEvent event){
        failedState.remove(getEventId(event));
    }

    public Class<? extends  Event> getLastFailedEvent(Long id){
        return failedState.get(id);
    }

    private Long getEventId(ValidatableEvent event) {
        if(event instanceof OrderCreatedEvent) return ((OrderCreatedEvent)event).orderId;
        return null;
    }
}
