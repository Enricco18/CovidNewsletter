package com.fasecovidsp.whatsappInterface;

import com.fasecovidsp.whatsappInterface.events.WhatsappProcessor;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

@SpringBootApplication
@EnableBinding(WhatsappProcessor.class)
public class WhatsappInterfaceApplication {

	// Manda msg no zap para o usuário cadastrado https://www.twilio.com/docs/whatsapp/quickstart/java
	public static void main(String[] args) {
		SpringApplication.run(WhatsappInterfaceApplication.class, args);
	}


}
