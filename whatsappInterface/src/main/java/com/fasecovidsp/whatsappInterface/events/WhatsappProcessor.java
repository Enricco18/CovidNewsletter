package com.fasecovidsp.whatsappInterface.events;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

//O spring irá criar esses métodos que lançaram os eventos com tais nomes
@Component
public interface WhatsappProcessor {
     String  GET_RULES = "get-rules";
     String SEND_ZAP = "send-zap";
    // Código pra se inscrever em um topic e receber esses eventos
    @Input(SEND_ZAP)
    SubscribableChannel getZAP();

    //Código para mandar os eventos

    @Output(GET_RULES)
    MessageChannel reqRules();
}
