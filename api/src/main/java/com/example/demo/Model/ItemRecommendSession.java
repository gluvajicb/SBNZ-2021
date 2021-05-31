package com.example.demo.Model;

import com.example.demo.Model.Enums.Lane;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRecommendSession {

    private Champion pickedChampion;

    private Lane pickedLane;

    private Champion enemyChampion;

    private FullBuild fullBuild;

    private DamageType enemyTeamDamageType;
}
