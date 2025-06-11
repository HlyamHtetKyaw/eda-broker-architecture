package com.square.processor;

import com.square.brokers.EventBroker;
import com.square.eventValidation.ValidatableEvent;
import com.square.eventValidation.ValidationResult;
import com.square.events.Event;
import com.square.events.EventStore;
import com.square.services.EventListener;

public class WorkflowProcessor implements EventListener<ValidatableEvent> {
    private EventBroker broker;
    private final EventStore store;
    public WorkflowProcessor(EventBroker broker,EventStore store){
        this.broker = broker;
        this.store = store;
    }
    public void setBroker(EventBroker broker){
        this.broker = broker;
    }
    @Override
    public void onEvent(ValidatableEvent event) {
        ValidationResult result = event.validate();
        if(!result.isValid){
            System.out.println("Validation failed: "+result.errorMessage);
            store.markFailed(event);
        }else {
            store.clearFailed(event);
            broker.dispatch(event);
        }
    }
}
