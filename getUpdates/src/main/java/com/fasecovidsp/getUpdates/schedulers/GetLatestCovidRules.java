package com.fasecovidsp.getUpdates.schedulers;

import com.fasecovidsp.getUpdates.events.CovidRulesProcessor;
import com.fasecovidsp.getUpdates.models.FaseRegras;
import com.fasecovidsp.getUpdates.models.Municipio;
import com.fasecovidsp.getUpdates.models.Regras;
import com.fasecovidsp.getUpdates.repositories.FaseRegrasRepository;
import com.fasecovidsp.getUpdates.repositories.MunicipioRepository;
import com.fasecovidsp.getUpdates.repositories.RegraRepository;
import com.fasecovidsp.getUpdates.utils.CovidRuleBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class GetLatestCovidRules {
    @Autowired
    private FaseRegrasRepository faseRegrasRepository;
    @Autowired
    private MunicipioRepository municipioRepository;
    @Autowired
    private RegraRepository regraRepository;

    private CovidRulesProcessor processor;

    public GetLatestCovidRules(CovidRulesProcessor processor) {
        this.processor = processor;
    }

    //Programa que rodará a cada dia(mudar a duranção no fixed rate) e pegará as infos atualizadas de covid das regras
    @Scheduled(fixedRate = 1000000000)
    public void getPhases(){
        try {
            FaseRegras faseRegras;
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            Document doc = Jsoup.connect("https://www.saopaulo.sp.gov.br/planosp/").get();
            Element transitionContainer = doc.getElementsByClass("regras-de-transicao").first();

            //Se nao tiver em fase de transição estará na fase estipulada no mapa.
            if(transitionContainer != null){
                Element transitionBox = transitionContainer.select("div[class=box-fase-transicao]").first();
                Element recommendationBox =  transitionContainer.select("div.recomendacoes").first();
                Elements transitionParagraphs = transitionBox.getElementsByTag("p");
                Elements recommendationParagraphs = recommendationBox.getElementsByTag("p");

                String recommendations = "";
                for (Element recommendation:recommendationParagraphs
                     ) {
                    recommendations += recommendation.text()+";";
                }

                LocalDateTime today = LocalDateTime.now();
                String formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault()).format(today);

                //Cria nova Fase de transição com as infos do site
                faseRegras = new FaseRegras();
                faseRegras.setFase("Fase-"+formattedDate);

                faseRegras.setComercialActivities(transitionParagraphs.get(0).text());
                faseRegras.setReligiousActivities(transitionParagraphs.get(1).text());
                faseRegras.setRestaurantActivities(transitionParagraphs.get(3).text());
                faseRegras.setCulturalActivities(transitionParagraphs.get(4).text());
                faseRegras.setSportsActivities(transitionParagraphs.get(5).text());
                faseRegras.setBeautySalonsActivities(transitionParagraphs.get(6).text());
                faseRegras.setRecomendations(recommendations);

                faseRegrasRepository.save(faseRegras);

                Regras novaRegra;

                List<Municipio> municipios = municipioRepository.findAll();

                for (Municipio municipio:municipios){
                    novaRegra = new Regras();
                    novaRegra.setMunicipio(municipio);
                    novaRegra.setDataCorrida(today.toLocalDate());
                    novaRegra.setFase(faseRegras);
                    regraRepository.save(novaRegra);
                    Regras olgRegra = regraRepository.findByDataCorrida(today.minusDays(1).toLocalDate());

                    if(!(novaRegra.equals(olgRegra))){
                        processor.rulesUpdate().send(CovidRuleBuilder.message(objectMapper.writeValueAsString(novaRegra)));
                    }

                };

                return;
            }

            Elements regionButtons = doc.getElementsByClass("regiao-mapa");
            LocalDateTime today = LocalDateTime.now();
            for (Element region: regionButtons
                 ) {
                String fase = region.attr("data-fase-regiao").replaceAll("\\s+","");
                String municipoName = region.text();

                faseRegras = faseRegrasRepository.findByFase(fase);
                Municipio  municipio = municipioRepository.findByName(municipoName);

                Regras novaRegra = new Regras();
                novaRegra.setMunicipio(municipio);
                novaRegra.setDataCorrida(today.toLocalDate());
                novaRegra.setFase(faseRegras);
                regraRepository.save(novaRegra);
                Regras olgRegra = regraRepository.findByDataCorrida(today.minusDays(1).toLocalDate());

                if(!(novaRegra.equals(olgRegra))){
                    processor.rulesUpdate().send(CovidRuleBuilder.message(objectMapper.writeValueAsString(novaRegra)));
                }


            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
