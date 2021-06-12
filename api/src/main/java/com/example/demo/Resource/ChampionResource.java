package com.example.demo.Resource;


import com.example.demo.Model.Champion;
import com.example.demo.Service.ChampionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;


@Component
public class ChampionResource {

    @Autowired
    private ChampionService championService;


    @EventListener(ApplicationReadyEvent.class)
    public void loadChampionsFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(new File(".").getCanonicalPath());

        Champion[] champions = mapper.readValue(new File("api/src/main/resources/champions.json"), Champion[].class);

        for(Champion ch: champions) {
            championService.save(ch);
            System.out.println(ch.toString());
        }
    }
}
