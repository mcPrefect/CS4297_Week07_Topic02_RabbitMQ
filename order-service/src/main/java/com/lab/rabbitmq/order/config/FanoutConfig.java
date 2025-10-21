package com.lab.rabbitmq.order.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout-notification-exchange");
    }
}
