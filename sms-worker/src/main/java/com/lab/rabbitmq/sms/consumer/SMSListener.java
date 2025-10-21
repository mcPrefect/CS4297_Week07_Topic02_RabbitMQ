package com.lab.rabbitmq.sms.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SMSListener {

    @RabbitListener(queues = "sms-queue")
    public void onMessage(String message) throws InterruptedException {
        System.out.println("[SMSWorker] Received: " + message);
        Thread.sleep(1500);
        System.out.println("[SMSWorker] SMS sent successfully!");
    }
}
