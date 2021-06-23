package com.fasecovidsp.whatsappInterface.controllers;

import com.fasecovidsp.whatsappInterface.controllers.dto.FaseUserDTO;
import com.fasecovidsp.whatsappInterface.events.WhatsappProcessor;
import com.fasecovidsp.whatsappInterface.util.MessageBuilder;
import com.fasecovidsp.whatsappInterface.util.MessageFormatter;
import com.twilio.Twilio;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiML;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class EventController {

    @Autowired
    public WhatsappProcessor whatsappProcessor;

    @GetMapping("/")
    public String helloWorld(String nome){
        if(nome==null){
            return "Hello World";
        }
        return "Hello, "+ nome;
    }

    @StreamListener(WhatsappProcessor.SEND_ZAP)
    public void sendNotificationToSubscribers(FaseUserDTO faseUserDTO){
        String body = MessageFormatter.formatFase(faseUserDTO);
        Twilio.init("AC7af9bb76282225b30578f32aec634996", "156c8d4ecfa07bfc6571978352f692aa");
        com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:"+faseUserDTO.cel),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                body)
                .create();

        System.out.println(message.getSid());

    }

    @PostMapping(path = "/incoming",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String vem( @RequestParam Map<String, String> message){
        System.out.println();
        String requestCity = message.get("Body");
        String body = "Seu pedido será processado e já trarei novas informações";
        switch (requestCity){
            case "Município de São Paulo":
            case "XVII - Taubaté":
            case "XVI - Sorocaba":
            case "XV - São José do Rio Preto":
            case "XIV - São João da Boa Vista":
            case "XIII - Ribeirão Preto":
            case "XII - Registro":
            case "XI - Presidente Prudente":
            case "X - Piracicaba":
            case "IX - Marília":
            case "VIII - Franca":
            case "VII - Campinas":
            case "VI - Bauru":
            case "V - Barretos":
            case "IV - Baixada Santista":
            case "III - Araçatuba":
            case "Sub-região Sudoeste - RMSP":
            case "Sub-região Sudeste - RMSP":
            case "Sub-região Oeste - RMSP":
            case "Sub-região Norte - RMSP":
            case "Sub-região Leste - RMSP":

                whatsappProcessor.reqRules().send(MessageBuilder.message(message.get("WaId")+ "|"+requestCity));
                System.out.println("vai");
                break;
            default:
                body = """
                        Você deve pedir as informações pelo nome da cidade.
                        Exemplo:
                        XV - São José do Rio Preto
                        
                        **Lista das Cidades Disponíveis**
                        Município de São Paulo
                        Sub-região Leste - RMSP
                        Sub-região Norte - RMSP   
                        Sub-região Oeste - RMSP
                        Sub-região Sudeste - RMSP
                        Sub-região Sudoeste - RMSP
                        III - Araçatuba
                        IV - Baixada Santista
                        V - Barretos
                        VI - Bauru
                        VII - Campinas
                        VIII - Franca
                        IX - Marília
                        X - Piracicaba
                        XI - Presidente Prudente                                        
                        XII - Registro                                       
                        XIII - Ribeirão Preto                                       
                        XIV - São João da Boa Vista                                       
                        XV - São José do Rio Preto                                        
                        XVI - Sorocaba                                        
                        XVII - Taubaté
                        """ ;
                break;
        }

        return body;
    }
}
