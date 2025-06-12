package com.square;

import com.square.brokers.EventBroker;
import com.square.events.EventStore;
import com.square.events.impl.*;
import com.square.processor.WorkflowProcessor;
import com.square.services.impl.*;

public class Main {
    public static void main(String[] args) {
        EventStore store = new EventStore();
        WorkflowProcessor processor = new WorkflowProcessor(null, store);
        EventBroker broker = new EventBroker(processor);
        processor.setBroker(broker);
        broker.subscribe(PlaceOrderEvent.class,new OrderPlacementService(broker));
        broker.subscribe(OrderCreatedEvent.class,new NotificationService(broker));
        broker.subscribe(OrderCreatedEvent.class, new PaymentService(broker));
        broker.subscribe(PaymentAppliedEvent.class,new OrderFulfillmentService(broker));
        broker.subscribe(PaymentDeniedEvent.class,new NotificationService(broker));
        broker.subscribe(OrderFulfilledEvent.class,new ShippingService(broker));
        broker.subscribe(OrderFulfilledEvent.class,new NotificationService(broker));
        broker.subscribe(OrderCreatedEvent.class,new InventoryService(broker));
        broker.subscribe(InventoryUpdatedEvent.class,new WarehouseService(broker));
        broker.subscribe(OrderShippedEvent.class,new NotificationService(broker));

        broker.publish(new PlaceOrderEvent(null));
        broker.publish(new PlaceOrderEvent("Software architecture"));
    }
}