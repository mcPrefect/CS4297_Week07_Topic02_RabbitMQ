package com.lab.rabbitmq.order.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendNotification(String message) {
        System.out.println("[NotificationPublisher] Broadcasting: " + message);
        rabbitTemplate.convertAndSend("fanout-notification-exchange", "", message);
    }
}
