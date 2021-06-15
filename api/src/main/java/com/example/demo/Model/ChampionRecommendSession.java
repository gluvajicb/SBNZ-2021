package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ChampionRecommendSession {

    private List<ChampionScore> championList;

    public ChampionRecommendSession(List<Champion> allChampions){
        this.championList = new ArrayList<>();
        for(Champion ch: allChampions) {
            this.championList.add(new ChampionScore(ch));
        }
    }

    public void updateScore(Champion champion, int points) {
        for(ChampionScore ch: this.championList) {
            if(ch.getChampion().getName().equalsIgnoreCase(champion.getName())){
                ch.updateScore(points);
            }
        }
    }

}
