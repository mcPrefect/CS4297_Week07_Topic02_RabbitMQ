package com.lab.rabbitmq.order.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectExchangeConfig {
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_payment_exchange");
    }
}
