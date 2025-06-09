package com.square;

import com.square.brokers.EventBroker;
import com.square.events.impl.InventoryUpdatedEvent;
import com.square.events.impl.OrderCreatedEvent;
import com.square.events.impl.PaymentAppliedEvent;
import com.square.events.impl.PlaceOrderEvent;
import com.square.services.impl.OrderFulfillmentService;
import com.square.services.impl.OrderPlacementService;
import com.square.services.impl.PaymentService;

public class Main {
    public static void main(String[] args) {
        EventBroker broker = new EventBroker();
        broker.subscribe(PlaceOrderEvent.class,new OrderPlacementService());
        broker.subscribe(PlaceOrderEvent.class,
                event->broker.publish(new OrderCreatedEvent(1289L)));
        PaymentService paymentService = new PaymentService(broker);
        broker.subscribe(OrderCreatedEvent.class, paymentService);
        broker.subscribe(PaymentAppliedEvent.class,new OrderFulfillmentService());
//        broker.subscribe(OrderPlacedEvent.class,new OrderService());
//
//        broker.subscribe(PaymentProcessedEvent.class,
//                event -> System.out.println("Logging payment: "+event.paymentId));
//        broker.subscribe(PaymentProcessedEvent.class,
//                new PaymentService());
//        broker.subscribe(InventoryUpdatedEvent.class,
//                event-> System.out.println("Inventory updated for product: "+event.productId));
//        broker.subscribe(EmailSentEvent.class,
//                event -> System.out.println("Confirmation email sent to: "+event.receipient));
//
        broker.publish(new PlaceOrderEvent("Software architecture"));
//        broker.publish(new OrderPlacedEvent("ORD-001"));
//        broker.publish(new PaymentProcessedEvent("PAY-123"));
//        broker.publish(new InventoryUpdatedEvent("PROD-456"));
//        broker.publish(new EmailSentEvent("alice@example.com"));

    }
}