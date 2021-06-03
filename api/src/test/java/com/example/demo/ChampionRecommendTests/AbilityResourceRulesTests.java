package com.example.demo.ChampionRecommendTests;

import com.example.demo.Model.Champion;
import com.example.demo.Model.ChampionRecommendSession;
import com.example.demo.Model.ChampionScore;
import com.example.demo.Service.ChampionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AbilityResourceRulesTests {

    @Autowired
    private ChampionService championService;

    @Test
    public void abilityResourceEnergyRules() {
        Champion nidalee = championService.getChampionByName("zed");

        ChampionRecommendSession crSession = new ChampionRecommendSession();
        List<ChampionScore> allChampsScores = new ArrayList<>();

        allChampsScores.add(new ChampionScore(nidalee));
        crSession.setChampionList(allChampsScores);


        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ability-resource-recommend-rules");
        kSession.getAgenda().getAgendaGroup("energy").setFocus();


        kSession.insert(nidalee);
        kSession.insert(crSession);
        kSession.fireAllRules();

        int finalScore = 0;
        for(ChampionScore cs: crSession.getChampionList()){
            if(cs.getChampion().getName().equalsIgnoreCase("zed")){
                finalScore = cs.getScore();
            }
        }
        assertEquals(10, finalScore);
    }

}
