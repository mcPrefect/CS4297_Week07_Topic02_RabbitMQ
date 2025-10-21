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
            Thread.sleep(2000); // simulate payment processing delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("✅ Payment processed successfully for: " + message);
    }
}

