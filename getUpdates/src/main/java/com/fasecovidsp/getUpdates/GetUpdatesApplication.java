package com.fasecovidsp.getUpdates;

import com.fasecovidsp.getUpdates.events.CovidRulesProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;
//Aplicação que irá pegar os updates de covid
@SpringBootApplication
@EnableScheduling
//@EnableBinding(CovidRulesProcessor.class)
public class GetUpdatesApplication {

	public static void main(String[] args) {

		SpringApplication.run(GetUpdatesApplication.class, args);

	}

}
