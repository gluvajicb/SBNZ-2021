package com.example.demo.test;

import com.example.demo.Model.Champion;
import com.example.demo.Service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TestMain {
    @Autowired
    private ChampionService championService;

    @EventListener(ApplicationReadyEvent.class)
    public void printChamp(){
        Champion ch = championService.getChampionByName("Aatrox");
        System.out.println(ch);
    }


}
