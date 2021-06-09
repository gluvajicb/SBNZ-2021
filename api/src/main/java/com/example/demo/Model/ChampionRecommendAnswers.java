package com.example.demo.Model;

import com.example.demo.Model.Enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChampionRecommendAnswers {

    private Lane prefLane;
    private Strength prefStrength;
    private ChampionClass prefClass;
    private String prefDamageType;
    private Playstyle prefPlaystyle;
    private Range prefAttackRange;
    private AbilityResource prefAbilityResource;

}
