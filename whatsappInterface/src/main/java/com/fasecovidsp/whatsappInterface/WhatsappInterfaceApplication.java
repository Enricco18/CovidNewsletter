package com.fasecovidsp.whatsappInterface;

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
@PropertySource("classpath:application.properties")
public class WhatsappInterfaceApplication {
	@Value( "${twilio.account.sid}" )
	private static String ACCOUNT_SID = "AC7af9bb76282225b30578f32aec634996";

	@Value( "${twilio.auth.token}" )
	private static String AUTH_TOKEN = "c523ae3cebafa278c568f8e42ef6ee4a";

	// Manda msg no zap para o usuário cadastrado https://www.twilio.com/docs/whatsapp/quickstart/java
	public static void main(String[] args) {
		SpringApplication.run(WhatsappInterfaceApplication.class, args);
		System.out.println(ACCOUNT_SID);
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		com.twilio.rest.api.v2010.account.Message message = Message.creator(
				new com.twilio.type.PhoneNumber("whatsapp:+15005550006"),
				new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
				"Hello there!")
				.create();

		System.out.println(message.getBody());
	}


}
