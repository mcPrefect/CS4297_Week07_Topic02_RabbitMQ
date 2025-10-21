package com.lab.rabbitmq.order;

import com.lab.rabbitmq.order.publisher.PaymentPublisher;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {

	@Autowired
	private PaymentPublisher paymentPublisher; // injects your PaymentPublisher bean

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@PostConstruct
	public void sendTestMessage() {
		// runs automatically after app starts
		paymentPublisher.sendPaymentRequest("Order12345");
	}
}
