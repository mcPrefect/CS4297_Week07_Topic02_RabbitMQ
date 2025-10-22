package com.lab.rabbitmq.payment.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {

    // This listens to the queue declared in RabbitMQConfig
    @RabbitListener(queues = "payment_queue")
    public void consumeMessage(String message) {
        System.out.println("💰 PaymentWorker received message: " + message);

        try {
            Thread.sleep(3000); // simulate payment processing delay of 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        System.out.println("✅ Payment processed successfully for: " + message);
    }
}

