package com.square.events;

import com.square.eventValidation.ValidatableEvent;
import com.square.events.impl.OrderCreatedEvent;
import com.square.events.impl.PlaceOrderEvent;
import com.square.services.impl.OrderPlacementService;

import java.util.HashMap;
import java.util.Map;

public class EventStore {
    private final Map<Long,Class<? extends Event>> failedState = new HashMap<>();
    public void markFailed(ValidatableEvent event){
        failedState.put(getEventId(event),event.getClass());
        System.out.println("Fail state id: "+getEventId(event));
    }

    public void clearFailed(ValidatableEvent event){
        failedState.remove(getEventId(event));
    }

    public Class<? extends  Event> getLastFailedEvent(Long id){
        return failedState.get(id);
    }

    private Long getEventId(ValidatableEvent event) {
        switch (event){
            case OrderCreatedEvent e -> {
                return e.orderId;
            }
            case PlaceOrderEvent e-> {
                return e.getOrderId();
            }
            default -> {return null;}
        }
    }
}
