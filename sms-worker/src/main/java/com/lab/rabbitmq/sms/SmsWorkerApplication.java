package com.lab.rabbitmq.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmsWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsWorkerApplication.class, args);
	}

}
