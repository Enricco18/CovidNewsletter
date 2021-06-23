package com.fasecovidsp.userHandler.controllers;

import com.fasecovidsp.userHandler.controllers.dto.FaseUserDTO;
import com.fasecovidsp.userHandler.events.UserHandlerProcessor;
import com.fasecovidsp.userHandler.models.Regras;
import com.fasecovidsp.userHandler.models.Usuario;
import com.fasecovidsp.userHandler.repositories.UsuarioRepository;
import java.util.List;

import com.fasecovidsp.userHandler.utils.UserMessageBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class EventsController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UserHandlerProcessor userProcessor;

    @StreamListener(UserHandlerProcessor.NEW_RULES)
    public void sendNotificationToSubscribers(Regras regras){
            List<Usuario> usuarioList= usuarioRepository.findAllByMunicipio(regras.getMunicipio());
            FaseUserDTO faseUserDTO = new FaseUserDTO();
            faseUserDTO.regras = regras;
            usuarioList.forEach(usuario -> {
                faseUserDTO.name = usuario.getName();
                faseUserDTO.cel = usuario.getCel();
                userProcessor.sendZap().send(UserMessageBuilder.message(faseUserDTO));
            });

    }
}
