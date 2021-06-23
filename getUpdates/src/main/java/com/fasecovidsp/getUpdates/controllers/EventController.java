package com.fasecovidsp.getUpdates.controllers;

import com.fasecovidsp.getUpdates.controllers.dto.FaseUserDTO;
import com.fasecovidsp.getUpdates.events.CovidRulesProcessor;
import com.fasecovidsp.getUpdates.models.Regras;
import com.fasecovidsp.getUpdates.repositories.RegraRepository;
import com.fasecovidsp.getUpdates.utils.CovidRuleBuilder;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Access;

@Controller
public class EventController {
    @Autowired
    private RegraRepository regraRepository;

    @Autowired
    private  CovidRulesProcessor covidRulesProcessor;

    @StreamListener(CovidRulesProcessor.GET_RULES)
    public void sendNotificationToSubscribers(String request){
        String[] data = request.split("\\|");
        Regras regra = regraRepository.findByMunicipio_Name(data[1], Sort.by(Sort.Direction.DESC,"dataCorrida"));
        System.out.println(regra.getFase().getFase());
        FaseUserDTO faseUserDTO = new FaseUserDTO();
        faseUserDTO.regras = regra;
        faseUserDTO.cel = data[0];
        covidRulesProcessor.sendRules().send(CovidRuleBuilder.message(faseUserDTO));
    }
}
