package com.square;

import com.square.brokers.EventBroker;
import com.square.events.impl.*;
import com.square.services.impl.*;

public class Main {
    public static void main(String[] args) {
        EventBroker broker = new EventBroker();
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

        broker.publish(new PlaceOrderEvent("Software architecture"));

    }
}