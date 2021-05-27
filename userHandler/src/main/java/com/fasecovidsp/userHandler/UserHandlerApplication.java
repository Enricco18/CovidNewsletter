package com.fasecovidsp.userHandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserHandlerApplication {
	//Cadastra user para receber notificação do seu estado
	public static void main(String[] args) {

		SpringApplication.run(UserHandlerApplication.class, args);
	}

}
