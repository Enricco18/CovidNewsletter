package com.fasecovidsp.userHandler.events;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

//O spring irá criar esses métodos que lançaram os eventos com tais nomes
@Component
public interface UserHandlerProcessor {
    String GET_RULES = "get-phase";
    String NEW_RULES = "new-rules";
    String SEND_ZAP = "send-zap";
    // Código pra se inscrever em um topic e receber esses eventos
    @Input(NEW_RULES)
    SubscribableChannel getRules();

    //Código para mandar os eventos

    @Output(SEND_ZAP)
    MessageChannel sendZap();
}
