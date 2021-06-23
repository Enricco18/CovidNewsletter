package com.fasecovidsp.whatsappInterface.util;

import org.springframework.messaging.Message;

//Método de apoio para criar mensagem
public class MessageBuilder {
    public static final <T> Message<T> message(T val) {
        return org.springframework.messaging.support.MessageBuilder.withPayload(val).build();
    }
}
