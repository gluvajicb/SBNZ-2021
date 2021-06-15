package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.RulesHandler.ChampionRecommendHandler;
import com.example.demo.Service.ChampionService;
import com.example.demo.dto.ChampionRecommenderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ChampionRecommenderController {

    private final ChampionService championService;
    private final ChampionRecommendHandler championRecommendHandler;

    @Autowired
    public ChampionRecommenderController(ChampionService championService, ChampionRecommendHandler championRecommendHandler){
        this.championService = championService;
        this.championRecommendHandler = championRecommendHandler;
    }

    @PostMapping(value = "/champion-recommender")
    public ResponseEntity<ChampionRecommenderDTO> recommendChampions(@RequestBody ChampionRecommendAnswers answers){
        // answers is a class that contains all the answers a user made on the client
        // and every answer is passed to a specific handler to handle the rules
        List<Champion> allChampions = championService.getAllChampions();
        ChampionRecommendSession crs = new ChampionRecommendSession(allChampions);

        // handle all the rules and all the points
        this.championRecommendHandler.championRecommendRules(answers, allChampions, crs);

        for(ChampionScore cs: crs.getChampionList()){
            System.out.println(cs.getChampion().getName() + " has : "  + cs.getScore() + " points!");
        }
        List<ChampionScore> top3 = crs.getChampionList().stream()
                .sorted(Comparator.comparing(ChampionScore::getScore).reversed())
                .limit(3)
                .collect(Collectors.toList());

        ChampionRecommenderDTO finalRecommendations = new ChampionRecommenderDTO(top3.get(0).getChampion().getName(),
                                                                                top3.get(1).getChampion().getName(),
                                                                                top3.get(2).getChampion().getName());
        return new ResponseEntity<>(finalRecommendations, HttpStatus.OK);
    }
}
