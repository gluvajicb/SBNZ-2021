package com.example.demo.Model;

import com.example.demo.Model.Enums.Lane;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRecommendSession {

    private Champion pickedChampion;

    private Lane pickedLane;

    private Champion enemyChampion;

    private List<Champion> allEnemyChampions;

    private FullBuild fullBuild;

    private DamageType enemyTeamDamageType;

    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean startingItemGiven = false;

    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean bootsItemGiven = false;

    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean mythicItemGiven = false;

    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean situationalItemGiven = false;

    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean defensiveItemGiven = false;

    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean offensiveItemGiven = false;

}
