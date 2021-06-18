package com.example.demo.RulesHandler;

import com.example.demo.Model.Champion;
import com.example.demo.Model.ChampionRecommendAnswers;
import com.example.demo.Model.ChampionRecommendSession;
import com.example.demo.Model.Enums.*;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChampionRecommendHandler {

    public void championRecommendRules(ChampionRecommendAnswers answers, List<Champion> allChampions, ChampionRecommendSession crs) {
        // calculate points for lane rules
        laneRules(answers, allChampions, crs);
        // calculate points for range rules
        rangeRules(answers, allChampions, crs);
        // calculate points for ability resource rules
        abilityResourceRules(answers, allChampions, crs);
        // calculate points for damage type rules
        damageTypeRules(answers, allChampions, crs);
        // calculate points for class rules
        classRules(answers, allChampions, crs);
        // calculate points for play style rules
        playstyleRules(answers, allChampions, crs);
        // calculate points for strength rules
        strengthRules(answers, allChampions, crs);

    }
    public void laneRules(ChampionRecommendAnswers answers, List<Champion> allChampions, ChampionRecommendSession championRecommendSession) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("lane-recommend-rules");

        switch(answers.getPrefLane()){
            case TOP:
                kSession.getAgenda().getAgendaGroup("top").setFocus();
            case BOT:
                kSession.getAgenda().getAgendaGroup("bot").setFocus();
            case MID:
                kSession.getAgenda().getAgendaGroup("midlane").setFocus();
            case JUNGLE:
                kSession.getAgenda().getAgendaGroup("jungle").setFocus();
            case SUPPORT:
                kSession.getAgenda().getAgendaGroup("support").setFocus();
        }

        for(Champion champ: allChampions){
            kSession.insert(champ);
        }
        kSession.insert(championRecommendSession);
        kSession.insert(answers);
        kSession.fireAllRules();
        kSession.dispose();
    }

    public void classRules(ChampionRecommendAnswers answers, List<Champion> allChampions, ChampionRecommendSession championRecommendSession) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("class-recommend-rules");

        switch(answers.getPrefClass()){
            case BRUISER:
                kSession.getAgenda().getAgendaGroup("bruiser").setFocus();
            case MARKSMAN:
                kSession.getAgenda().getAgendaGroup("marksman").setFocus();
            case ASSASSIN:
                kSession.getAgenda().getAgendaGroup("assassin").setFocus();
            case MAGE:
                kSession.getAgenda().getAgendaGroup("mage").setFocus();
            case SUPPORT:
                kSession.getAgenda().getAgendaGroup("support").setFocus();
            case TANK:
                kSession.getAgenda().getAgendaGroup("tank").setFocus();
        }

        for(Champion champ: allChampions){
            kSession.insert(champ);
        }
        kSession.insert(championRecommendSession);
        kSession.insert(answers);
        kSession.fireAllRules();
        kSession.dispose();
    }

    public void strengthRules(ChampionRecommendAnswers answers, List<Champion> allChampions, ChampionRecommendSession championRecommendSession) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("strength-recommend-rules");

        switch(answers.getPrefStrength()){
            case EARLY_GAME:
                kSession.getAgenda().getAgendaGroup("earlygame").setFocus();
            case MID_GAME:
                kSession.getAgenda().getAgendaGroup("midgame").setFocus();
            case LATE_GAME:
                kSession.getAgenda().getAgendaGroup("lategame").setFocus();

        }

        for(Champion champ: allChampions){
            kSession.insert(champ);
        }
        kSession.insert(championRecommendSession);
        kSession.insert(answers);
        kSession.fireAllRules();
        kSession.dispose();
    }

    public void rangeRules(ChampionRecommendAnswers answers, List<Champion> allChampions, ChampionRecommendSession championRecommendSession) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("range-recommend-rules");

        switch(answers.getPrefAttackRange()){
            case MELEE:
                kSession.getAgenda().getAgendaGroup("melee").setFocus();
            case MIDRANGE:
                kSession.getAgenda().getAgendaGroup("midrange").setFocus();
            case RANGED:
                kSession.getAgenda().getAgendaGroup("ranged").setFocus();

        }

        for(Champion champ: allChampions){
            kSession.insert(champ);
        }
        kSession.insert(championRecommendSession);
        kSession.insert(answers);
        kSession.fireAllRules();
        kSession.dispose();
    }

    public void playstyleRules(ChampionRecommendAnswers answers, List<Champion> allChampions, ChampionRecommendSession championRecommendSession) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("play-style-recommend-rules");

        switch(answers.getPrefPlaystyle()){
            case ROAMING:
                kSession.getAgenda().getAgendaGroup("roaming").setFocus();
            case SPLITPUSHING:
                kSession.getAgenda().getAgendaGroup("splitpushing").setFocus();
            case TEAMFIGHTING:
                kSession.getAgenda().getAgendaGroup("teamfighting").setFocus();
        }

        for(Champion champ: allChampions){
            kSession.insert(champ);
        }
        kSession.insert(championRecommendSession);
        kSession.insert(answers);
        kSession.fireAllRules();
        kSession.dispose();
    }

    public void abilityResourceRules(ChampionRecommendAnswers answers, List<Champion> allChampions, ChampionRecommendSession championRecommendSession) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ability-resource-recommend-rules");

        switch(answers.getPrefAbilityResource()){
            case ENERGY:
                kSession.getAgenda().getAgendaGroup("energy").setFocus();
            case MANA:
                kSession.getAgenda().getAgendaGroup("mana").setFocus();
            case NOTHING:
                kSession.getAgenda().getAgendaGroup("nothing").setFocus();
            case OTHER:
                kSession.getAgenda().getAgendaGroup("other").setFocus();
        }

        for(Champion champ: allChampions){
            kSession.insert(champ);
        }
        kSession.insert(championRecommendSession);

        kSession.fireAllRules();
        kSession.dispose();
    }

    public void damageTypeRules(ChampionRecommendAnswers answers, List<Champion> allChampions, ChampionRecommendSession championRecommendSession) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("damage-type-recommend-rules");
        System.out.println(answers.getPrefDamageType());
        switch(answers.getPrefDamageType()){
            case "PHYSICAL":
                kSession.getAgenda().getAgendaGroup("physical").setFocus();
            case "MAGIC":
                kSession.getAgenda().getAgendaGroup("magic").setFocus();
        }

        for(Champion champ: allChampions){
            kSession.insert(champ);
        }
        kSession.insert(championRecommendSession);
        kSession.insert(answers);
        kSession.fireAllRules();
        kSession.dispose();
    }



}
