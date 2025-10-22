package com.lab.rabbitmq.order.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final String exchangeName = "fanout-notification-exchange";

    public NotificationPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNotification(String message) {
        System.out.println("[NotificationPublisher] Broadcasting notification: " + message);
        rabbitTemplate.convertAndSend(exchangeName, "", message);  // Empty routing key for fanout exchange
    }
}


