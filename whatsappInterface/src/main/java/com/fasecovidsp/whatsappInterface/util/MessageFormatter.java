package com.fasecovidsp.whatsappInterface.util;

import com.fasecovidsp.whatsappInterface.controllers.dto.FaseUserDTO;

public class MessageFormatter {
    public static String formatFase(FaseUserDTO faseUserDTO){
        String body = String.format("""
                NOVA ATUALIZAÇÃO - %s
                Nome: %s
                Município: %s
                Atividades Comerciais:
                %s
                
                Atividades Religiosas:
                %s
                
                Restaurantes e afins:
                %s
                
                Cultura e outros:
                %s
                
                Academias de Esporte:
                %s
                
                Salão de Beleza e Barbearia:
                %s
                
                Recomenações:
                %s
                """,
                faseUserDTO.regras.getDataCorrida().toString(),
                faseUserDTO.regras.getFase().getFase(),
                faseUserDTO.regras.getMunicipio().name,
                faseUserDTO.regras.getFase().getComercialActivities(),
                faseUserDTO.regras.getFase().getReligiousActivities(),
                faseUserDTO.regras.getFase().getRestaurantActivities(),
                faseUserDTO.regras.getFase().getCulturalActivities(),
                faseUserDTO.regras.getFase().getSportsActivities(),
                faseUserDTO.regras.getFase().getBeautySalonsActivities(),
                faseUserDTO.regras.getFase().getRecomendations()
        );
        return body;
    }
}
