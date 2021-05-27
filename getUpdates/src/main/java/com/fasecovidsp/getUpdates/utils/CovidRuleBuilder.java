package com.fasecovidsp.getUpdates.utils;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

//Método de apoio para criar mensagem
public class CovidRuleBuilder {
    public static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }
}
