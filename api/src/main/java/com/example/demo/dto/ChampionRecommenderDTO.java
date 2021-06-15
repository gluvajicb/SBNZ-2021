package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChampionRecommenderDTO {
    private String firstPick;
    private String secondPick;
    private String thirdPick;
}
