package com.square;

import com.square.brokers.EventBroker;
import com.square.events.impl.*;
import com.square.services.EmailService;
import com.square.services.OrderService;

public class Main {
    public static void main(String[] args) {
        EventBroker broker = new EventBroker();
        broker.subscribe(UserRegisterEvent.class,new EmailService());
        broker.subscribe(OrderPlacedEvent.class,new OrderService());

        broker.subscribe(PaymentProcessedEvent.class,
                event -> System.out.println("Logging payment: "+event.paymentId));

        broker.subscribe(InventoryUpdatedEvent.class,
                event-> System.out.println("Inventory updated for product: "+event.productId));
        broker.subscribe(EmailSentEvent.class,
                event -> System.out.println("Confirmation email sent to: "+event.receipient));

        broker.publish(new UserRegisterEvent("alice"));
        broker.publish(new OrderPlacedEvent("ORD-001"));
        broker.publish(new PaymentProcessedEvent("PAY-123"));
        broker.publish(new InventoryUpdatedEvent("PROD-456"));
        broker.publish(new EmailSentEvent("alice@example.com"));
    }
}