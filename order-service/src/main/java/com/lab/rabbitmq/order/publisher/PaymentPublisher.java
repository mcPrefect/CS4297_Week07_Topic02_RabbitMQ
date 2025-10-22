package com.lab.rabbitmq.order.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final String exchangeName = "direct_payment_exchange";
    private final String routingKey = "payment_key";

    public PaymentPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendPaymentRequest(String orderId) {
        System.out.println("[PaymentPublisher] Sending payment message for order: " + orderId);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, "Payment request for Order ID: " + orderId);
    }
}

