package com.example.demo.RulesHandler;

import com.example.demo.Model.*;
import com.example.demo.Model.Enums.ItemSlot;
import com.example.demo.Service.ChampionService;
import com.example.demo.Service.ItemService;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuildRecommendHandler {

    private final ChampionService championService;
    private final ItemService itemService;

    @Autowired
    public BuildRecommendHandler(ChampionService championService, ItemService itemService){
        this.championService = championService;
        this.itemService = itemService;
    }

    public void buildRecommendRules(BuildRecommendAnswers answers, ItemRecommendSession irs){

        List<Item> startingItems = itemService.findAllItemsByItemSlot(ItemSlot.STARTING);
        List<Item> bootItems = itemService.findAllItemsByItemSlot(ItemSlot.BOOTS);
        List<Item> situationalItems = itemService.findAllItemsByItemSlot(ItemSlot.SITUATIONAL);
        List<Item> defensiveItems = itemService.findAllItemsByItemSlot(ItemSlot.DEFENSIVE);
        List<Item> offensiveItems = itemService.findAllItemsByItemSlot(ItemSlot.OFFENSIVE);
        List<Item> mythicItems = itemService.findAllItemsByItemSlot(ItemSlot.MYTHIC);

        irs.setFullBuild(new FullBuild());
        irs.setPickedLane(answers.getPickedLane());
        irs.setPickedChampion(championService.getChampionByName(answers.getPickedChampion()));
        irs.setEnemyChampion(championService.getChampionByName(answers.getEnemyChampionName()));

        //opet damage type jer branja troluje sa json fajlom sa champovima
        DamageType dt = new DamageType(80,20);
        irs.getPickedChampion().setDamageType(new DamageType(60,40));
        irs.getEnemyChampion().setDamageType(dt);
        ////////////////////////////////////////////////

        String[] enemyChampionsNamesList = answers.getEnemyChampionsList().split(",");
        List<Champion> enemyChampions = new ArrayList<>();

        for(String name: enemyChampionsNamesList) {
            // ovo isto nepotrebno kasnije
            Champion ch = championService.getChampionByName(name);
            ch.setDamageType(dt);
            /////////////////////////
            enemyChampions.add(ch);
        }
        irs.setAllEnemyChampions(enemyChampions);

        startingItemRules(answers.getEarlyGamePlaystyle(), startingItems, irs);
        bootsRules(bootItems, irs);
        mythicItemRules(mythicItems, irs);
        situationalItemRules(situationalItems, irs);
        defensiveItemRules(defensiveItems, irs);
        offensiveItemRules(offensiveItems, irs);

    }


    public void startingItemRules(String earlyGamePlaystyle, List<Item> startingItems, ItemRecommendSession irs) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("starting-item-recommend-rules");

        switch(earlyGamePlaystyle) {
            case "sustain":
                kSession.getAgenda().getAgendaGroup("sustain").setFocus();
            case "defensive":
                kSession.getAgenda().getAgendaGroup("defensive").setFocus();
            case "offensive":
                kSession.getAgenda().getAgendaGroup("offensive").setFocus();
            case "support":
                kSession.getAgenda().getAgendaGroup("support").setFocus();
        }

        for(Item i: startingItems) {
            System.out.println(i.toString());
            kSession.insert(i);
        }
        kSession.insert(irs);
        kSession.fireAllRules();
        kSession.dispose();
    }

    public void bootsRules(List<Item> bootItems, ItemRecommendSession irs) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("boots-recommend-rules");

        for(Item i: bootItems) {
            kSession.insert(i);
        }
        kSession.insert(irs);
        kSession.fireAllRules();
        kSession.dispose();
    }

    public void mythicItemRules(List<Item> mythicItems, ItemRecommendSession irs) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("mythic-item-recommend-rules");

        for(Item i: mythicItems) {
            kSession.insert(i);
        }
        kSession.insert(irs);
        kSession.fireAllRules();
        kSession.dispose();
    }

    public void situationalItemRules(List<Item> situationalItems, ItemRecommendSession irs) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("situational-item-recommend-rules");

        for(Item i: situationalItems) {
            kSession.insert(i);
        }
        kSession.insert(irs);
        kSession.fireAllRules();
        kSession.dispose();
    }

    public void offensiveItemRules(List<Item> offensiveItems, ItemRecommendSession irs) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("offensive-item-recommend-rules");

        for(Item i: offensiveItems) {
            kSession.insert(i);
        }
        kSession.insert(irs);
        kSession.fireAllRules();
        kSession.dispose();
    }

    public void defensiveItemRules(List<Item> defensiveItems, ItemRecommendSession irs) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("defensive-item-recommend-rules");

        for(Item i: defensiveItems) {
            kSession.insert(i);
        }
        kSession.insert(irs);
        kSession.fireAllRules();
        kSession.dispose();
    }
}
