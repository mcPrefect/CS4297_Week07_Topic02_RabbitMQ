package com.lab.rabbitmq.email.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {

    @RabbitListener(queues = "email-queue")
    public void onMessage(String message) throws InterruptedException {
        System.out.println("[EmailWorker] Received: " + message);
        Thread.sleep(2000);
        System.out.println("[EmailWorker] Email sent successfully!");
    }
}
