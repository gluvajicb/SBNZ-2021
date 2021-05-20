package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChampionScore {

    private Champion champion;

    private int score;

    public void updateScore(int points) {
        this.score += points;
    }
}