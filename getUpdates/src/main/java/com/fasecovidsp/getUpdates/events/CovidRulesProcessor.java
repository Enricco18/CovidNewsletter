package com.fasecovidsp.getUpdates.events;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

//O spring irá criar esses métodos que lançaram os eventos com tais nomes
@Component
public interface CovidRulesProcessor {
    String NEW_AGE = "new-age";
    String NEW_PHASE = "new-phase";
    String NEW_RULES = "new-rules";

    // Código pra se inscrever em um topic e receber esses eventos
   // @Input(APPLICATIONS_IN)
  //  SubscribableChannel sourceOfLoanApplications();

    //Código para mandar os eventos
    @Output(NEW_AGE)
    MessageChannel ageUpdate();

    @Output(NEW_PHASE)
    MessageChannel phaseUpdate();

    @Output(NEW_RULES)
    MessageChannel rulesUpdate();
}