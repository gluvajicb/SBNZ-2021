package com.example.demo.test;

import com.example.demo.Model.Champion;
import com.example.demo.Model.ChampionRecommendSession;
import com.example.demo.Model.ChampionScore;
import com.example.demo.Service.ChampionService;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestMain {
    @Autowired
    private ChampionService championService;

    @EventListener(ApplicationReadyEvent.class)
    public void printChamp(){
        Champion aatrox = championService.getChampionByName("Aatrox");
        System.out.println(aatrox);

        ChampionRecommendSession crSession = new ChampionRecommendSession();
        List<ChampionScore> allChampsScores = new ArrayList<>();

        allChampsScores.add(new ChampionScore(aatrox));
        crSession.setChampionList(allChampsScores);

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("play-style-recommend-rules");

        kSession.getAgenda().getAgendaGroup("teamfighting").setFocus();
        kSession.insert(aatrox);
        kSession.insert(crSession);



        kSession.fireAllRules();
//        System.out.println(ch);
    }


}
