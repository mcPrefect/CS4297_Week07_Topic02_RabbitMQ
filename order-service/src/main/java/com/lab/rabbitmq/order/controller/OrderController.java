package com.lab.rabbitmq.order.controller;

import com.lab.rabbitmq.order.publisher.PaymentPublisher;
import com.lab.rabbitmq.order.publisher.NotificationPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final PaymentPublisher paymentPublisher;
    private final NotificationPublisher notificationPublisher;

    public OrderController(PaymentPublisher paymentPublisher,
                           NotificationPublisher notificationPublisher) {
        this.paymentPublisher = paymentPublisher;
        this.notificationPublisher = notificationPublisher;
    }

    @PostMapping("/place-order")
    public ResponseEntity<String> placeOrder(@RequestBody String orderId) {
        System.out.println("[OrderController] Received order request: " + orderId);
        // existing direct-exchange flow
        paymentPublisher.sendPaymentRequest(orderId);

        // new fanout broadcast
        notificationPublisher.sendNotification("Order " + orderId + " confirmed – notify customers.");

        return ResponseEntity.accepted().body("Order placed successfully!");
    }
}
