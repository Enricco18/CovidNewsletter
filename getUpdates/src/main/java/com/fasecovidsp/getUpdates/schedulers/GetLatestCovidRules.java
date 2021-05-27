package com.fasecovidsp.getUpdates.schedulers;

import com.fasecovidsp.getUpdates.events.CovidRulesProcessor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GetLatestCovidRules {
    //private CovidRulesProcessor processor;
    /*
    public GetLatestCovidRules(CovidRulesProcessor processor) {
        this.processor = processor;
    }*/

    //Programa que rodará a cada dia(mudar a duranção no fixed rate) e pegará as infos atualizadas de covid das regras
    @Scheduled(fixedRate = 1000)
    public void getPhases(){
        try {
            Document doc = Jsoup.connect("https://www.saopaulo.sp.gov.br/planosp/").get();
            Elements trasitionBoxes = doc.getElementsByClass("box-fase-transicao");

            for(Element trasitionBox :trasitionBoxes){
                Elements titles = trasitionBox.getElementsByTag("h3");
                System.out.println("Um bloco");
                for(int i=0; i<titles.size();i++) {
                    System.out.println(i);
                    System.out.println(titles.get(i));
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        //processor.rulesUpdate().send(CovidRuleBuilder.message("oi"));
        //System.out.println("ois");
    }

}
