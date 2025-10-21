package com.lab.rabbitmq.payment.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Exchange name must match the producer
    public static final String PAYMENT_EXCHANGE = "direct_payment_exchange";

    // Queue and routing key
    public static final String PAYMENT_QUEUE = "payment_queue";
    public static final String PAYMENT_ROUTING_KEY = "payment_key";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(PAYMENT_EXCHANGE);
    }

    @Bean
    public Queue paymentQueue() {
        return new Queue(PAYMENT_QUEUE, true);
    }

    @Bean
    public Binding binding(Queue paymentQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(paymentQueue).to(directExchange).with(PAYMENT_ROUTING_KEY);
    }
}
