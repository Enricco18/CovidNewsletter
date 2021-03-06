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
        String body = "Seu pedido ser?? processado e j?? trarei novas informa????es";
        switch (requestCity){
            case "Munic??pio de S??o Paulo":
            case "XVII - Taubat??":
            case "XVI - Sorocaba":
            case "XV - S??o Jos?? do Rio Preto":
            case "XIV - S??o Jo??o da Boa Vista":
            case "XIII - Ribeir??o Preto":
            case "XII - Registro":
            case "XI - Presidente Prudente":
            case "X - Piracicaba":
            case "IX - Mar??lia":
            case "VIII - Franca":
            case "VII - Campinas":
            case "VI - Bauru":
            case "V - Barretos":
            case "IV - Baixada Santista":
            case "III - Ara??atuba":
            case "Sub-regi??o Sudoeste - RMSP":
            case "Sub-regi??o Sudeste - RMSP":
            case "Sub-regi??o Oeste - RMSP":
            case "Sub-regi??o Norte - RMSP":
            case "Sub-regi??o Leste - RMSP":

                whatsappProcessor.reqRules().send(MessageBuilder.message(message.get("WaId")+ "|"+requestCity));
                System.out.println("vai");
                break;
            default:
                body = """
                        Voc?? deve pedir as informa????es pelo nome da cidade.
                        Exemplo:
                        XV - S??o Jos?? do Rio Preto
                        
                        **Lista das Cidades Dispon??veis**
                        Munic??pio de S??o Paulo
                        Sub-regi??o Leste - RMSP
                        Sub-regi??o Norte - RMSP   
                        Sub-regi??o Oeste - RMSP
                        Sub-regi??o Sudeste - RMSP
                        Sub-regi??o Sudoeste - RMSP
                        III - Ara??atuba
                        IV - Baixada Santista
                        V - Barretos
                        VI - Bauru
                        VII - Campinas
                        VIII - Franca
                        IX - Mar??lia
                        X - Piracicaba
                        XI - Presidente Prudente                                        
                        XII - Registro                                       
                        XIII - Ribeir??o Preto                                       
                        XIV - S??o Jo??o da Boa Vista                                       
                        XV - S??o Jos?? do Rio Preto                                        
                        XVI - Sorocaba                                        
                        XVII - Taubat??
                        """ ;
                break;
        }

        return body;
    }
}
