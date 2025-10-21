package com.lab.rabbitmq.order.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentPublisher {

    private static final String EXCHANGE_NAME = "direct_payment_exchange";
    private static final String ROUTING_KEY = "payment_key";


    private final RabbitTemplate rabbitTemplate;

    public PaymentPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendPaymentRequest(String orderId) {
        String message = "Payment request for Order ID: " + orderId;
        System.out.println("[OrderService] Sending message: " + message);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
    }
}

