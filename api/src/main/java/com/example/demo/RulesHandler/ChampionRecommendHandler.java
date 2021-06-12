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
        laneRules(answers.getPrefLane(), allChampions, crs);
        // calculate points for range rules
        rangeRules(answers.getPrefAttackRange(), allChampions, crs);
        // calculate points for ability resource rules
        abilityResourceRules(answers.getPrefAbilityResource(), allChampions, crs);
        // calculate points for damage type rules
//        damageTypeRules(answers.getPrefDamageType(), allChampions, crs);
        // calculate points for class rules
        classRules(answers.getPrefClass(), allChampions, crs);
        // calculate points for play style rules
        playstyleRules(answers.getPrefPlaystyle(), allChampions, crs);
        // calculate points for strength rules
        strengthRules(answers.getPrefStrength(), allChampions, crs);

    }
    public void laneRules(Lane preferredLane, List<Champion> allChampions, ChampionRecommendSession championRecommendSession) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("lane-recommend-rules");

        switch(preferredLane){
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

        kSession.fireAllRules();
        kSession.dispose();
    }

    public void classRules(ChampionClass preferredClass, List<Champion> allChampions, ChampionRecommendSession championRecommendSession) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("class-recommend-rules");

        switch(preferredClass){
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

        kSession.fireAllRules();
        kSession.dispose();
    }

    public void strengthRules(Strength prefStrength, List<Champion> allChampions, ChampionRecommendSession championRecommendSession) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("strength-recommend-rules");

        switch(prefStrength){
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

        kSession.fireAllRules();
        kSession.dispose();
    }

    public void rangeRules(Range prefRange, List<Champion> allChampions, ChampionRecommendSession championRecommendSession) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("range-recommend-rules");

        switch(prefRange){
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

        kSession.fireAllRules();
        kSession.dispose();
    }

    public void playstyleRules(Playstyle prefStyle, List<Champion> allChampions, ChampionRecommendSession championRecommendSession) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("play-style-recommend-rules");

        switch(prefStyle){
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

        kSession.fireAllRules();
        kSession.dispose();
    }

    public void abilityResourceRules(AbilityResource prefResource, List<Champion> allChampions, ChampionRecommendSession championRecommendSession) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ability-resource-recommend-rules");

        switch(prefResource){
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

    public void damageTypeRules(String damageTypeName, List<Champion> allChampions, ChampionRecommendSession championRecommendSession) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ability-resource-recommend-rules");

        switch(damageTypeName){
            case "physical":
                kSession.getAgenda().getAgendaGroup("physical").setFocus();
            case "magic":
                kSession.getAgenda().getAgendaGroup("magical").setFocus();
        }

        for(Champion champ: allChampions){
            kSession.insert(champ);
        }
        kSession.insert(championRecommendSession);

        kSession.fireAllRules();
        kSession.dispose();
    }



}
