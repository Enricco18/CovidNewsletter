package com.fasecovidsp.userHandler;

import com.fasecovidsp.userHandler.events.UserHandlerProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(UserHandlerProcessor.class)
public class UserHandlerApplication {

	//Cadastra user para receber notificação do seu estado
	public static void main(String[] args) {

		SpringApplication.run(UserHandlerApplication.class, args);

	}

}
