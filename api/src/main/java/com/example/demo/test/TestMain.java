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
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestMain {
    @Autowired
    private ChampionService championService;

//    @Order(value = 1)
//    @EventListener(ApplicationReadyEvent.class)
    public void rulesTest(){

        System.out.println("\n**************CHAMPION RECOMMENDER **************\n");

        Champion aatrox = championService.getChampionByName("Aatrox");
        Champion zed = championService.getChampionByName("Zed");
        Champion malz = championService.getChampionByName("Malzahar");

        ChampionRecommendSession crSession = new ChampionRecommendSession();
        List<ChampionScore> allChampsScores = new ArrayList<>();

        allChampsScores.add(new ChampionScore(aatrox));
        allChampsScores.add(new ChampionScore(zed));
        allChampsScores.add(new ChampionScore(malz));
        crSession.setChampionList(allChampsScores);


        KieServices ks2 = KieServices.Factory.get();
        KieContainer kContainer2 = ks2.getKieClasspathContainer();
        KieSession kSession2 = kContainer2.newKieSession("lane-recommend-rules");

        System.out.println("\n***** User picked his favored lane: MIDLANE *****\n");

        kSession2.getAgenda().getAgendaGroup("midlane").setFocus();
        kSession2.insert(aatrox);
        kSession2.insert(zed);
        kSession2.insert(malz);
        kSession2.insert(crSession);
        kSession2.fireAllRules();


        KieServices playstyleKS = KieServices.Factory.get();
        KieContainer playstyleKieContainter = playstyleKS.getKieClasspathContainer();
        KieSession playstyleSession = playstyleKieContainter.newKieSession("play-style-recommend-rules");

        System.out.println("\n***** User picked his preferred playstyle : TEAMFIGHTING *****\n");

        // stavljamo agendu da ne bismo izvrsavali sva pravila za svih 150 heroja nego samo ona koja se doticu
        playstyleSession.getAgenda().getAgendaGroup("teamfighting").setFocus();
        for(ChampionScore cs: crSession.getChampionList()) {
            playstyleSession.insert(cs.getChampion());
        }

        playstyleSession.insert(crSession);

        playstyleSession.fireAllRules();



        KieServices laneKS = KieServices.Factory.get();
        KieContainer laneKC = laneKS.getKieClasspathContainer();
        KieSession laneKieSession = laneKC.newKieSession("class-recommend-rules");

        System.out.println("\n***** User picked his favorite class : BRUISER  *****\n");

        laneKieSession.getAgenda().getAgendaGroup("bruiser").setFocus();
        for(ChampionScore cs: crSession.getChampionList()) {
            laneKieSession.insert(cs.getChampion());
        }
        laneKieSession.insert(crSession);

        laneKieSession.fireAllRules();


        KieServices strengthKS = KieServices.Factory.get();
        KieContainer strengthKC = strengthKS.getKieClasspathContainer();
        KieSession strengthKieSession = strengthKC.newKieSession("strength-recommend-rules");

        System.out.println("\n***** User picked when he wants his champion to be the strongest : MID GAME  *****\n");

        strengthKieSession.getAgenda().getAgendaGroup("midgame").setFocus();
        for(ChampionScore cs: crSession.getChampionList()) {
            strengthKieSession.insert(cs.getChampion());
        }
        strengthKieSession.insert(crSession);
        strengthKieSession.fireAllRules();

        System.out.println("*********************  FINAL SCORES  ************************");
        int highestScore = 0;
        Champion highestScoreChamp = null;
        for(ChampionScore cs: crSession.getChampionList()) {
            System.out.println(cs.getChampion().getName() + " with " + cs.getScore() + " points.");
            if(cs.getScore() >= highestScore){
                highestScore = cs.getScore();
                highestScoreChamp = cs.getChampion();
            }
        }
        System.out.println("\nChampion with highest score and best recommendation: " + highestScoreChamp.getName());


    }
    


}
