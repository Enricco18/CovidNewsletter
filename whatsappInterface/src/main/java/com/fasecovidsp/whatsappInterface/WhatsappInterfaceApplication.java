package com.fasecovidsp.whatsappInterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

@SpringBootApplication
public class WhatsappInterfaceApplication {
	private static final Logger log = LoggerFactory.getLogger(WhatsappInterfaceApplication.class);
	// Manda msg no zap para o usuário cadastrado https://www.twilio.com/docs/whatsapp/quickstart/java
	public static void main(String[] args) {
		SpringApplication.run(WhatsappInterfaceApplication.class, args);
		log.info("The Whatsapp Application has started...");
	}

}
